package com.example.test.config;
import com.example.test.common.interceptor.Jwtinterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
registry.addInterceptor(jwtinterceptor())
        .addPathPatterns("/**").excludePathPatterns("/admin/log","/admin/register","/**/export","/**/import");
    }
    @Bean
    public Jwtinterceptor jwtinterceptor()
    {
        return new Jwtinterceptor();
    }
}
