package com.kcss.core.util.jackson;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = EnumSerializer.class)
public interface I18NEnum {

    String code();

    String name();

}
