package com.pingqc.exls.forlxm.service.photo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.pingqc.exls.forlxm.dao.photo.PhotoInfoDao;
import com.pingqc.exls.forlxm.dao.photo.PhotoTagDao;
import com.pingqc.exls.forlxm.dao.photo.TagDao;
import com.pingqc.exls.forlxm.model.photo.PhotoInfo;
import com.pingqc.exls.forlxm.model.photo.PhotoTag;
import com.pingqc.exls.forlxm.model.photo.Tag;
import com.pingqc.exls.forlxm.util.QiniuClient;
import com.pingqc.exls.forlxm.vo.QiniuFile;

/**
 * Created by pingqc on 16/9/1.
 */
@Service
@Transactional
public class PhotoInfoService {

    @Value("${qiniu.domain}")
    private String domain;

    @Autowired
    PhotoInfoDao photoInfoDao;

    @Autowired
    PhotoTagDao photoTagDao;

    @Autowired
    QiniuClient qiniuClient;

    @Autowired
    TagDao tagDao;

    public Page<PhotoInfo> getPage(int page) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        PageRequest pageRequest = new PageRequest(page - 1, 10, sort);
        Page<PhotoInfo> pager = photoInfoDao.findAll(pageRequest);
        // 获取照片id
        Set<Long> photoIds = pager.getContent().stream().map(photoInfo -> photoInfo.getId()).collect(Collectors.toSet());
        // 根据照片id获取相应的tag
        List<PhotoTag> photoTagList = photoTagDao.findByPhotoIdIn(photoIds);
        // 获取tag id
        Set<Long> tagIds = photoTagList.stream().map(o -> o.getTagId()).collect(Collectors.toSet());
        // 获取tag信息
        List<Tag> tagList = tagDao.findByIdIn(tagIds);

        Map<Long, List<PhotoTag>> photoTagMap = photoTagList.stream().collect(Collectors.groupingBy(PhotoTag::getPhotoId));
        ImmutableMap<Long, Tag> tagMap = Maps.uniqueIndex(tagList, o -> o.getId());
        pager.getContent().forEach(photoInfo -> {
            List<PhotoTag> photoTags = photoTagMap.get(photoInfo.getId());
            List<Tag> tags = Lists.newArrayList();
            if (photoTags != null) {
                photoTags.forEach(photoTag -> {
                    Tag tag = tagMap.get(photoTag.getTagId());
                    tags.add(tag);
                });
            }
            photoInfo.setTags(tags);
        });

        return pager;
    }

    public void fetchPhotoFromQiniu() {
        List<QiniuFile> qiniuFiles = qiniuClient.list();
        List<PhotoInfo> list = Lists.newArrayList();
        for (QiniuFile file: qiniuFiles) {
            PhotoInfo photo = new PhotoInfo();
            photo.setHash(file.getHash());
            photo.setDeleted(false);
            photo.setPath(file.getKey());
            photo.setSyncTime(LocalDateTime.now());
            list.add(photo);
        }
        photoInfoDao.save(list);
    }

}
