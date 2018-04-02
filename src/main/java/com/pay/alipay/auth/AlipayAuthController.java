package com.pay.alipay.auth;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.pay.alipay.constants.AlipayServiceEnvConstants;
import com.pay.alipay.constants.AlipayServiceParamConstants;
import com.pay.entity.AlipayConfig;
import factory.AlipayAPIClientFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import util.RequestUtil;
import util.Scope;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.Map;

/**
 * 支付宝授权控制器
 * Created by Mr.Z on 2018/4/2.
 */
@Slf4j
//加上注释@Component，可以直接在其他地方使用@Autowired来创建其实例对象
@Component
@RestController
@RequestMapping(value = "/auth", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class AlipayAuthController {

    @Autowired
    private AlipayConfig alipayConfig;

    /**
     * 授权回调
     */
    @RequestMapping("/callback")
    @ResponseBody
    public void callback(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //1. 解析请求参数
        Map<String, String> params = RequestUtil.getRequestParams(request);
        //2. 获得authCode
        String authCode = params.get("auth_code");

        try {
            //3. 利用authCode获得authToken
            AlipaySystemOauthTokenRequest oauthTokenRequest = new AlipaySystemOauthTokenRequest();
            oauthTokenRequest.setCode(authCode);
            oauthTokenRequest.setGrantType(AlipayServiceEnvConstants.GRANT_TYPE);
            AlipayClient alipayClient = AlipayAPIClientFactory.getAlipayClient();
            AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient.execute(oauthTokenRequest);
            log.info(oauthTokenResponse.getAlipayUserId());
            log.info(oauthTokenResponse.getUserId());
            response.getWriter().write("userId：" + oauthTokenResponse.getUserId());

            //成功获得authToken
            if (null != oauthTokenResponse && oauthTokenResponse.isSuccess()) {

                //4. 利用authToken获取用户信息
                AlipayUserInfoShareRequest userinfoShareRequest = new AlipayUserInfoShareRequest();
                AlipayUserInfoShareResponse userinfoShareResponse = alipayClient.execute(userinfoShareRequest, oauthTokenResponse.getAccessToken());

                //成功获得用户信息
                if (null != userinfoShareResponse && userinfoShareResponse.isSuccess()) {
                    //这里仅是简单打印， 请开发者按实际情况自行进行处理
                    log.info("获取用户信息成功：" + userinfoShareResponse.getBody());
                    //储存用户信息至session，这里引入了springSession
                    request.getSession().setAttribute("user", userinfoShareResponse.getBody());
                } else {
                    //这里仅是简单打印， 请开发者按实际情况自行进行处理
                    log.info("获取用户信息失败");
                }
            } else {
                //这里仅是简单打印， 请开发者按实际情况自行进行处理
                log.info("authCode换取authToken失败");
            }
        } catch (AlipayApiException alipayApiException) {
            //自行处理异常
            alipayApiException.printStackTrace();
        }
    }

    /**
     * 获取授权
     */
    @RequestMapping("/toAuth")
    @ResponseBody
    public void toAuth(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String auth_url = AlipayServiceParamConstants.ALIPAY_AUTH_URL;
            String alipay_auth_callback_url = alipayConfig.getAuth_callback_url();
            // 将回调地址编码
            alipay_auth_callback_url = URLEncoder.encode(alipay_auth_callback_url, "utf8");

            // 授权地址
            String redirect_url = MessageFormat.format(auth_url, AlipayServiceEnvConstants.APP_ID, Scope.auth_user, alipay_auth_callback_url);
            response.sendRedirect(redirect_url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
