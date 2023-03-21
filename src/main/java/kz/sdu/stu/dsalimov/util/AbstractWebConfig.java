package kz.sdu.stu.dsalimov.util;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractWebConfig extends WebMvcConfigurationSupport {

    @Bean
    @SuppressWarnings("rawtypes")
    public FilterRegistrationBean filterRegistrationBean() {

        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setEncoding("UTF-8");

        var registrationBean = new FilterRegistrationBean<CharacterEncodingFilter>();
        registrationBean.setFilter(characterEncodingFilter);
        return registrationBean;

    }

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        return new StringHttpMessageConverter(StandardCharsets.UTF_8);
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        var newList = converters.stream()
                .filter(x -> !(x instanceof StringHttpMessageConverter))
                .collect(Collectors.toList());

        newList.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));

        converters.clear();
        converters.addAll(newList);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        WebFormatters.registerJsonFormatter(registry);
        WebFormatters.registerDateFormatter(registry);
        WebFormatters.registerListObjectConverter(registry);
    }

//    @Override
//    @SuppressWarnings("NullableProblems")
//    public RequestMappingHandlerMapping createRequestMappingHandlerMapping() {
//        return new LocalRequestMappingHandlerMapping();
//    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

    }

}
