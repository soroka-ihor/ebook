package com.elib.interfaces;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FilesStorageService {

    public void init();

    public void uploadCover(MultipartFile cover);

    public Resource downloadCover(String coverName);

    public void uploadBook(MultipartFile book);

    public Resource downloadBook(String bookName);

}
