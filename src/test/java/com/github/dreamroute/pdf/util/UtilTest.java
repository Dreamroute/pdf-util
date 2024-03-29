package com.github.dreamroute.pdf.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

class UtilTest {
    
    private static final int x = 8;
    private static final int y = 478;
    private static final float imgWidth = 50;
    private static final float imgHeight = 112;
//    private static final float rotation = 90F;
    private static final float rotation = 0F;

    /**
     * itext
     */
    @Test
    void signItextTest() {
        try (InputStream docIn = new FileInputStream("d:/xxx.pdf");
             InputStream imgIn = new FileInputStream("d:/sign.png");
             OutputStream out = new FileOutputStream("d:/result.pdf")) {
            out.write(SignUtil.sign(docIn, imgIn, x, y, imgWidth, imgHeight, rotation,  1));
            Assertions.assertTrue(true);
        } catch (Exception e) {
            throw new PdfUtilException(e.getMessage(), e);
        }
    }

}
