package com.ws.xianbao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@MapperScan("com.ws.xianbao.mapper")
public class XianbaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(XianbaoApplication.class, args);
	}

	@RequestMapping(value = "/", produces = "text/plain;charset=UTF-8")
	public String welcome(){
		return "hi 闲宝";
	}
}
