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
     * 签名, 默认使用itext
     * 
     * @param docInput PDF文件
     * @param imgInput 图片文件
     * @param x 左上角x
     * @param y 左上角y
     * @return 返回签好名的PDF文件字节码
     */
    public static final byte[] sign(InputStream docInput, InputStream imgInput, int x, int y) {
        return sign(Type.ITEXT, docInput, imgInput, x, y);
    }

    public static final byte[] sign(Type type, InputStream docInput, InputStream imgInput, int x, int y) {
        byte[] result = null;
        if (type == Type.ITEXT) {
            result = ItextUtil.addImgToDoc(docInput, imgInput, x, y);
        } else if (type == Type.SPIRE) {
            result = SpireUtil.addImgToDoc(docInput, imgInput, x, y);
        }
        return result;
    }

}
