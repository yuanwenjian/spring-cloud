package com.yuanwj.config;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.yuanwj.security.TokenFilter;
import com.yuanwj.security.TokenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

/**
 * Created by bmk on 17-12-22.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    private static String SIGNER_PATH="keys/signer.key";

    @Bean
    public TokenService tokenService() throws IOException {
        TokenService tokenService =new TokenService();
        tokenService.setSigner(readResource(SIGNER_PATH));
        return tokenService;
    }

    public String  readResource(String resource) throws IOException {
        URL resourceUrl = Resources.getResource(resource);
        return Resources.toString(resourceUrl, Charsets.UTF_8);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS,"/**")
                .antMatchers("/api/v1/login/**")
                .antMatchers("/api/v1/user/**")
                .antMatchers("/swagger.ui/index.html");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/v1/**").permitAll()
//                .antMatchers("/api/v1/user/**").permitAll()
                .antMatchers("/admin/**").permitAll()
                .antMatchers("/api/**").authenticated()
                .and()
                    .addFilterBefore(tokenFilter(),UsernamePasswordAuthenticationFilter.class);
    }



    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }

    @Bean
    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
        return new SecurityEvaluationContextExtension();
    }

//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        if (config.getAllowedOrigins() != null && !config.getAllowedOrigins().isEmpty()) {
//            source.registerCorsConfiguration("/api/**", config);
//            source.registerCorsConfiguration("/v2/api-docs", config);
//        }
//        return new CorsFilter(source);
//    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("/**"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
