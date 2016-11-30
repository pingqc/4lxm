package com.pingqc.exls.forlxm.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pingqc.exls.forlxm.service.photo.PhotoInfoService;

/**
 * Created by pingqc on 16/9/6.
 */
@Component
public class QiniuPhotoFetcher {

    @Autowired
    PhotoInfoService photoInfoService;

    @Scheduled(cron = "0 0 3 * * ?")
    public void fetch() {
        photoInfoService.fetchPhotoFromQiniu();
    }

}
