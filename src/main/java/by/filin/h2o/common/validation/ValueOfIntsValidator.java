package by.filin.h2o.common.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ValueOfIntsValidator
        implements ConstraintValidator<ValueOfInts, Integer> {

    private Set<Integer> allowedValues;

    @Override
    public void initialize(ValueOfInts constraint) {
        allowedValues = Arrays.stream(constraint.values())
                .boxed()
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(
            Integer value,
            ConstraintValidatorContext context
    ) {
        return value != null &&
                allowedValues.contains(value);
    }
}
