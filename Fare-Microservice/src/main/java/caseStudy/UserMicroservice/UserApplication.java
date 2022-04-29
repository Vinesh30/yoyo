package caseStudy.UserMicroservice;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class UserApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}
	@Bean
	public Docket swaggerConfiguration1() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("caseStudy.UserMicroservice")).build().apiInfo(apiDetails());

	}

	private ApiInfo apiDetails() {
		return new ApiInfo("User-MicroService API Documentation", "API for Fare-MicroService", "1.0", "Free to use",
				new springfox.documentation.service.Contact("Harsha vardhan", "http://Youtube.com",
						"harshacena1222@gmail.com"),
				"API Licence", "http://Youtube.com", Collections.emptyList());
	}
	
	
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}

