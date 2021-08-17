package com.edigitalnepal.ems.message;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ResponseMessage<T> {
    private T contents;
    private String message;

    public static <T> ResponseMessage<T> withResponseData(T classType, String message) {
        return new ResponseMessage<T>(classType, message);
    }
}


