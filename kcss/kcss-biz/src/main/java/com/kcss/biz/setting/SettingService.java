package com.kcss.biz.setting;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SettingService {

    private final static Logger logger = LoggerFactory.getLogger(SettingService.class);

    @Autowired
    private SettingMapper settingMapper;

    public SettingEntity getSettingsByKey(String namespace, String key) {
        if (StringUtils.isEmpty(namespace)) {
            throw new SettingException("empty setting namespace");
        } else if (StringUtils.isEmpty(key)) {
            throw new SettingException("empty setting key");
        }

        return settingMapper.findOneByKey(namespace, key);
    }

    public SettingEntity getSettingsByConfig(SettingConfig settingConfig) {
        return getSettingsByKey(settingConfig.getNamespace(), settingConfig.getKey());
    }

    @Transactional
    public boolean updateProductProperties(List<Pair<String, String>> propertyList){
        for(int i = 0; i < propertyList.size(); i++){

            Pair<String, String> t = propertyList.get(i);

            if( !StringUtils.isEmpty(t.getKey()) && !StringUtils.isEmpty(t.getValue()) ) {
                long valueId = Long.parseLong(t.getKey());
                settingMapper.updateSettingValueById(valueId, t.getValue());
            }
        }
        return true;
    }

    public SettingEntity findById(long id){
        return settingMapper.findOne(id);
    }


    public List<SettingEntity> findSettingList(String key, String value, PageBounds pageBounds){
        return settingMapper.searchSettingList(key,value, pageBounds);
    }

}
