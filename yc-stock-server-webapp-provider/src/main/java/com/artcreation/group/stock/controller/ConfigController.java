package com.artcreation.group.stock.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author 123
 */
@RefreshScope
@RestController
@RequestMapping("/stock")
public class ConfigController {


    @Value("${stock.pay.time}")
    private String payTime;

    @Value("${stock.pay.body}")
    private String body;

    private final static Logger logger = LoggerFactory.getLogger(ConfigController.class);

    @RequestMapping(value = "/getStock",method = RequestMethod.POST)
    @ApiOperation(value = "测试获取nacos配置中心信息")
    public ResponseEntity test(
            @ApiParam(required = true, value = "秘钥")@RequestParam(required = true) String secretKey
    ){
        logger.info("测试获取nacos配置中心信息");
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("payTime",payTime);
        hashMap.put("body",body);
        return ResponseEntity.ok().body(hashMap);
    }


}
