package com.supcon.ses.developer.config.swagger;

import io.swagger.models.parameters.Parameter;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger2.mappers.ServiceModelToSwagger2MapperImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *     将Document转换成Swagger类, 根据order进行排序
 * </p>
 * @author lufengdong
 * @create 2022-11-07 15:47
 */
@Primary
@Component("ServiceModelToSwagger2Mapper")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomModelToSwaggerMapper extends ServiceModelToSwagger2MapperImpl {
    @Override
    protected List<Parameter> parameterListToParameterList(List<springfox.documentation.service.Parameter> list) {
        list = list.stream().sorted(Comparator.comparingInt(springfox.documentation.service.Parameter::getOrder)).collect(Collectors.toList());
        return super.parameterListToParameterList(list);
    }
}
