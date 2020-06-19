package com.github.dreamroute.pdf.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class UtilTest {
    
    private static final int x = 400;
    private static final int y = 20;
    private static final float imgWidth = 100;
    private static final float imgHeight = 100;
    private static final float rotation = 90F;

    /**
     * itext
     */
    @Test
    public void signItextTest() {
        try (InputStream docIn = new FileInputStream(new File("d:/source.pdf"));
                InputStream imgIn = new FileInputStream(new File("d:/sign.png"));
                OutputStream out = new FileOutputStream(new File("d:/result1.pdf"))) {
            out.write(SignUtil.sign(docIn, imgIn, x, y, imgWidth, imgHeight, rotation, 1, 2));
            Assertions.assertTrue(true);
        } catch (Exception e) {
            throw new PdfUtilException(e.getMessage(), e);
        }
    }

}
