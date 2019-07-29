package eley;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
//import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableEurekaClient
//@EnableFeignClients
//@EnableHystrix
//@EnableDiscoveryClient与EnableEurekaClient用法基本一致
//@EnableScheduling
@MapperScan(basePackages = {"eley.dao"})
public class EssrEleyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EssrEleyApplication.class, args);
	}

}
