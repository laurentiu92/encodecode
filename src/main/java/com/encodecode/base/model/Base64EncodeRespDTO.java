package com.encodecode.base.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class Base64EncodeRespDTO {
    private String originalValue;
    private String encodedValue;
}
