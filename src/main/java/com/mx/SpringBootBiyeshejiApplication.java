package com.mx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@MapperScan("com.mx.mapper")
@SpringBootApplication(scanBasePackages="com")
public class SpringBootBiyeshejiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBiyeshejiApplication.class, args);
	}

}

