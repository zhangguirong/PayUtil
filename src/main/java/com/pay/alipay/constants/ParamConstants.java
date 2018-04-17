package com.pay.alipay.constants;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 支付宝参数
 * Created by Mr.Z on 2018/4/11.
 */
@Data
@Component
@PropertySource("classpath:alipay.properties")
@ConfigurationProperties(prefix = "")
public class ParamConstants {

    private String partnerId;
    private String sellerId;
    private String merAlipayPublicKey;
    private String merPrivateKey;
    private String appId;
    private String appAlipayPublicKey;
    private String appPivateKey;

    private String alipayGateway;

}
