package com.bb.hw;

import com.backblaze.b2.client.contentHandlers.B2ContentMemoryWriter;

/**
 * This class is customized so that getData() can be override since the
 * constructor of B2ContentMemoryWriter is private, the inheritance is
 * disallowed
 * 
 * @author : ayu
 * @date creation time：Mar 31, 2020 21:15:15 PM
 * @version 1.0
 */

public class B2ContentMemoryWriterDelegator {

    private B2ContentMemoryWriter writer;

    public B2ContentMemoryWriterDelegator(boolean use) {
        if (use) {
            writer = B2ContentMemoryWriter.build();
        }
    }

    public B2ContentMemoryWriter getB2ContentMemoryWriter() {
        return writer;
    }

    public byte[] getData() {
        if (writer != null) {
            return writer.getBytes();
        }
        return new byte[0];
    }
}
