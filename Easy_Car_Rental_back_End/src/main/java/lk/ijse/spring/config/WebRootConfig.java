package lk.ijse.spring.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
@Import({JPAConfig.class})
@ComponentScan(basePackages = "lk.ijse.spring.service")
public class WebRootConfig {
    public WebRootConfig() {
        System.out.println("WebRootConfig : Instantiated");
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

//    @Bean
//    public CommonsMultipartResolver multipartResolver() {
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//
//        resolver.setMaxUploadSize(10 * 1024 * 1024);
//
//        resolver.setMaxInMemorySize(10240);
//
//        return resolver;
//    }
}
