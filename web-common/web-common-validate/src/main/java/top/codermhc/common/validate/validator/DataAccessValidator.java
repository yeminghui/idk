package top.codermhc.common.validate.validator;

import top.codermhc.common.validate.constraints.DataAccess;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author yemh
 */
public class DataAccessValidator implements ConstraintValidator<DataAccess, Object> {

    DataAccess.RoleLevel roleLevel;

    @Override
    public void initialize(DataAccess constraintAnnotation) {
        this.roleLevel = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (roleLevel.equals(DataAccess.RoleLevel.SELF)) {
            return true;
        }
        return roleLevel.equals(DataAccess.RoleLevel.BELOW);
    }

}
