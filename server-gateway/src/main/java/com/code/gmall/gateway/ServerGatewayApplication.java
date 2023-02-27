package com.code.gmall.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName ServerGatewayApplication
 * @Description
 * @Author violet2233
 * @Date 2023/2/27 10:28
 * @Version v1.0
 */

@SpringBootApplication
@Slf4j
public class ServerGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerGatewayApplication.class,args);
        log.info("网关服务启动成功");
    }
}
