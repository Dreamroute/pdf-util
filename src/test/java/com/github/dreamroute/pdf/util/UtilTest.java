package com.github.dreamroute.pdf.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class UtilTest {
    
    private static final int x = 12;
    private static final int y = 4;
    private static final float imgWidth = 110;
    private static final float imgHeight = 50;
//    private static final float rotation = 90F;
    private static final float rotation = 0F;

    /**
     * itext
     */
    @Test
    public void signItextTest() {
        try (InputStream docIn = new FileInputStream(new File("d:/source.pdf"));
                InputStream imgIn = new FileInputStream(new File("d:/sign.png"));
                OutputStream out = new FileOutputStream(new File("d:/result1.pdf"))) {
            out.write(SignUtil.sign(docIn, imgIn, x, y, imgWidth, imgHeight, rotation,  2));
            Assertions.assertTrue(true);
        } catch (Exception e) {
            throw new PdfUtilException(e.getMessage(), e);
        }
    }

}
