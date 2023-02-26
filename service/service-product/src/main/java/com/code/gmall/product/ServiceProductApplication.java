package com.code.gmall.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.code.gmall"})
@EnableDiscoveryClient
@Slf4j
public class ServiceProductApplication {
   public static void main(String[] args) {
      SpringApplication.run(ServiceProductApplication.class, args);
      log.info("商品管理服务启动成功");
   }
}
