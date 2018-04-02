package com.pay.alipay.util;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户信息工具类
 * Created by Mr.Z on 2018/4/2.
 */
@Slf4j
public class UserInfoUtil {

    public String getUserId(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        AlipayUserInfoShareResponse alipayUserInfoShareResponse = (AlipayUserInfoShareResponse) session.getAttribute("user");
        if (null == alipayUserInfoShareResponse) {
            log.info("未获取到用户信息");
//            throw new ApiException(ErrorCode.E00000001.CODE, "网络异常，请退出重试", null);
        }
        log.info("当前用户信息" + JSONObject.toJSON(alipayUserInfoShareResponse));
        return alipayUserInfoShareResponse.getUserId();
    }

}
