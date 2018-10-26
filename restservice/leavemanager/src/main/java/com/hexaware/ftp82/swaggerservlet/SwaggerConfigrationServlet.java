package com.hexaware.ftp82.swaggerservlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import io.swagger.jaxrs.config.BeanConfig;

public class SwaggerConfigrationServlet extends HttpServlet{
 private static final long serialVersionUID = 1L;

 public void init(ServletConfig config) throws ServletException {
     super.init(config);
     BeanConfig beanConfig = new BeanConfig();
     beanConfig.setBasePath("/ftp82/api");
     beanConfig.setHost("localhost:8080");
     beanConfig.setTitle("Maven demo app Swagger Docs");
     beanConfig.setResourcePackage("com.hexaware.ftp82");
     beanConfig.setPrettyPrint(true);
     beanConfig.setScan(true);
     beanConfig.setSchemes(new String[] {"http"});
     beanConfig.setVersion("1.0");
 }
}
