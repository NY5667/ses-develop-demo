package com.supcon.ses.developer.config.exception;

import com.supcon.ses.developer.model.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     全局异常处理
 *     FIXME: 注意国际化问题
 * </p>
 * @author lufengdong
 * @create 2022-08-20 18:35
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionConfig {
    /**
     * 校验错误拦截处理
     *
     * @param exception 错误信息集合
     * @return BaseResponse 错误响应，当HTTP响应状态码不为200时，使用该响应返回
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    private BaseResponse<String> validateRequestException(BindException exception) {
        List<String> errors = new ArrayList<>(exception.getFieldErrors().size());
        StringBuilder error;
        for (FieldError fieldError : exception.getFieldErrors()) {
            error = new StringBuilder();
            error.append("[").append(fieldError.getField()).append("]").append(fieldError.getDefaultMessage());
            errors.add(error.toString());
        }
        return BaseResponse.fail(HttpStatus.BAD_REQUEST.value(), StringUtils.join(errors, ","));
    }

    /**
     * 校验错误拦截处理
     *
     * @param exception 错误信息集合
     * @return BaseResponse 错误响应，当HTTP响应状态码不为200时，使用该响应返回
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    private BaseResponse<String> validateRequestException(ConstraintViolationException exception) {
        List<String> errors = new ArrayList<>(exception.getConstraintViolations().size());
        StringBuilder error;
        for (ConstraintViolation<?> violation : exception.getConstraintViolations()) {
            error = new StringBuilder();
            for (Path.Node node : violation.getPropertyPath()) {
                if("PARAMETER".equals(node.getKind().name())){
                    error.append("[").append(node.getName()).append("]");
                }
            }
            error.append(violation.getMessageTemplate());
            errors.add(error.toString());
        }
        return BaseResponse.fail(HttpStatus.BAD_REQUEST.value(), StringUtils.join(errors, ","));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    private BaseResponse<String> runtimeException(RuntimeException exception) {
        return BaseResponse.fail(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }
}
