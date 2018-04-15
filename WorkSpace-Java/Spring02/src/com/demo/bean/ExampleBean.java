package com.demo.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("protype")
public class ExampleBean {

	public ExampleBean(){
		System.out.println("实例化ExampleBean");
	}
	
	@PostConstruct
	public void init(){
		System.out.println("初始化ExampleBean对象");
	}
	
	@PreDestroy
	public void detroy(){
		System.out.println("销毁ExampleBean对象");
	}
	
	public void execute(){
		System.out.println("执行ExampleBean处理");
	}
	
}
