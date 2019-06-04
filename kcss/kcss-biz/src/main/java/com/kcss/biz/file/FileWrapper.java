package com.kcss.biz.file;

import java.io.InputStream;
import java.io.OutputStream;

public interface FileWrapper {
    void upload(InputStream inputStream, String filePath);

    void copyTo(String filePath, OutputStream outputStream);

    String getFileUrl(String filePath);
}
