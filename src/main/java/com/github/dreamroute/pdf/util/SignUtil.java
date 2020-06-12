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
     * @param img 图片文件，建议是无背景的PNG格式文件
     * @param x 以左下角为原点的x坐标
     * @param y 左下角为原点的y坐标
     * @param imgHeight 带有签名文字的图片宽度
     * @param imgWidth 带有签名文字的图片高度
     * @param rotation 带有签名文字的图片的旋转角度，逆时针旋转，如果不旋转则为0
     * @param pageNum 需要签名的页码数组，从1开始
     * @return 返回签好名的PDF文件字节码
     */
    public static byte[] sign(InputStream doc, InputStream img, int x, int y, float imgWidth, float imgHeight, float rotation, int... pageNum) {
        if (pageNum == null || pageNum.length == 0) {
            throw new PdfUtilException("页码数组不能为空");
        }
        return ItextUtil.addImgToDoc(doc, img, x, y, imgWidth, imgHeight, rotation, pageNum);
    }

}
