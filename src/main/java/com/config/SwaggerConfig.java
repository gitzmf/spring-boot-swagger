package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * @author zmf
 * @version 1.0
 * @ClassName SwaggerConfig
 * @Description: Swagger配置类
 * @date 2019/12/10 20:26
 */
@Configuration
/** Swagger2配置只在dev和test环境下生效*/
@Profile({"dev","test"})
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment environment) {

        Profiles profiles = Profiles.of("dev","test");
        boolean isExists = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(isExists)
                .apiInfo(apiInfo())
                .groupName("zmf")
                .select()
                /** 配置要扫描 接口的方式
                 * RequestHandlerSelectors.any() 扫描全部
                 * RequestHandlerSelectors.none() 全不扫描
                 * RequestHandlerSelectors.withMethodAnnotation() 扫描指定方法注解
                 * RequestHandlerSelectors.withClassAnnotation() 扫描指定类注解
                 * RequestHandlerSelectors.basePackage() 基础包名
                 * */
                .apis(RequestHandlerSelectors.any())
                /** 过滤什么路径
                 * PathSelectors.any() 任意
                 * PathSelectors.none() 没有一个
                 * RequestHandlerSelectors.regex() 匹配的表达式
                 * RequestHandlerSelectors.ant("/user/**") 匹配的路径
                 * */
                .paths(PathSelectors.any())
                .build();
    }

    /**文档信息配置*
     * title: Swagger文档的标题
     * description: Swagger文档的描述
     * version: 版本号
     * termsOfServiceUrl: 服务组织信息url
     * Contact
     *  - name: 文档作者
     *  - url: 文档作者有关网站地址
     *  - email:作者邮箱
     *  - license: 开源协议名称
     *  - licenseUrl: 开源协议网站地址
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Spring Boot 项目集成 Swagger 实例文档",
                "我的博客网站：https://itweknow.cn，欢迎大家访问。",
                "API V1.0",
                "Terms of service",
                new Contact(
                        "名字想好没",
                        "https://itweknow.cn",
                        "gancy.programmer@gmail.com"),
                "Apache",
                "http://www.apache.org/",
                Collections.emptyList());
    }
}
