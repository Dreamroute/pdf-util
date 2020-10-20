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
    public static byte[] addImgToDoc(InputStream docInput, InputStream imgInput, int x, int y, float imgWidth, float imgHeight, float rotation, int[] pageNum) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            PdfReader reader = new PdfReader(docInput);
            PdfStamper stamp = new PdfStamper(reader, baos);
            stamp.setRotateContents(false);
            byte[] imgBytes = new byte[imgInput.available()];
            IOUtils.read(imgInput, imgBytes);

            Image img = Image.getInstance(imgBytes);

            img.setAbsolutePosition(x, y);
            for (int pn : pageNum) {
                int rr = reader.getPageRotation(pn) / 90;
                if (rr % 2 == 1) {
                    float t = imgWidth;
                    imgWidth = imgHeight;
                    imgHeight = t;
                }
                img.scaleAbsoluteWidth(imgWidth);
                img.scaleAbsoluteHeight(imgHeight);
                img.setRotationDegrees(rotation + reader.getPageRotation(pn)); // 旋转角度
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
