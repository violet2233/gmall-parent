package com.code.gmall.product.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @ClassName TestManageService
 * @Description
 * @Author violet2233
 * @Date 2023/2/26 18:05
 * @Version v1.0
 */

@SpringBootTest
public class TestManagerService {

    @Resource
    private ManagerService managerService;


    @Test
    void testGetCategory1(){
        managerService.getCategory1().stream().forEach(System.out::println);
    }

    @Test
    void testGetCategory2(){
        managerService.getCategory2(1L).stream().forEach(System.out::println);
    }

    @Test
    void testGetCategory3(){
        managerService.getCategory3(1L).stream().forEach(System.out::println);
    }


    @Test
    void testGetAttrInfoList(){
        managerService.getAttrInfoList(2L,13L,61L).stream().forEach(System.out::println);
    }
}
