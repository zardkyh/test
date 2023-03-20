package jayuroun.core.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * -------------------------------------------------------------------------------------
 * ::::::'OO::::'OOO::::'OO:::'OO:'OO::::'OO:'OOOOOOOO:::'OOOOOOO::'OO::::'OO:'OO....OO:
 * :::::: OO:::'OO OO:::. OO:'OO:: OO::::.OO: OO.....OO:'OO.....OO: OO:::: OO: OOO...OO:
 * :::::: OO::'OO:..OO:::. OOOO::: OO::::.OO: OO::::.OO: OO::::.OO: OO:::: OO: OOOO..OO:
 * :::::: OO:'OO:::..OO:::. OO:::: OO::::.OO: OOOOOOOO:: OO::::.OO: OO:::: OO: OO.OO.OO:
 * OO:::: OO: OOOOOOOOO:::: OO:::: OO::::.OO: OO.. OO::: OO::::.OO: OO:::: OO: OO..OOOO:
 * :OO::::OO: OO.....OO:::: OO:::: OO::::.OO: OO::. OO:: OO::::.OO: OO:::: OO: OO:..OOO:
 * ::OOOOOO:: OO:::..OO:::: OO::::. OOOOOOO:: OO:::. OO:. OOOOOOO::. OOOOOOO:: OO::..OO:
 * :......:::..:::::..:::::..::::::.......:::..:::::..:::.......::::.......:::..::::..::
 * <p>
 * EnumValueValidator 의 설명을 작성해주세요.
 *
 * @author :
 * @packageName : jayuroun.core.constraint.EnumValueValidator
 * @fileName :
 * @date :
 * @description :
 * =======================================================================
 * DATE                   AUTHOR                NOTE
 * -----------------------------------------------------------------------
 *
 */

public class EnumValueValidator implements ConstraintValidator<EnumValue, Enum> {

    List<Enum> valueList = null;

    @Override
    public boolean isValid(Enum value, ConstraintValidatorContext context) {

        return valueList.contains(value);
    }

    @Override
    public void initialize(EnumValue constraintAnnotation) {

        Class<? extends Enum<?>> enumClass = constraintAnnotation.enumClazz();

        List<String> enumValueList = Arrays.asList(constraintAnnotation.values());

        Enum<?>[] enumValues = enumClass.getEnumConstants();
        valueList = Arrays.stream(enumValues)
                          .filter(e -> enumValueList.contains(e.name()))
                          .collect(Collectors.toList());

    }
}
