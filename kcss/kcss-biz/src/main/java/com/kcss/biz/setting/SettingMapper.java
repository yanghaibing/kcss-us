package com.kcss.biz.setting;


import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SettingMapper {

    @InsertProvider(type = SettingSqlProvider.class, method = "save")
    @Options(useGeneratedKeys = true)
    int save(SettingEntity settingEntity);

    @Select("SELECT * FROM T_SETTING WHERE ID = #{id}")
    SettingEntity findOne(@Param("id") Long id);


    @Select("SELECT * FROM T_SETTING WHERE NAMESPACE = #{namespace} AND KEY = #{key}")
    SettingEntity findOneByKey(@Param("namespace") String namespace, @Param("key") String key);


    @Update("UPDATE T_SETTING SET VALUE = #{value}, UPDATE_TIME = NOW() WHERE KEY = #{key}")
    int updateSettingValueByKey(@Param("key") String key, @Param("value") String value);

    @Update("UPDATE T_SETTING SET VALUE = #{value},UPDATE_TIME = NOW() WHERE ID = #{id}")
    int updateSettingValueById(@Param("id") long id, @Param("value") String value);

    //更新规则信息
    @Update("UPDATE T_SETTING SET VALUE = #{value},FLAG = #{flag}, UPDATE_TIME = NOW() WHERE ID = #{id}")
    int updateSettingValueAndFlagById(@Param("id") long id, @Param("value") String value, @Param("flag") boolean flag);

    @SelectProvider(type = SettingSqlProvider.class, method = "search")
    List<SettingEntity> searchSettingList(@Param("key") String key,
                                          @Param("value") String value,
                                          PageBounds pageBounds);

    @UpdateProvider(type = SettingSqlProvider.class, method = "update")
    int update(SettingEntity settingEntity);
}
