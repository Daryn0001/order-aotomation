package kz.sdu.stu.dsalimov.util;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

public class LocalRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

    private static final String WEB_PATH_PREFIX = "api";

    @Override
    protected void registerHandlerMethod(@NotNull Object handler, Method method, @NotNull RequestMappingInfo mapping) {

        Class<?> beanType = method.getDeclaringClass();

        if (AnnotationUtils.findAnnotation(beanType, RestController.class) != null) {
            mapping = configRequestMapping(mapping, WEB_PATH_PREFIX);
        }

        super.registerHandlerMethod(handler, method, mapping);
    }

    private RequestMappingInfo configRequestMapping(@NotNull RequestMappingInfo mapping,
                                                    @SuppressWarnings("SameParameterValue") String pathPrefix) {

        assert mapping.getPatternsCondition() != null;
        PatternsRequestCondition apiPattern = new PatternsRequestCondition(pathPrefix)
                .combine(mapping.getPatternsCondition());

        //noinspection UnnecessaryLocalVariable
        var retMapping = new RequestMappingInfo(
                mapping.getName(),
                apiPattern,
                mapping.getMethodsCondition(),
                mapping.getParamsCondition(),
                mapping.getHeadersCondition(),
                mapping.getConsumesCondition(),
                mapping.getProducesCondition(),
                mapping.getCustomCondition()
        );

        return retMapping;
    }
}
