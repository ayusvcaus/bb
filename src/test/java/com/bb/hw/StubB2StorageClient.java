package com.bb.hw;

import java.util.concurrent.ExecutorService;

import com.backblaze.b2.client.B2FilePolicy;
import com.backblaze.b2.client.B2ListFilesIterable;
import com.backblaze.b2.client.B2ListKeysIterable;
import com.backblaze.b2.client.B2ListPartsIterable;
import com.backblaze.b2.client.B2StorageClient;
import com.backblaze.b2.client.B2StorageClientWebifier;
import com.backblaze.b2.client.contentHandlers.B2ContentSink;
import com.backblaze.b2.client.exceptions.B2Exception;
import com.backblaze.b2.client.structures.B2AccountAuthorization;
import com.backblaze.b2.client.structures.B2ApplicationKey;
import com.backblaze.b2.client.structures.B2Bucket;
import com.backblaze.b2.client.structures.B2CancelLargeFileRequest;
import com.backblaze.b2.client.structures.B2CreateBucketRequest;
import com.backblaze.b2.client.structures.B2CreateKeyRequest;
import com.backblaze.b2.client.structures.B2CreatedApplicationKey;
import com.backblaze.b2.client.structures.B2DeleteBucketRequest;
import com.backblaze.b2.client.structures.B2DeleteFileVersionRequest;
import com.backblaze.b2.client.structures.B2DeleteKeyRequest;
import com.backblaze.b2.client.structures.B2DownloadAuthorization;
import com.backblaze.b2.client.structures.B2DownloadByIdRequest;
import com.backblaze.b2.client.structures.B2DownloadByNameRequest;
import com.backblaze.b2.client.structures.B2FileVersion;
import com.backblaze.b2.client.structures.B2FinishLargeFileRequest;
import com.backblaze.b2.client.structures.B2GetDownloadAuthorizationRequest;
import com.backblaze.b2.client.structures.B2GetFileInfoByNameRequest;
import com.backblaze.b2.client.structures.B2GetFileInfoRequest;
import com.backblaze.b2.client.structures.B2GetUploadPartUrlRequest;
import com.backblaze.b2.client.structures.B2GetUploadUrlRequest;
import com.backblaze.b2.client.structures.B2HideFileRequest;
import com.backblaze.b2.client.structures.B2ListBucketsRequest;
import com.backblaze.b2.client.structures.B2ListBucketsResponse;
import com.backblaze.b2.client.structures.B2ListFileNamesRequest;
import com.backblaze.b2.client.structures.B2ListFileVersionsRequest;
import com.backblaze.b2.client.structures.B2ListKeysRequest;
import com.backblaze.b2.client.structures.B2ListPartsRequest;
import com.backblaze.b2.client.structures.B2ListUnfinishedLargeFilesRequest;
import com.backblaze.b2.client.structures.B2StartLargeFileRequest;
import com.backblaze.b2.client.structures.B2UpdateBucketRequest;
import com.backblaze.b2.client.structures.B2UploadFileRequest;
import com.backblaze.b2.client.structures.B2UploadPartUrlResponse;
import com.backblaze.b2.client.structures.B2UploadUrlResponse;

/**
 * This is an empty class for unit test only
 * 
 * @author : ayu
 * @date creation time：Mar 31, 2020 21:10:15 PM
 * @version 1.0
 */

public class StubB2StorageClient implements B2StorageClient {

    @Override
    public String getAccountId() throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public B2FilePolicy getFilePolicy() throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public B2Bucket createBucket(B2CreateBucketRequest request) throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public B2CreatedApplicationKey createKey(B2CreateKeyRequest request) throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public B2ListKeysIterable applicationKeys(B2ListKeysRequest request) throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public B2ApplicationKey deleteKey(B2DeleteKeyRequest request) throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public B2ListBucketsResponse listBuckets(B2ListBucketsRequest listBucketsRequest) throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public B2FileVersion uploadSmallFile(B2UploadFileRequest request) throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public B2FileVersion uploadLargeFile(B2UploadFileRequest request, ExecutorService executor) throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public B2FileVersion finishUploadingLargeFile(B2FileVersion fileVersion, B2UploadFileRequest request,
            ExecutorService executor) throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public B2ListFilesIterable fileVersions(B2ListFileVersionsRequest request) throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public B2ListFilesIterable fileNames(B2ListFileNamesRequest request) throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public B2ListFilesIterable unfinishedLargeFiles(B2ListUnfinishedLargeFilesRequest request) throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public B2ListPartsIterable parts(B2ListPartsRequest request) throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void cancelLargeFile(B2CancelLargeFileRequest cancelRequest) throws B2Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void downloadById(B2DownloadByIdRequest request, B2ContentSink handler) throws B2Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void downloadByName(B2DownloadByNameRequest request, B2ContentSink handler) throws B2Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteFileVersion(B2DeleteFileVersionRequest request) throws B2Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public B2DownloadAuthorization getDownloadAuthorization(B2GetDownloadAuthorizationRequest request)
            throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public B2FileVersion getFileInfo(B2GetFileInfoRequest request) throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public B2FileVersion getFileInfoByName(B2GetFileInfoByNameRequest request) throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public B2FileVersion hideFile(B2HideFileRequest request) throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public B2Bucket updateBucket(B2UpdateBucketRequest request) throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public B2Bucket deleteBucket(B2DeleteBucketRequest request) throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getDownloadByIdUrl(B2DownloadByIdRequest request) throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getDownloadByNameUrl(B2DownloadByNameRequest request) throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public B2AccountAuthorization getAccountAuthorization() throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void invalidateAccountAuthorization() {
        // TODO Auto-generated method stub

    }

    @Override
    public B2UploadUrlResponse getUploadUrl(B2GetUploadUrlRequest request) throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public B2UploadPartUrlResponse getUploadPartUrl(B2GetUploadPartUrlRequest request) throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public B2FileVersion startLargeFile(B2StartLargeFileRequest request) throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public B2FileVersion finishLargeFile(B2FinishLargeFileRequest request) throws B2Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub

    }

    @Override
    public B2StorageClientWebifier getWebifier() {
        // TODO Auto-generated method stub
        return null;
    }
}
