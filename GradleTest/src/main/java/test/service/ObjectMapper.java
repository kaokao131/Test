package test.service;

import test.dto.ResponseDto;

public interface ObjectMapper {
    public void parseFromText(ResponseDto testBean, String text) throws IllegalArgumentException, IllegalAccessException;
}
