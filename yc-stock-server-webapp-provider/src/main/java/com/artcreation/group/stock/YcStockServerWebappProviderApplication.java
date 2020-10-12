package com.artcreation.group.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 123
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class YcStockServerWebappProviderApplication {

    public static void main(String[] args) {

        SpringApplication.run(YcStockServerWebappProviderApplication.class, args);
    }
}
