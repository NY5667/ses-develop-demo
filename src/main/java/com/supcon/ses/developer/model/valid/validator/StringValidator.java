package com.supcon.ses.developer.model.valid.validator;

import com.supcon.ses.developer.model.valid.StringValid;
import org.apache.commons.lang3.ArrayUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * <p>
 *    String输入值校验器。只允许allows规定的特定数据
 * </p>
 *
 * @author lufengdong
 * @create 2023-07-14 19:42
 */
public class StringValidator implements ConstraintValidator<StringValid, String> {

    private String[] allows;

    @Override
    public void initialize(StringValid constraintAnnotation) {
        allows = constraintAnnotation.allows();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return ArrayUtils.contains(allows, value);
    }
}
