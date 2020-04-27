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
    

    @Test
    public void spireAddImgToDocTest() {
        try (InputStream docIn = new FileInputStream(new File("d:/mm.pdf"));
                InputStream imgIn = new FileInputStream(new File("d:/tm1.png"));
                OutputStream out = new FileOutputStream(new File("d:/result3.pdf"))) {
            out.write(SpireUtil.addImgToDoc(docIn, imgIn, x, y));
        } catch (Exception e) {
            throw new PdfUtilException(e.getMessage(), e);
        }
    }

    @Test
    public void itextAddImgToDocTest() {
        try (InputStream docIn = new FileInputStream(new File("d:/mm.pdf"));
                InputStream imgIn = new FileInputStream(new File("d:/tm1.png"));
                OutputStream out = new FileOutputStream(new File("d:/result4.pdf"))) {
            out.write(ItextUtil.addImgToDoc(docIn, imgIn, x, y));
        } catch (Exception e) {
            throw new PdfUtilException(e.getMessage(), e);
        }
    }
    
}
