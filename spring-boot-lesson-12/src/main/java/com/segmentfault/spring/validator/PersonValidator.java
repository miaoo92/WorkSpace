package com.segmentfault.spring.validator;

import com.segmentfault.domain.Person;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/11/12
 */
public class PersonValidator implements Validator{

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {

        Person person = Person.class.cast(object);
        String name = person.getName();
        if (!StringUtils.hasLength(name)){
            errors.reject("person.name.not.null","姓名不能为空");
        }

    }
}
