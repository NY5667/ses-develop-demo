package com.supcon.ses.developer.model.valid;

import com.supcon.ses.developer.model.valid.validator.IntValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>描述</p>
 *
 * @author lufengdong
 * @create 2023-07-14 18:56
 */
@Target(ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IntValidator.class)
public @interface StringValid {
    /**
     * 校验失败时默认提示的消息
     */
    String message() default "参数值不再允许范围内.";
    /**
     * 允许的值
     */
    String[] allows();

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
