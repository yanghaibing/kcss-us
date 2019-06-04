package com.kcss.core.util.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.kcss.core.util.messageresource.MessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EnumSerializer extends JsonSerializer<Enum> {

    private static MessageHelper messageHelper;
    private static boolean isSerializeI18N;

    public EnumSerializer() {
    }

    @Autowired
    public EnumSerializer(MessageHelper messageHelper, Environment env) {
        this.messageHelper = messageHelper;
        this.isSerializeI18N = Boolean.valueOf(env.getProperty("kcss.rest.serialize.i18n.enable", "true"));
    }

    @Override
    public void serialize(Enum value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value instanceof I18NEnum && isSerializeI18N) {
            I18NEnum _val = (I18NEnum) value;
            gen.writeStartObject();
            gen.writeFieldName("key");
            gen.writeString(_val.name());
            gen.writeFieldName("value");
            gen.writeString(messageHelper.getMessage(_val.code()));
            gen.writeEndObject();
        } else {
            gen.writeString(value.name());
        }
    }

}
