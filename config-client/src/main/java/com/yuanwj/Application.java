package com.yuanwj;

import com.yuanwj.config.BiocloudProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;

import javax.inject.Inject;

/**
 * Created by bmk on 17-11-28.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(BiocloudProperties.class)
@MapperScan("com.yuanwj.repository")
public class Application {
    private static final Logger LOG= LoggerFactory.getLogger(Application.class);

    @Inject
    private Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
