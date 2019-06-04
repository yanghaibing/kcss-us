package com.kcss.core.util.common;

import org.springframework.util.StringUtils;

import java.text.MessageFormat;


public class MsgFormatter {

    public static String format(String pattern, Object... args) {
        if (StringUtils.isEmpty(pattern)) {
            return "";
        }

        if (args == null || args.length == 0) {
            return pattern;
        }

        StringBuilder sb = new StringBuilder();

        int index = 0;
        for (String part : pattern.split("\\{ *\\}", -1)) {
            if (index != 0) {
                sb.append("{");
                sb.append(index - 1);
                sb.append("}");
            }
            sb.append(part);
            ++index;
        }

        return MessageFormat.format(sb.toString(), args);
    }
}
