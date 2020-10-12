package com.artcreation.group.stock;

/**
 *
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * API文档设置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket bApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .groupName("库存微服务")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.artcreation.group.stock"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(apiBInfo());
//                .globalOperationParameters(setHeaderToken());
    }

    private ApiInfo apiBInfo() {

        return new ApiInfoBuilder()
                .title("艺创商城库存API")
                .description("艺创商城库存API")
                .contact(new Contact("汇纵", "http://", "qq@qq.com"))
                .version("3.0")
                .build();
    }

//    /**
//     * 设置公共header参数
//     * @return
//     */
//    private List<Parameter> setHeaderToken() {
//        ParameterBuilder tokenPar = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<>();
//        tokenPar.name("x-token").description("校验TOKEN").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
//        pars.add(tokenPar.build());
//        return pars;
//    }
}