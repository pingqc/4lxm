package com.pingqc.exls.forlxm.service.photo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.pingqc.exls.forlxm.dao.photo.PhotoTagDao;
import com.pingqc.exls.forlxm.dao.photo.TagDao;
import com.pingqc.exls.forlxm.exception.ExlsException;
import com.pingqc.exls.forlxm.model.photo.Tag;

/**
 * Created by pingqc on 16/9/9.
 */
@Service
public class TagService {

    @Autowired
    TagDao tagDao;

    @Autowired
    PhotoTagDao photoTagDao;

    public List<Tag> findAll() {
        return tagDao.findAll();
    }

    /**
     * 统计tag对应照片数
     *
     * @return key: tagId; value: cnt
     */
    public ImmutableMap<Object, Object> getTagStatistics() {
        List<Object[]> list = photoTagDao.countPhotoOfEveryTag();
        ImmutableMap.Builder<Object, Object> builder = ImmutableMap.builder();
        for (Object[] arr : list) {
            builder.put(arr[0], arr[1]);
        }
        return builder.build();
    }

    @Transactional
    public Tag update(Tag tag) {
        Tag model = tagDao.findOne(tag.getId());
        if (model == null) {
            throw new ExlsException("标签[id:"+tag.getId()+"]不存在");
        }
        model.setBgcolor(tag.getBgcolor());
        model.setColor(tag.getColor());
        model.setName(tag.getName());
        return model;
    }

    @Transactional
    public void delete(Long id) {
        photoTagDao.deleteByTagId(id);
        tagDao.delete(id);
    }

    public Tag add(Tag tag) {
        return tagDao.save(tag);
    }

    public List<Tag> filterByName(String name) {
        if (Strings.isNullOrEmpty(name)) {
            name = "%";
        } else {
            name = name + "%";
        }
        return tagDao.findByNameLike(name);
    }
}
