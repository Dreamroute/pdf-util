package com.github.dreamroute.pdf.util;

import java.io.InputStream;

/**
 * 签名
 * 
 * @author w.dehai
 *
 */
public class SignUtil {

    private SignUtil() {}

    /**
     * @param doc PDF文件
     * @param img 图片文件
     * @param x 左下角x
     * @param y 左下角y
     * @param imgHeight 图片宽度
     * @param imgWidth 图片高度
     * @param pageNum 需要签名的页码数组，从1开始
     * @return 返回签好名的PDF文件字节码
     */
    public static byte[] sign(InputStream doc, InputStream img, int x, int y, float imgWidth, float imgHeight, int... pageNum) {
        if (pageNum == null || pageNum.length == 0) {
            throw new PdfUtilException("页码数组不能为空");
        }
        return ItextUtil.addImgToDoc(doc, img, x, y, imgWidth, imgHeight, pageNum);
    }

}
