package com.kcss.biz.suggest;

import com.kcss.biz.common.Platform;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SuggestMapper {

    @Insert("INSERT INTO t_suggest(student_teacher_id,platform,content) values(#{customerId},#{platform},#{content})")
    int insertSuggest(@Param("customerId") Long customerId, @Param("platform")Platform platform, @Param("content")String content);


}
