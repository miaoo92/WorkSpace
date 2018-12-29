package com.segmentfault.springbootlesson18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootApplication
@ImportResource(locations = {"/META-INF/spring/context-dev.xml","/META-INF/spring/context-test.xml"})
//通过配置Java程序参数来决定启用哪个profile
public class SpringBootLesson18Application  implements EnvironmentAware{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLesson18Application.class, args);
	}

	@Override
	public void setEnvironment(Environment environment) {
		System.err.println(Arrays.asList(environment.getActiveProfiles()));
	}
}
