package test;

import test.dto.TestBean;
import test.service.ObjectMapper;
import test.service.ObjectMapperFromText;

public class TestMain {

    public static void main(String[] args)
            throws IllegalArgumentException, IllegalAccessException {
        ObjectMapper mapper = new ObjectMapperFromText();
        TestBean test = new TestBean();

        // id:2byte, name:8byte, repeat:1byte, detail_tel1:4byte, detail_tel2:4byte
        String reponseSample = "01abcd    20001000200030004";
        mapper.parseFromText(test, reponseSample);

        // id:01, name:abcd, details[[tel1:0001, tel2:0002], [tel1:0003, tel2:0004]] -> Success
        System.out.println(test.toString());
    }
}
