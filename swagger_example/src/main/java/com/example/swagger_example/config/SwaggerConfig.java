package com.example.swagger_example.config;

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

import java.util.Collections;

/**
 * created by ziliang on 18-7-5
 */
@Configuration  // 表明是配置类
@EnableSwagger2  // 启动swagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 文档标题
                .title("Rustful Api doc")
                // 文档描述
                .description("Api 描述")
                .termsOfServiceUrl("http://localhost/")
                // 版本号
                .version("v1")
                .build();
    }
    // swagger2文档的默认地址是 /swagger-ui.html, 本地开发的访问http://localhost:8080/swagger-ui.html就可以看到自动生成的文档了
}

