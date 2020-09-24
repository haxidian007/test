package com.page.utils;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseBody {
    /**
     * 响应json数据工具类
     * @param response 响应的对象
     * @param data 响应的数据
     */
    public static void  write(HttpServletResponse response,Object data) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(data));
        out.close();
    }
}
