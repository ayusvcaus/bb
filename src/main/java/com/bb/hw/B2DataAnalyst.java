package com.bb.hw;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.io.PrintWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.backblaze.b2.client.B2Sdk;
import com.backblaze.b2.client.B2StorageClient;
import com.backblaze.b2.client.B2StorageClientFactory;
import com.backblaze.b2.client.exceptions.B2Exception;
import com.backblaze.b2.client.structures.B2Bucket;
import com.backblaze.b2.client.structures.B2FileVersion;

/** 
* @author : ayu
* @date creation time：Mar 7, 2020 2:55:15 AM 
* @version 1.0 
*/
public class B2DataAnalyst {
	
    private static final Logger s_logger=LogManager.getLogger(B2DataAnalyst.class);

    private static final String USER_AGENT="HomeWork";
    
    private static PrintWriter errWriter=new PrintWriter(System.err, true);

    public static void main(String[] args) throws B2Exception {
        if (args==null || args.length<2) {
        	String err="Invalid arguments!";
        	errWriter.println("--- Error: "+err);
            s_logger.error(err);
            System.exit(1);
        }
        s_logger.info("Running with " + B2Sdk.getName() + " version " + B2Sdk.getVersion());
        try (final B2StorageClient client=B2StorageClientFactory.createDefaultFactory().create(args[0], args[1], USER_AGENT)) {
        	/*
        	 * The data structure handling sorting
        	 */
        	Queue<FileObject> queue=new PriorityQueue<>();
        	/*
        	 * Getting data and sorting
        	 */ 
            process(client, queue);
            /*
             * Output data onto console
             */
            PrintWriter writer=new PrintWriter(System.out, true);
            writer.println("\n\n\n--- Start to print the result ---\n");
            while (!queue.isEmpty()) {
            	FileObject fo=queue.poll();
            	writer.println(fo.getCount()+"  "+fo.getFileName());
            }
        } catch (B2Exception be) {
        	String err="B2Exception code: "+be.getCode()+",  status: "+be.getStatus()+", message: "+be.getMessage();
        	errWriter.println("--- Error: "+err);
        	s_logger.error(err);
        	System.exit(1);
        } catch (Exception e) {
        	String err="An Exception was caught";
        	errWriter.println("--- Error: "+err);
        	errWriter.println("--- Error: "+e.toString());
        	s_logger.error(err);
        	s_logger.debug(e.toString());
        	e.printStackTrace(errWriter);
        	System.exit(1);
        } 
    }
    
    
    /**
     * Getting all buckets and all versions then put files into a priority queue
     * @param client: the consumer of B2 storage server; queue: a priority queue
     * @throws B2Exception if there's any trouble.
     */     
    private static void process(B2StorageClient client, Queue<FileObject> queue) throws B2Exception {
    	s_logger.info("Start to process .... ");
    	B2ContentMemoryWriterDelegator sink=new B2ContentMemoryWriterDelegator();
    	if (sink!=null) {
    	    List<B2Bucket> buckets=pullBuckets(client);
            for (B2Bucket bucket: buckets) {
                List<B2FileVersion> versions=fetchVersions(client, bucket.getBucketId());
                for (B2FileVersion version: versions) {
                    downloadFileContent(client, version, sink, queue);
                }
            }
    	} 
    }
    
      
    /**
     * All buckets convered by the applcation key are taken
     * @param client: the consumer of B2 storage server
     * @return A list of buckets
     * @throws B2Exception if there are any troubles.
     */ 
    private static List<B2Bucket> pullBuckets(B2StorageClient client) throws B2Exception {
    	List<B2Bucket> buckets=new ArrayList<>();
    	s_logger.info("List buckets");
        for (B2Bucket scan : client.buckets()) {
        	s_logger.info("bucketId: " + scan.getBucketId());
            buckets.add(scan);
        }
        s_logger.info(buckets.size()+" bucket(s) were found");
        return buckets;
    }
    
    /**
     * All versions belonging to the buckets are taken
     * @param client: the consumer of B2 storage server; bucketId: a string of bucket identity
     * @return A list of B2FileVersion
     * @throws B2Exception if there are any troubles.
     */ 
    private static List<B2FileVersion> fetchVersions(B2StorageClient client, String bucketId) throws B2Exception {
    	List<B2FileVersion> versions=new ArrayList<>();
    	s_logger.info("Fetch files with bucketId: "+bucketId);
        for (B2FileVersion version : client.fileVersions(bucketId)) {
            versions.add(version);
        }
        s_logger.info(versions.size()+" file version(s) were found");
        return versions;
    }
    
    /**
     * A file is downloaded from B2 storage server, and the priority queue handle sorting
     * The cases with null fieldId, null fileName, or null file content are not considered
     * @param client: the consumer of B2 storage server; version: a B2FileVersio object; queue: a priority queue
     * @throws B2Exception if there are any troubles.
     */
    public static void downloadFileContent(B2StorageClient client, B2FileVersion version, B2ContentMemoryWriterDelegator sink, Queue<FileObject> queue) throws B2Exception {
    	s_logger.info("Try to download a file");
        String fieldId=version.getFileId();
        if (fieldId!=null) {
            String fileName=version.getFileName();
            if (fileName!=null) {
            	s_logger.debug("File name: " +fileName);
                client.downloadById(fieldId, sink.getB2ContentMemoryWriter());
                String content=new String(sink.getData());
                s_logger.debug("File content: [" + content + "]");
                queue.offer(new FileObject(fileName, content, 'a'));
            } else {
            	String err="fileName is null, fieldId: "+fieldId;
            	errWriter.println("--- Error: "+err);
            	s_logger.error(err);
            }
        } else {
        	String err="fieldId is null";
        	errWriter.println("--- Error: "+err);
        	s_logger.error(err);
        }
    }
}