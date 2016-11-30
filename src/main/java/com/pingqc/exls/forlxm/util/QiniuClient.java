package com.pingqc.exls.forlxm.util;

import com.google.common.collect.Lists;
import com.pingqc.exls.forlxm.exception.QiniuRuntimeException;
import com.pingqc.exls.forlxm.vo.QiniuFile;
import com.qiniu.common.QiniuException;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.storage.model.FileListing;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pingqc on 16/9/5.
 */
@Component
public class QiniuClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(QiniuClient.class);

    @Value("${qiniu.bucket:pingqc}")
    private String bucket;

    @Value("${qiniu.access_key:a764640F1yw6F5Oy9dpIP3hxcx_WpTe4H3piYRU-}")
    private String accessKey;

    @Value("${qiniu.secret_key:L-iimF8SuI3Tc_RF6EpwMWb0uMhQy4TsXvr1bT_D}")
    private String secretKey;

    @Value("${qiniu.domain:http://7nj3c7.com1.z0.glb.clouddn.com}")
    private String domain;

    BucketManager bucketManager;

    @PostConstruct
    public void postConstruct() {
        LOGGER.info("build qiniu client, bucket:{}, access key: {}, secret key: {}, domain: {}", bucket, accessKey, secretKey, "******", domain);
        Auth auth = Auth.create(accessKey, secretKey);
        bucketManager = new BucketManager(auth);
    }

    public List<QiniuFile> list() {
        String marker = null;
        try {
            FileListing fileListing = null;
            List<FileInfo> list = Lists.newArrayList();
            do {
                fileListing = bucketManager.listFiles(bucket, null, marker, 1000, null);
                marker = fileListing.marker;
                list.addAll(Arrays.asList(fileListing.items));
            } while (fileListing == null || !fileListing.isEOF());
            return list.stream().map(QiniuClient::convertQiniuModelToVo).collect(Collectors.toList());
        } catch (QiniuException e) {
            LOGGER.error("list file error", e);
            throw new QiniuRuntimeException(e);
        }
    }

    public static void main(String[] args) {
        List<QiniuFile> list = new QiniuClient().list();
        list.forEach(System.out::println);
    }

    public static QiniuFile convertQiniuModelToVo(FileInfo fileInfo) {
        if (fileInfo == null) {
            return null;
        }
        QiniuFile qiniuFile = new QiniuFile();
        qiniuFile.setEndUser(fileInfo.endUser);
        qiniuFile.setFsize(fileInfo.fsize);
        qiniuFile.setHash(fileInfo.hash);
        qiniuFile.setKey(fileInfo.key);
        qiniuFile.setMimeType(fileInfo.mimeType);
        qiniuFile.setPutTime(fileInfo.putTime);
        return qiniuFile;
    }

}