package com.kcss.rest.file;

import com.kcss.biz.common.XResponse;
import com.kcss.biz.file.FileEntity;
import com.kcss.biz.file.FileService;
import com.kcss.biz.file.UploadFileEntity;
import com.kcss.biz.record.auth.AuthConstants;
import com.kcss.biz.record.auth.token.CheckToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * FileController class.
 *
 * @author X
 * @date: 2018/11/23
 * Todo:
 * @updateAuthor:
 * @updateDate:
 * @updateDesc: 1 .
 */
@Controller
@RequestMapping("/api/file")
@Api(description = "文件管理")
public class FileController {

    @Autowired
    private FileService fileService;

    @CheckToken
    @PostMapping("/upload-one")
    @ResponseBody
    @ApiOperation(
            value = "文件上传(单)",
            notes = "")
    public XResponse<UploadFileEntity> uploadFileOne(
            @ApiParam(name = AuthConstants.AUTH_TOKEN_HEADER, value = "Token", required = true)
            @RequestHeader(value = AuthConstants.AUTH_TOKEN_HEADER, required = true)
                    String token,
            @ApiParam(name = "file", value = "文件", required = true)
            @RequestParam(value = "file", required = true)
                    MultipartFile file,
            @ApiParam(name = "fileType", value = "文件类型", required = true)
            @RequestParam(value = "fileType", required = true)
                    FileEntity.FileType fileType,
            @ApiParam(name = "otherId", value = "其它对应编号，没有即不传。ps:HOMEWORK<->任务id.LESSON<->课程id", required = false)
            @RequestParam(value = "otherId", required = false)
                    Long otherId
    ) {
        return fileService.uploadFileOne(token, file, fileType, otherId);
    }


    @CheckToken
    @PostMapping("/upload-s")
    @ResponseBody
    @ApiOperation(
            value = "文件上传(多)",
            notes = "")
    public XResponse<UploadFileEntity> uploadFileS(
            @ApiParam(name = AuthConstants.AUTH_TOKEN_HEADER, value = "Token", required = true)
            @RequestHeader(value = AuthConstants.AUTH_TOKEN_HEADER, required = true)
                    String token,
            @ApiParam(name = "file", value = "文件", required = true)
            @RequestParam(value = "file", required = true)
                    MultipartFile[] file,
            @ApiParam(name = "fileType", value = "文件类型", required = true)
            @RequestParam(value = "fileType", required = true)
                    FileEntity.FileType fileType,
            @ApiParam(name = "otherId", value = "其它对应编号，没有即不传。ps:HOMEWORK<->任务id.LESSON<->课程id", required = false)
            @RequestParam(value = "otherId", required = false)
                    Long otherId
    ) {
        return fileService.uploadFileS(token, file, fileType, otherId);
    }

    @ApiOperation(
            value = "文件流获取",
            notes = "")
    @GetMapping("/file-view/{id}")
    public void fileView(
            @ApiParam(name = "id", value = "编号", required = true)
            @PathVariable("id")
                    Long id,
            HttpServletResponse response
    ) throws IOException {
        fileService.fileView(id, response);
    }

}
