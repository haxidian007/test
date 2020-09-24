package com.page.controller;

import com.alibaba.fastjson.JSON;
import com.page.pojo.User;
import com.page.service.UserService;
import com.page.utils.JsonResult;
import com.page.utils.ResponseBody;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.ListUI;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/user/*")
public class UserController extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取访问路径
        String uri = request.getRequestURI();
        if("/user/page".equals(uri)){//检查用户名
            query(request,response);//查询
        }else if("/user/tableall".equals(uri)){
            System.out.println(2);
            queryall(request,response);
        }else if("/user/pagepr".equals(uri)){
            previouspage(request,response);
        }else if("/user/nextp".equals(uri)){
            System.out.println(2);
            nextpage(request,response);
        }
    }
    private void nextpage(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println(3);
        request.setCharacterEncoding("utf-8");
        String querytext=request.getParameter("querytext");
        System.out.println(querytext);
        String count=request.getParameter("count");
        System.out.println(count);
        String pagination=request.getParameter("pagination");
        System.out.println(pagination);
        List<User> queryp = userService.nextp(querytext,Integer.valueOf(count),Integer.valueOf(pagination));
        ResponseBody.write(response,new JsonResult<List<User>>(JsonResult.SUCCESS,"成功",queryp));
    }
    private void previouspage(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("utf-8");
        String querytext=request.getParameter("querytext");
        String count=request.getParameter("count");
        String pagination=request.getParameter("pagination");
        List<User> queryp = userService.prevp(querytext,Integer.valueOf(count),Integer.valueOf(pagination));
        ResponseBody.write(response,new JsonResult<List<User>>(JsonResult.SUCCESS,"成功",queryp));
    }
    private void query(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("第二");
        request.setCharacterEncoding("utf-8");
        String querytext=request.getParameter("querytext");
        System.out.println(querytext);
        String count=request.getParameter("count");
        System.out.println(count);
        String pagination=request.getParameter("pagination");
        System.out.println(pagination);
            List<User> queryp = userService.queryp(querytext,Integer.valueOf(count),Integer.valueOf(pagination));
            ResponseBody.write(response,new JsonResult<List<User>>(JsonResult.SUCCESS,"成功",queryp));
    }
    private void queryall(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(3);
        request.setCharacterEncoding("utf-8");
        String count=request.getParameter("count");
        String pagination=request.getParameter("pagination");
        System.out.println("sssssssssssss"+pagination);
            List<User> queryp = userService.queryallp(Integer.valueOf(count),Integer.valueOf(pagination));
            ResponseBody.write(response,new JsonResult<List<User>>(JsonResult.SUCCESS,"成功",queryp));
    }
}
