package com.github.dreamroute.pdf.util;

/**
 * 签名框架的选择
 * 
 * @author w.dehai
 *
 */
public enum Type {

    /**
     * spire.pdf.free: 支持10页以内的PDF文件
     */
    SPIRE,
    
    /**
     * itext: 支持任意页数的PDF文件
     */
    ITEXT;

}
