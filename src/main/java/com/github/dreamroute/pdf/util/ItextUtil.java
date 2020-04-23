package com.github.dreamroute.pdf.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import com.github.dreamroute.pdf.util.exception.PdfUtilException;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.graphics.PdfImage;
import com.spire.pdf.widget.PdfPageCollection;

/**
 * 基于Itext框架
 * 
 * @author w.dehai
 *
 */
public class ItextUtil {

    private ItextUtil() {}

    /**
     * 将一个图片添加到PDF文件上，类似签名
     * 
     * @param docInput PDF文件
     * @param imgInput 图片文件
     * @param x 相对于左上角x坐标
     * @param y 相对于左上角y坐标
     * @return 返回完成后的PDF文件字节数组
     */
    public static final byte[] addImgToDoc(InputStream docInput, InputStream imgInput, int x, int y) {
        PdfDocument doc = new PdfDocument();
        doc.loadFromStream(docInput);
        PdfPageCollection pages = doc.getPages();
        if (pages.getCount() <= 0)
            throw new PdfUtilException("PDF文件不能为空");

        PdfImage img = PdfImage.fromStream(imgInput);
        int imgW = img.getWidth();
        int imgH = img.getHeight();

        // 在最后一页签字
        pages.get(pages.getCount() - 1).getCanvas().drawImage(img, x, y, imgW, imgH);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        doc.saveToStream(baos);
        doc.dispose();
        return baos.toByteArray();
    }

}
