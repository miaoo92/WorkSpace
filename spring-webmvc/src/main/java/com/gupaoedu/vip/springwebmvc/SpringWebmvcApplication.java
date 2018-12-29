package com.gupaoedu.vip.springwebmvc;

import com.gupaoedu.vip.springwebmvc.interceptor.DefaultHandlerInterceptor;
import com.gupaoedu.vip.springwebmvc.servlet.spring.boot.MyFilter2;
import com.gupaoedu.vip.springwebmvc.servlet.spring.boot.MyServlet2;
import com.gupaoedu.vip.springwebmvc.servlet.spring.boot.MyServletContextListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.DispatcherType;


@SpringBootApplication
@ServletComponentScan(basePackages = "com.gupaoedu.vip.springwebmvc.servlet")
public class SpringWebmvcApplication extends SpringBootServletInitializer implements ErrorPageRegistrar
{

	public static void main(String[] args) {
		SpringApplication.run(SpringWebmvcApplication.class, args);
	}

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new DefaultHandlerInterceptor());
	}

	@Override
	public void registerErrorPages(ErrorPageRegistry registry) {
		registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/404.html"));
	}

	@Bean
	public static ServletRegistrationBean servletRegistrationBean(){
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
		servletRegistrationBean.setServlet(new MyServlet2());
		servletRegistrationBean.addUrlMappings("/spring-boot/myservlet2");
		servletRegistrationBean.setName("myservlet2");
		servletRegistrationBean.addInitParameter("myname","myvalue");
		return servletRegistrationBean;
	}

	@Bean
	public static FilterRegistrationBean filterRegistrationBean(){
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setFilter(new MyFilter2());
		filter.addServletNames("myservlet2");
		filter.setDispatcherTypes(DispatcherType.FORWARD,DispatcherType.REQUEST,DispatcherType.INCLUDE);
		return filter;
	}

	@Bean
	public static ServletListenerRegistrationBean servletListenerRegistrationBean(){
		ServletListenerRegistrationBean listener = new ServletListenerRegistrationBean();
		listener.setListener(new MyServletContextListener());
		return listener;
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		builder.sources(SpringWebmvcApplication.class);   //完成对JSP组件的组装
		return builder;
	}
}
