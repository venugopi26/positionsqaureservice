package com.position.positionSquareService;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.position.positionSquareService.mapper")
public class PositionSquareServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PositionSquareServiceApplication.class, args);
	}

}
