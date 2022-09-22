package ru.jyfik.rabbitmqworkout.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import ru.jyfik.rabbitmqworkout.DemoApplication;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.time.LocalDate;

import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

@Configuration
@EnableSwagger2
@RequiredArgsConstructor
public class SwaggerConfiguration {

	private final Environment environment;

	@Bean
	public Docket api() {
		return new Docket(SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(DemoApplication.class.getPackage().getName()))
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(environment.getProperty("spring.application.name"))
				.description("API сервиса для хранения данных о семье")
				.license(
						String.format(
								"© %d Demo. All Rights Reserved.",
								LocalDate.now().getYear()
						)
				)
				.licenseUrl("#")
				.version(environment.getProperty("demo.version"))
				.build();
	}
}
