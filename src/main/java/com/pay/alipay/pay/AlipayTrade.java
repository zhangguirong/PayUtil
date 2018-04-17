package com.pay.alipay.pay;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradeCreateRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeCreateResponse;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import factory.AlipayAPIClientFactory;
import lombok.extern.slf4j.Slf4j;
import util.UtilDate;

/**
 * 支付接口
 * Created by Mr.Z on 2018/4/2.
 */
@Slf4j
public class AlipayTrade {

    /***
     * 统一收单交易创建
     * @throws AlipayApiException
     */
    public static void AlipayTradeCreate() throws AlipayApiException {
        AlipayClient alipayClient = AlipayAPIClientFactory.getAlipayClient2();
        AlipayTradeCreateRequest request = new AlipayTradeCreateRequest();

        JSONObject bizContent = new JSONObject();
        bizContent.put("out_trade_no", System.currentTimeMillis());
        bizContent.put("total_amount", 88.88);
        bizContent.put("subject", "订单创建测试".concat(UtilDate.getDate()));
        request.setBizContent(bizContent.toString());
        AlipayTradeCreateResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {
            log.info(">>> 调用成功 response {}", response.getBody());
        } else {
            log.info("{},{},{}", "调用失败", response.getSubCode(), response.getSubMsg());
        }
    }

    /***
     * 统一收单交易创建
     * @throws AlipayApiException
     */
    public static void AlipayTradeCreate2() throws AlipayApiException {
        AlipayClient alipayClient = AlipayAPIClientFactory.getAlipayClient();

        AlipayTradeWapPayRequest request = new AlipayTradeWapPayRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.put("subject", "订单创建测试" + UtilDate.getDate());
        bizContent.put("out_trade_no", System.currentTimeMillis());
        bizContent.put("total_amount", 0.01);
        bizContent.put("seller_id", "");
        bizContent.put("quit_url", "http://www.baidu.com");
        bizContent.put("product_code", "QUICK_WAP_WAY");
        request.setBizContent(bizContent.toString());
        AlipayTradeWapPayResponse response = alipayClient.pageExecute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }

    public static void main(String[] a) throws AlipayApiException {
        AlipayTradeCreate2();
    }
}
