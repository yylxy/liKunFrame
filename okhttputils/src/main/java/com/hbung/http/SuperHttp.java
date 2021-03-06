package com.hbung.http;

import com.hbung.http.request.RequestCall;
import com.hbung.http.request.RequestParam;

import java.io.IOException;

import okhttp3.Response;

/**
 * 作者　　: 李坤
 * 创建时间:2017/3/17　15:44
 * 邮箱　　：496546144@qq.com
 * <p>
 * 功能介绍：
 */

public interface SuperHttp {
    //默认的超时时间
    public static final long DEFAULT_MILLISECONDS = 20_000L;

    //异步回调
    <T> ExecuteCall execute(RequestCall requestCall, Callback<T> callback);

    //同步执行
    Response execute(RequestCall requestCall) throws IOException; //异步回调

    <T> ExecuteCall execute(RequestParam requestParam, Callback<T> callback);

    //同步执行
    Response execute(RequestParam requestParam) throws IOException;

}
