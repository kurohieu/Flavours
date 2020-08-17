package application.controller.api;

import application.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/upload")
public class UploadApiController {

    @Autowired
    FileStorageService storageService;

    @PostMapping("/upload-image")
    public String uploadImage(
            @RequestPart("upload") MultipartFile file, @RequestParam("CKEditorFuncNum") String callback) {
        String imgUrl= "";
        try {
            String newFilename = storageService.store(file);
            imgUrl = "http://localhost:8080/link/" + newFilename;
        } catch (Exception e) {

        }

        StringBuffer sb = new StringBuffer();
        sb.append("<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction(");
        sb.append(callback);
        sb.append(",'");
        sb.append(imgUrl);
        sb.append("','image uploaded success!!')</script>");


        return sb.toString();
    }

}


