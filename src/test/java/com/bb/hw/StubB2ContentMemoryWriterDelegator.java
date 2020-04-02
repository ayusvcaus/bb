package com.bb.hw;

/** 
* This class is for unit test only, the getData() is overridden
* 
* @author : ayu
* @date creation time：Mar 31, 2020 21:15:15 PM 
* @version 1.0 
*/

public class StubB2ContentMemoryWriterDelegator extends B2ContentMemoryWriterDelegator {

    private byte[] data;
    
    public StubB2ContentMemoryWriterDelegator() {
    	super(false);
    }
    
    public void setData(String s) {
    	if (s!=null) {
    	    data=s.getBytes();
    	} else {
    		data=new byte[0];
    	}
    }
    
    @Override
    public byte[] getData() {
    	return data;
    }
}
