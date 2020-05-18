package com.rest.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

  // @Bean
  // public Docket valorantApi() {
  // return new Docket(DocumentationType.SWAGGER_2).groupName("valorant").select()
  // .apis(RequestHandlerSelectors.any()).build().pathMapping("/")
  // .apiInfo(buildApiInfo("Valorant Stat Services", "View stats of players"));
  // }
  //
  // private ApiInfo buildApiInfo(final String title, final String description) {
  // return new ApiInfoBuilder().title(title).description(description).build();

  @Bean
  public Docket postsApi() {
    return new Docket(DocumentationType.SWAGGER_2).groupName("valorant").apiInfo(apiInfo()).select()
        .build().pathMapping("/valorant");
  }



  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("JavaInUse API")
        .description("JavaInUse API reference for developers")
        .termsOfServiceUrl("http://javainuse.com").contact("javainuse@gmail.com")
        .license("JavaInUse License").licenseUrl("javainuse@gmail.com").version("1.0").build();
  }
  // }
}
