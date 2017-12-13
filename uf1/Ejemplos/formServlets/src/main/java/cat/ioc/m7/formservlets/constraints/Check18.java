package cat.ioc.m7.formservlets.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Constraint(validatedBy = Check18Validator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Check18 {

    String message() default "{cat.ioc.m7.formservlets.constraints.PastDate}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
