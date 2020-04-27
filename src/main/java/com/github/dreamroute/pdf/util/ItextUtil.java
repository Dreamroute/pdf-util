package com.github.dreamroute.pdf.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.github.dreamroute.pdf.util.exception.PdfUtilException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import lombok.extern.slf4j.Slf4j;

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
     * 
     * @param docInput PDF文件
     * @param imgInput 图片文件
     * @param x 相对于左下角x坐标
     * @param y 相对于左下角y坐标
     * @return 返回完成后的PDF文件字节数组
     */
    public static final byte[] addImgToDoc(InputStream docInput, InputStream imgInput, int x, int y) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            PdfReader reader = new PdfReader(docInput);
            PdfStamper stamp = new PdfStamper(reader, baos);
            byte[] imgBytes = new byte[imgInput.available()];
            IOUtils.read(imgInput, imgBytes);

            Image img = Image.getInstance(imgBytes);

            // 最后一页
            int total = reader.getNumberOfPages();
            Rectangle rectangle = reader.getPageSize(total);
            float h = rectangle.getHeight();
            float yy = h - y - img.getHeight();

            img.setAbsolutePosition(x, yy);
            PdfContentByte over = stamp.getOverContent(total);
            over.addImage(img);
            stamp.close();
            reader.close();
        } catch (Exception e) {
            log.error("PDF签名失败", e);
            throw new PdfUtilException(e);
        }
        return baos.toByteArray();
    }

}
