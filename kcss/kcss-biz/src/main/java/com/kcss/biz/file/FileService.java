package com.kcss.biz.file;

import com.kcss.biz.common.XResponse;
import com.kcss.biz.customer.CustomerEntity;
import com.kcss.biz.customer.CustomerMapper;
import com.kcss.biz.customer.CustomerService;
import com.kcss.biz.record.auth.token.TokenService;
import com.kcss.core.exception.ErrorConstants;
import com.kcss.core.util.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import static com.kcss.biz.file.FileChannel.OSS;


@Service
public class FileService {
    @Autowired
    private FileWrapper[] fileWrappers;
    @Autowired
    private FileMapper fileMapper;
    @Value("${storage.file.channel}")
    private FileChannel channel;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerService customerService;


    //to OSS
    public void uploadFile(InputStream inputStream, String storagePath) {
        currentFileServer().upload(inputStream, storagePath);
    }

    public void copyTo(String path, OutputStream outputStream) {
        currentFileServer().copyTo(path, outputStream);
    }

    public String getFileUrl(String path) {
        return currentFileServer().getFileUrl(path);
    }

    private String generatePath(long customerId, MultipartFile file, FileEntity.FileType fileType) {
        return "uploadfile" + "/" + String.valueOf(customerId) + "/" + DateUtil.genStrWithPattern("yyMMdd") + "/" + System.currentTimeMillis() + "_" + fileType.name() + "_" + file.getOriginalFilename();
    }

    private FileWrapper currentFileServer() {
        FileWrapper current = null;
        for (FileWrapper fileWrapper : fileWrappers) {
            /*if (fileWrapper instanceof AwsS3Wrapper && S3.equals(channel)) {
                current = fileWrapper;
            } else */
            if (fileWrapper instanceof AliyunOssWrapper && OSS.equals(channel)) {
                current = fileWrapper;
            }
        }
        if (current == null) {
            throw new FileException(String.format("get support file channel error, current channel config %s", channel));
        }
        return current;
    }

    //文件操作
    public FileEntity uploadFile(CustomerEntity customer, MultipartFile file, FileEntity.FileType fileType) {


        String path = generatePath(customer.getId(), file, fileType);
        /*try {
            uploadFile(file.getInputStream(), path);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }*/
        FileEntity fileEntity = new FileEntity() {{
            setUploadId(customer.getId());
            setUploadType(customer.getType());
            setFileKind(file.getContentType());
            setFileType(fileType);
            setName(file.getOriginalFilename());
            setPath(path);
        }};
        fileMapper.insertFile(fileEntity);
        return fileEntity;
    }


    public String uploadFileProcess(String token, MultipartFile file, FileEntity.FileType fileType) {
        CustomerEntity customer = tokenService.getCustomer(token);
        FileEntity fileEntity = uploadFile(customer, file, fileType);

        if (fileEntity == null || fileEntity.getId() <= 0L) {
            return null;
        }

        if (fileType == FileEntity.FileType.HEAD_PHOTO) {
            int i = customerMapper.updateCustomerHeadFileIdById(customer.getId(), fileEntity.getId());
            customer = customerService.findUserById(customer.getId());
            return customer.getHeadUrl();
        }

        return null;
    }

    //单
    public XResponse<UploadFileEntity> uploadFileOne(String token, MultipartFile file, FileEntity.FileType fileType, Long otherId) {
        XResponse<UploadFileEntity> xResponse = new XResponse<>();
        String url = uploadFileProcess(token, file, fileType);
        UploadFileEntity uploadFileEntity = new UploadFileEntity() {{
            if (StringUtils.isEmpty(url)) {
                xResponse.setCode(1050);
                setUpErrFileNames(new ArrayList<String>() {{
                    add(file.getOriginalFilename());
                }});
            } else {
                setFileUrls(new ArrayList<String>() {{
                    add(url);
                }});
            }
        }};
        xResponse.setData(uploadFileEntity);
        return xResponse;
    }

    //多
    public XResponse<UploadFileEntity> uploadFileS(String token, MultipartFile[] files, FileEntity.FileType fileType, Long otherId) {
        XResponse<UploadFileEntity> xResponse = new XResponse<>();
        ArrayList<String> fileUrls = new ArrayList<>();
        ArrayList<String> upErrFileNames = new ArrayList<>();
        Arrays.stream(files).forEach(file -> {
            String url = uploadFileProcess(token, file, fileType);
            if (StringUtils.isEmpty(url)) {
                xResponse.setCode(1050);
                upErrFileNames.add(file.getOriginalFilename());
            } else {
                fileUrls.add(url);
            }
        });
        xResponse.setData(new UploadFileEntity() {{
            setFileUrls(fileUrls);
            setUpErrFileNames(upErrFileNames);
        }});
        return xResponse;
    }

    //最重代码
    //文件流返回
    public void fileView(Long id, HttpServletResponse response) throws IOException {

        FileEntity fileEntity = fileMapper.findFileById(id);
        if (fileEntity == null || fileEntity.getId() < 1) {
            throw new FileException(ErrorConstants.ERR_FILE_VIEW);
        }
        //内存不够时需要优化
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType(fileEntity.getFileKind());
        ServletOutputStream out = response.getOutputStream();
        copyTo(fileEntity.getPath(), out);
        out.flush();
        out.close();
    }
}
