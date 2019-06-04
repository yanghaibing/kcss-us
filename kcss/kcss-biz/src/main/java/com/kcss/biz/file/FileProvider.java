package com.kcss.biz.file;

import com.kcss.core.util.sql.SQL;
import org.springframework.util.StringUtils;

/**
 * FileProvider class.
 *
 * @author X
 * @date: 2018/11/26
 * Todo:
 * @updateAuthor:
 * @updateDate:
 * @updateDesc: 1 .
 */
public class FileProvider {


    public String insertFile(FileEntity fileEntity){

        return new SQL(){{
            INSERT_INTO("t_file")
                    .VALUES_IF("file_type","#{fileType}",fileEntity.getFileType()!=null)
                    .VALUES_IF("file_kind","#{fileKind}",!StringUtils.isEmpty(fileEntity.getFileKind()))
                    .VALUES_IF("path","#{path}",!StringUtils.isEmpty(fileEntity.getPath()))
                    .VALUES_IF("metadata","#{metadata}",!StringUtils.isEmpty(fileEntity.getMetadata()))
                    .VALUES_IF("name","#{name}",!StringUtils.isEmpty(fileEntity.getName()))
                    .VALUES_IF("upload_type","#{uploadType}",fileEntity.getUploadType()!=null)
                    .VALUES_IF("upload_id","#{uploadId}",fileEntity.getUploadId()!=null&&fileEntity.getUploadId()>0)
                    .VALUES("create_time","now()")
                    .VALUES("update_time","now()")
            ;
        }}.toString();
    }


}
