package com.gupaoedu.springbootbeanvalidation.validation.constraints;

import com.gupaoedu.springbootbeanvalidation.validation.ValidCardNumberConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 合法 卡号校验
 *
 * 需求：通过员工的卡号来校验，需要通过工号的前缀加后缀来判断
 * 前缀必须以GUPAO-
 * 后缀必须以数字
 * 需要通过Bean Validator验证
 */
@Target({ FIELD })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { ValidCardNumberConstraintValidator.class})
public @interface ValidCardNumber {

    String message() default "{com.gupao.invalid.cardNumber.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
