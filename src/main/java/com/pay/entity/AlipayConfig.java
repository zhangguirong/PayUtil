package com.pay.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 支付宝基础配置
 * Created by Mr.Z on 2018/4/2.
 */
@Data
@Component
@PropertySource("classpath:alipay.properties")
@ConfigurationProperties(prefix = "")
public class AlipayConfig {

    private String auth_callback_url;

}
