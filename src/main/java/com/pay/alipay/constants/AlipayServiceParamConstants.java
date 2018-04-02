package com.pay.alipay.constants;

/**
 * 基础数据
 * Created by Mr.Z on 2018/4/2.
 */
public class AlipayServiceParamConstants {

    /** 支付宝授权链接 */
    public static final String ALIPAY_AUTH_URL = "https://openauth.alipay.com/oauth2/publicAppAuthorize.htm?app_id={0}&scope={1}&redirect_uri={2}";

    /** 授权回调链接 */
    public static String ALIPAY_AUTH_CALLBACK_URL;

}
