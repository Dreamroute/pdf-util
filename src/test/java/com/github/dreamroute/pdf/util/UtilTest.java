package com.github.dreamroute.pdf.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.jupiter.api.Test;

import com.github.dreamroute.pdf.util.exception.PdfUtilException;

public class UtilTest {
    
    private static final int x = 10;
    private static final int y = 20;
    
    /**
     * itext
     */
    @Test
    public void signItextTest() {
        try (InputStream docIn = new FileInputStream(new File("d:/mm.pdf"));
                InputStream imgIn = new FileInputStream(new File("d:/tm.png"));
                OutputStream out = new FileOutputStream(new File("d:/result3.pdf"))) {
            out.write(SignUtil.sign(docIn, imgIn, x, y));
        } catch (Exception e) {
            throw new PdfUtilException(e.getMessage(), e);
        }
    }
    
    /**
     * spire
     */
    @Test
    public void signSpireTest() {
        try (InputStream docIn = new FileInputStream(new File("d:/mm.pdf"));
                InputStream imgIn = new FileInputStream(new File("d:/tm.png"));
                OutputStream out = new FileOutputStream(new File("d:/result4.pdf"))) {
            out.write(SignUtil.sign(Type.SPIRE, docIn, imgIn, x, y));
        } catch (Exception e) {
            throw new PdfUtilException(e.getMessage(), e);
        }
    }
    
}
