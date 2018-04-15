package com.demo.dao;

public class ExampleBean {
	
	public ExampleBean(){
		System.out.println("实例化exampleBean");
	}
	
	public void execut(){
		System.out.println("执行exampleBean处理");
	}
	
	public void init(){
		System.out.println("初始化exampleBean对象");
	}
	
	public void destory(){
		System.out.println("销毁exampleBean对象");
	}
	
}
