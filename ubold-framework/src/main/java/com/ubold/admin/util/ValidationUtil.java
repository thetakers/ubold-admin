package com.ubold.admin.util;

import com.ubold.admin.constant.StatusCodeEnum;
import com.ubold.admin.response.Response;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 * Created by ningzuokun on 2017/11/10.
 */
public class ValidationUtil {
    private static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> Response validator(T t) {
        Set<ConstraintViolation<T>> violations = validator.validate(t);
        if (BeanUtils.isNotEmpty(violations)) {
            return Response.FAILURE(StatusCodeEnum.INVALID_ARGS.code, violations.iterator().next().getMessage());
        }
        return Response.SUCCESS();
    }
}
