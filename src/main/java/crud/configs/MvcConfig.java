package crud.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    /*public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user").setViewName("user");
    }*/

    public void addViewControllers(ViewControllerRegistry registry) {
        /*registry.addViewController("/users").setViewName("users");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");*/
        registry.addViewController("/login").setViewName("login");

    }

}
