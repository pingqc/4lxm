package com.pingqc.exls.forlxm.web.photo;

import com.pingqc.exls.forlxm.model.photo.PhotoInfo;
import com.pingqc.exls.forlxm.service.photo.PhotoInfoService;
import com.pingqc.exls.forlxm.util.QiniuClient;
import com.pingqc.exls.forlxm.vo.QiniuFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by pingqc on 16/9/1.
 */
@RestController
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    PhotoInfoService photoInfoService;

    @Autowired
    QiniuClient qiniuClient;

    @RequestMapping("/page/{page}")
    public Page<PhotoInfo> page(@PathVariable("page") int page) {
        return photoInfoService.getPage(page);
    }

    @RequestMapping("/qiniu")
    public List<QiniuFile> qiniuManager() {
        return qiniuClient.list();
    }

}
