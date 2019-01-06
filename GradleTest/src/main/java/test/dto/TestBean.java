package test.dto;

import java.util.List;
import lombok.Data;
import test.annotation.TextProperty;

@Data
public class TestBean implements ResponseDto {

    @TextProperty(from = 0, to = 2)
    private String id;

    @TextProperty(from = 2, to = 10)
    private String name;

    private List<Detail> details;

}
