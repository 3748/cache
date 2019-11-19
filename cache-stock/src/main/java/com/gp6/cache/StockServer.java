package com.gp6.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 库存
 *
 * @author gp6
 * @date 2019/09/16
 */
@SpringBootApplication
@MapperScan(value = "com.gp6.cache.stock.mapper")
public class StockServer {

    public static void main(String[] args) {
        SpringApplication.run(StockServer.class, args);
    }

}
