package com.github.dreamroute.pdf.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.jupiter.api.Test;

import com.github.dreamroute.pdf.util.exception.PdfUtilException;

public class SpireUtilTest {

    @Test
    public void addImgToDocTest() {
        try (InputStream docIn = new FileInputStream(new File("d:/mm.pdf"));
                InputStream imgIn = new FileInputStream(new File("d:/tm.png"));
                OutputStream out = new FileOutputStream(new File("d:/result3.pdf"))) {
            out.write(SpireUtil.addImgToDoc(docIn, imgIn, 100, 100));
        } catch (Exception e) {
            throw new PdfUtilException(e.getMessage(), e);
        }
    }

}
