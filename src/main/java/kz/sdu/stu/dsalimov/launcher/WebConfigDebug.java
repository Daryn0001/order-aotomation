package kz.sdu.stu.dsalimov.launcher;

import kz.sdu.stu.dsalimov.util.AbstractWebConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class WebConfigDebug extends AbstractWebConfig {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000", "https://order-automation-frontend-lake.vercel.app")
                .allowedHeaders("*")
                .allowedMethods("*")
                .exposedHeaders("Content-Disposition")
                .allowCredentials(true);
    }
}
