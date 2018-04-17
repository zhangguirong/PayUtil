

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
    public static final String CHARSET           = "GBK";

    /**签名类型-视支付宝服务窗要求*/
    public static final String SIGN_TYPE         = "RSA";
    
    /**开发者账号PID*/
    public static final String PARTNER           = "2088521388856475";

    /** 服务窗appId  */
    //TODO !!!! 注：该appId必须设为开发者自己的生活号id  
    public static final String APP_ID            = "2017091208691605";

    //TODO !!!! 注：该私钥为测试账号私钥  开发者必须设置自己的私钥 , 否则会存在安全隐患 
    public static final String PRIVATE_KEY       = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKBfWuya3zz4ss0B1iDbauju/xMAwL9i74/EckacxgjwZy78EctvTjKkypdkPOzNt61/mQEJJERET8YzGVjvywvuN11JzSZ89IVqzkcn/LNglBUyZjCNgECuxsNU0DufcBVFuNytecyfrw3PjSU7BNeKsQmsgGvYwscw59QrgrFpAgMBAAECgYA40hAxDJ5Tx/nx0NjBQ3yZkzQk03t3U+J1GbEze5Be0m58oyra3VDjeKefBBDiBfEyM6dOSqLi3SE2pBwy+qMBw4q1bJQDF4e6DmzXh1o9ZSJu5TK67afXSsLlHKToduwBlFvoc8HkuFZkame8pQXekEE6Pafc3WdyvPBpFV74AQJBAMyZODN+0ZbDgz7oGoeEBlDCKuqHmN7GVFGpdbgjuDpvuyCKzaCD7J0s82fRnIerAsHDlk43MkQETVCSxMKQ16kCQQDIqbuFEbKpIEbxkSwYcqBHm7dOKGoUNrcx1A37HRaOzYsi3s1juSTp0nHkASJWGJFgdQfG3iqpSoksuQMstCPBAkA7OzxfBB7vM6jiZFWR1/HwHVZJUXo7PFWa0qFm7shd+ozFDgobpzWwBxxseO2FBUgmClaQTEB8Gna7ldHqtf4JAkBhchvAaXHLtAL/uLIjRTcUz0fbSsEJA/E+323SrrOPsb2Jt40iinykmC/6u5pDGTcwEmUubCFniOzIrSgfg3OBAkEApmdOaTNXIkjvlN9RlOndF1iqbCf7+KJrl36xY5SYr87+/qN7KohO2w46zg1WZTlAaMdbrgCeG6VCljBBEWhKow==";
    
    //TODO !!!! 注：该公钥为测试账号公钥  开发者必须设置自己的公钥 ,否则会存在安全隐患
    public static final String PUBLIC_KEY        = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";
    /**支付宝网关*/
    public static final String ALIPAY_GATEWAY    = "https://openapi.alipay.com/gateway.do";

    /**授权访问令牌的授权类型*/
    public static final String GRANT_TYPE        = "authorization_code";
}