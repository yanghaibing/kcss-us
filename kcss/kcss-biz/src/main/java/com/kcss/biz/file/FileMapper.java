package com.kcss.biz.file;

import com.kcss.biz.file.FileEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FileMapper {



    @InsertProvider(type = FileProvider.class,method = "insertFile")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertFile(FileEntity fileEntity);


    @Select("SELECT * FROM T_FILE WHERE id = #{id}")
    FileEntity findFileById(@Param("id") Long id);
}
