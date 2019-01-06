package test.service;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import test.annotation.TextProperty;
import test.dto.ResponseDto;

public class ObjectMapperFromText implements ObjectMapper {

    @Override
    public void parseFromText(ResponseDto testBean, String text) throws IllegalArgumentException, IllegalAccessException {
        byte[] bodyByte = text.getBytes(Charset.forName("UTF-8"));

        List<Field> privateFields = new ArrayList<>();
        Field[] allFields = testBean.getClass().getDeclaredFields();
        for (Field field : allFields) {
            if (Modifier.isPrivate(field.getModifiers())) {
                privateFields.add(field);
            }
        }

        // get all field
        Field[] fields = testBean.getClass().getDeclaredFields();

        // iterate all field
        for (Field field : fields) {
            // get TextProperty annotation
            TextProperty textProperty = field.getAnnotation(TextProperty.class);

            if (textProperty != null) {
                int from = textProperty.from();
                int to = textProperty.to();

                field.setAccessible(true);
                field.set(testBean, new String(Arrays.copyOfRange(bodyByte, from, to)));
            }
        }
    }
}
