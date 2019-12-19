# Swagger学习笔记
Swagger 是一套基于 OpenAPI 规范构建的开源工具，可以帮助我们设计、构建、记录以及
使用 Rest API。Swagger 主要包含了以下三个部分：
   1. Swagger Editor：基于浏览器的编辑器，我们可以使用它编写我们 OpenAPI 规范。
   2. Swagger UI：它会将我们编写的 OpenAPI 规范呈现为交互式的 API 文档，
      后文我将使用浏览器来查看并且操作我们的 Rest API。
   3. Swagger Codegen：它可以通过为 OpenAPI（以前称为 Swagger）规范定义的任何
      API 生成服务器存根和客户端 SDK 来简化构建过程。

## Spring Boot集成Swagger2实例
SpringBoot启动应用类上增加@EnableSwagger2注解即可。
注意：通常我们增加到Swagger的Config配置类上，方便我们对Swagger API文档的使用环境进行控制，例如，我们只在开发和测试环境下使用，其他环境关闭我们只需要配置类上增加@Profile({"dev","test"})即可
    1> Swagger配置类上
       ```
        @Configuration
        /** Swagger2配置只在dev和test环境下生效*/
        @Profile({"dev","test"})
        @EnableSwagger2
        public class SwaggerConfig {
        }
       ```
    2> 主启动类上
       ```
       @SpringBootApplication
        @EnableSwagger2
        public class SwaggerApplication {
            public static void main(String[] args) {
                SpringApplication.run(SwaggerApplication.class, args);
            }
        }

        @Configuration
        public class SwaggerConfig {
    
            @Bean
            public Docket docket(Environment environment) {
                Profiles profiles = Profiles.of("dev","test");
                boolean isExists = environment.acceptsProfiles(profiles);
                return new Docket(DocumentationType.SWAGGER_2)
                        .enable(isExists)
                        .xxxxx
                        .build();
            }
       ```
## 延伸
如果需要配置多个分组，我们只需要配置多个docket,每个docket中groupName设置不同的组名即可
