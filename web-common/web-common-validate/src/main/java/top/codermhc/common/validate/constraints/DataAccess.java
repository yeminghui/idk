package top.codermhc.common.validate.constraints;

import top.codermhc.common.validate.validator.DataAccessValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yemh
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DataAccessValidator.class)
public @interface DataAccess {

    enum RoleLevel {
        SELF,
        BELOW,
    }

    RoleLevel value() default RoleLevel.SELF;

    String message() default "{top.codermhc.web.constraints.DataAccess.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
