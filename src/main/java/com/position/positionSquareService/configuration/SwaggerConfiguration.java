/**
 * 
 */
package com.position.positionSquareService.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author anush
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	@Bean
	public Docket api() {
		String groupName = "Login";
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.position.positionSquareService.controller"))
				.paths(PathSelectors.regex("/loginservice/.*")).build().groupName(groupName)
				.apiInfo(apiEndPointsInfo());
	}

	@Bean
	public Docket apiClients() {
		String groupName = "Client";
		ParameterBuilder aParameterBuilder = new ParameterBuilder();
		aParameterBuilder.name("clientId").modelRef(new ModelRef("clientId")).parameterType("header").required(true)
				.build();
		List<Parameter> aParameters = new ArrayList<Parameter>();
		aParameters.add(aParameterBuilder.build());
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.position.positionSquareService.controller"))
				.paths(PathSelectors.regex("/clientservice/.*")).build().groupName(groupName).apiInfo(apiEndPointsInfo())
				.pathMapping("").globalOperationParameters(aParameters);
	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("Position Square Service REST API").description("Position Square Service REST API")
				.license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("1.0.0")
				.build();
	}

}
