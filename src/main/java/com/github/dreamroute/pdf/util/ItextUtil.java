package com.github.dreamroute.pdf.util;

import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * 基于Itext框架
 * 
 * @author w.dehai
 *
 */
@Slf4j
class ItextUtil {

    private ItextUtil() {}

    /**
     * 将一个图片添加到PDF文件上，类似签名
     */
    public static byte[] addImgToDoc(InputStream docInput, InputStream imgInput, int x, int y, float imgWidth, float imgHeight, int[] pageNum) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            PdfReader reader = new PdfReader(docInput);
            PdfStamper stamp = new PdfStamper(reader, baos);
            byte[] imgBytes = new byte[imgInput.available()];
            IOUtils.read(imgInput, imgBytes);

            Image img = Image.getInstance(imgBytes);
            img.scaleAbsoluteWidth(imgWidth);
            img.scaleAbsoluteHeight(imgHeight);

            img.setAbsolutePosition(x, y);
            for (int pn : pageNum) {
                PdfContentByte over = stamp.getOverContent(pn);
                over.addImage(img);
            }
            stamp.close();
            reader.close();
        } catch (Exception e) {
            throw new PdfUtilException("PDF签名失败", e);
        }
        return baos.toByteArray();
    }

}
