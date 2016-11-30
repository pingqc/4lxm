package com.pingqc.exls.forlxm.model.photo;

import com.google.common.base.MoreObjects;
import com.pingqc.exls.forlxm.model.pk.PhotoTagPk;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by pingqc on 16/9/3.
 */
@Entity
@Table(name = "photo_info_tags")
@IdClass(PhotoTagPk.class)
public class PhotoTag implements Serializable {

    @Id
    private Long photoId;
    @Id
    private Long tagId;

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("photoId", photoId)
                .add("tagId", tagId)
                .toString();
    }
}
