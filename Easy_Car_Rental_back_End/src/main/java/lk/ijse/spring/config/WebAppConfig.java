package lk.ijse.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"lk.ijse.spring.controller", "lk.ijse.spring.advisor"})
public class WebAppConfig implements WebMvcConfigurer {
    public WebAppConfig() {
        System.out.println("WebAppConfig : Instantiated");
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();

        resolver.setMaxUploadSize(10 * 1024 * 1024);

        resolver.setMaxInMemorySize(10240);

        return resolver;
    }
}
