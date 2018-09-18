package com.employee.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Tanlian
 * @create 2018-09-18 15:49
 **/

public class SessionUtil {

    public static final String EMPLOYEE_KEY = "COSME_SESSION";
    public static final int COOKIE_EXPIRE_SECOND = 60 * 60;
    public static final String PUBLIC_KEY = "39D9625FABD93D46561871240D6624C5";

    public static void addCookie(HttpServletRequest request, HttpServletResponse response, String useId) {
        CookieUtils cookieUtils = new CookieUtils(request, response, useId);
        cookieUtils.setExpireTimeBySeconds(COOKIE_EXPIRE_SECOND);
        String decryptId = AESUtil.decrypt(useId + "|" + System.currentTimeMillis() / 1000, PUBLIC_KEY);
        cookieUtils.addCookie(EMPLOYEE_KEY, decryptId);
    }

    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response) {
        CookieUtils cookieUtils = new CookieUtils(request, response, request.getServerName());
        cookieUtils.delCookie(EMPLOYEE_KEY);
    }
}