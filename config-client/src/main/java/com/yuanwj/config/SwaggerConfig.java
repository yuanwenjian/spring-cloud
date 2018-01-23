package com.yuanwj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.inject.Inject;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by bmk on 17-12-21.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Inject
    private BiocloudProperties biocloudProperties;

    @Bean
    public Docket getDocket(){
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/api/.*"))
                .build();
        return docket;
    }

    

    public ApiInfo apiInfo(){
        ApiInfo apiInfo=new ApiInfo(
                biocloudProperties.getSwagger().getTitle(),
                biocloudProperties.getSwagger().getDescription(),
                biocloudProperties.getSwagger().getVersion(),
                biocloudProperties.getSwagger().getTermsOfServiceUrl(),
                contact(),
                biocloudProperties.getSwagger().getLicense(),
                biocloudProperties.getSwagger().getLicenseUrl());
        return apiInfo;
    }

    public Contact contact(){
        Contact contact=new Contact(biocloudProperties.getSwagger().getContactName(),biocloudProperties.getSwagger().getContactEmail(),"");
        return contact;
    }

}
