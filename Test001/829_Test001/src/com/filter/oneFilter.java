package com.filter;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.http.HttpResponse;

public class oneFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //强转为子接口
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 允许跨域访问的域名：若有端口需写全（协议+域名+端口），若没有端口末尾不用加'/'
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080/myweb/");

        // 允许前端带认证cookie：启用此项后，上面的域名不能为'*'，必须指定具体的域名，否则浏览器会提示
        response.setHeader("Access-Control-Allow-Credentials", "true");

        // 提示OPTIONS预检时，后端需要设置的两个常用自定义头
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,X-Requested-With");
        servletResponse.setContentType("text/html;charset=utf-8");
        String uri = request.getRequestURI();
//        int idx = uri.lastIndexOf("/");
//        String endWith = uri.substring(idx + 1);
        //用全局作用域对象
        ServletContext application =  request.getServletContext();
        Integer loginKey = (Integer) application.getAttribute("loginKey");
        //indexOf中加入登录和注册页面名称,除此之外全部拦截
//        if(!(endWith.equals("login.jsp")||endWith.equals("首页.jsp"))){
        if(uri.indexOf("login")==-1&&uri.indexOf("main")==-1&&uri.indexOf("register")==-1){
           if( loginKey == null){//无登录记录
                //回到登陆页面
                response.sendRedirect("login.jsp");
            }else {
                //登录了，放行
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }else {
            //是访问登陆页面，放行
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
