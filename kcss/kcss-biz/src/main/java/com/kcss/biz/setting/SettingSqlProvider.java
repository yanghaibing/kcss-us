package com.kcss.biz.setting;



import com.kcss.core.util.sql.SQL;
import org.springframework.util.StringUtils;

import java.util.Map;


public class SettingSqlProvider {

    public String save(SettingEntity settingEntity) {
        return new SQL(){{
            INSERT_INTO("T_SETTING")
                    .VALUES("NAMESPACE", "#{namespace}")
                    .VALUES("KEY", "#{key}")
                    .VALUES("VALUE", "#{value}")
                    .VALUES_IF("COMMENTS", "#{comments}", !StringUtils.isEmpty(settingEntity.getComments()));
        }}.toString();
    }

    public String update(SettingEntity settingEntity) {
        return new SQL() {{
            UPDATE("T_SETTING");
            if(settingEntity.getKey() != null){
                SET("KEY=#{key}");
            }
            if(settingEntity.getValue() != null){
                SET("VALUE=#{value}");
            }
            if (!StringUtils.isEmpty(settingEntity.getComments())) {
                SET("COMMENTS=#{comments}");
            }
            WHERE("id=#{id}");
        }}.toString();
    }

    public String search(Map<String,Object> params){
        return new SQL(){{
            SELECT("*");
            FROM("T_SETTING");
            WHERE("1=1");
            WHERE_IF("KEY LIKE '%'||#{key}||'%'", !StringUtils.isEmpty(params.get("key")));
            WHERE_IF("VALUE = #{value}", !StringUtils.isEmpty(params.get("value")));
            ORDER_BY("KEY");
        }}.toString();
    }


}
