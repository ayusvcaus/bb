package com.bb.hw;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** 
* A POJO of file with counting
* @author : ayu
* @date creation time：Mar 8, 2020 12:58:21 AM 
* @version 1.0 
*/
public class FileObject implements Comparable<FileObject> {
	
	private static final Logger s_logger=LogManager.getLogger(FileObject.class);

	private String fileName;
	private char concernedChar;
	private int count;
	
	public FileObject(String fileName, String content, char concernedChar) {
		this.fileName=fileName;
		this.concernedChar=concernedChar;
		
		countConcernedChar(content);
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public char getConcernChar() {
		return concernedChar;
	}


	public int getCount() {
		return count;
	}
	
	/*
	 * Get count of the concerned character
	 */	
	private void countConcernedChar(String content) {
		if (content!=null) {
			for (char c : content.toCharArray()) {
				if (c==concernedChar) {
					count++;
				}
			}
		}
		s_logger.debug("File name: "+fileName+", concerned char: '"+concernedChar+"',  count: "+count);
	}
	
	/*
	 * Compare 2 objects on the counts, then on the file names in case the counts are the same
	 */
	@Override
	public int compareTo(FileObject fe) {
		int diff=this.count-fe.getCount();
	    return diff==0 ? this.fileName.compareTo(fe.getFileName()) : diff;
	}
}
