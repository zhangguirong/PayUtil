

/**

 * Alipay.com Inc.

 * Copyright (c) 2004-2014 All Rights Reserved.

 */

package com.pay.alipay.constants;


/**
 * 支付宝服务窗环境常量（demo中常量只是参考，需要修改成自己的常量值）
 * 
 * @author taixu.zqq
 * @version $Id: AlipayServiceConstants.java, v 0.1 2014年7月24日 下午4:33:49 taixu.zqq Exp $
 */
public class AlipayServiceEnvConstants {

    /**支付宝公钥-从支付宝生活号详情页面获取*/
	public static final String ALIPAY_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
    
    /**签名编码-视支付宝服务窗要求*/
    public static final String SIGN_CHARSET      = "utf-8";

    /**字符编码-传递给支付宝的数据编码*/
    public static final String CHARSET           = "utf-8";

    /**签名类型-视支付宝服务窗要求*/
    public static final String SIGN_TYPE         = "RSA";
    
    /**开发者账号PID*/
    public static final String PARTNER           = "2088521047114102";

    /** 服务窗appId  */
    //TODO !!!! 注：该appId必须设为开发者自己的生活号id  
    public static final String APP_ID            = "2016101402169908";

    //TODO !!!! 注：该私钥为测试账号私钥  开发者必须设置自己的私钥 , 否则会存在安全隐患 
    public static final String PRIVATE_KEY       = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAK7YfjDOQlNzpahDui7US9ZyZdlSasFhW09tetXQRoI0DOi058MWLFR8oPQ0qvcmHtYQXfVQxWjKOtwKgAEoHxvuCYDNWXuSkfRbMXqAhGoDa/ZNkNZuMtNX6vCMTgY/mLdFEbFwPlbfVbNtG9tv9Alh+snC7Z8+YjQGMI7oWBVnAgMBAAECgYAeSTHSkme6vNV9B/5ADlX0l2w88KG9TXfbkkMsth8AfrOdu3hJupWDLPNUWasjlF7TBZLA43TOafk4FDmH+cMpcfF+UdHvbq57ijKaCd5wietTkFBnHktMpdz69hC5ftx3822e5y56rzlW8MRFN+CDklN0Y++S18goJFhEjv9xQQJBAN+zzCbhAA865tfsKFy5hOdxm61No6RoDmtG6FPK1oL0vYClcwgS+upN6fc5G6W2bindw1X4LQs1P1w7GapJnxMCQQDIFurg6tVXumhsZpnXeAh2GFvOicBCEfbfEsjUHz/7pirXPXcgmyuozqOG88DHZ76D6DG8ylsfQ1P/pMt+jXbdAkEA3kFLz0DzBy61VcgLXfzwX+bPDkM6F8lOsiT0BPRdZiT09pDrFhWNeCdLElaJ8n2rPCtZvNtjHWSc++y4FikpQwJAYj0mSxHhd3Y1aOujIvBzLxBcmvZ1J7tMO1AsvEEvl+2I4S7ze1XURMhX751kDEN6facWLHwp6xqSdlTB+LuaHQJBAJNZYS0xZNjwc1P7zi96g/eU00uHnh9X+l4Tr83B/ngdzxPlFw2uKEF2qTzEtZD70FRK/mvO6pyjh3WxQ7WW/n4=";
    
    //TODO !!!! 注：该公钥为测试账号公钥  开发者必须设置自己的公钥 ,否则会存在安全隐患
    public static final String PUBLIC_KEY        = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";
    /**支付宝网关*/
    public static final String ALIPAY_GATEWAY    = "https://openapi.alipay.com/gateway.do";

    /**授权访问令牌的授权类型*/
    public static final String GRANT_TYPE        = "authorization_code";
}