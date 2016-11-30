package com.pingqc.exls.forlxm.model.pk;

import java.io.Serializable;

/**
 * Created by pingqc on 16/9/3.
 */
public class PhotoTagPk implements Serializable {

    private Long photoId;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhotoTagPk that = (PhotoTagPk) o;

        if (photoId != null ? !photoId.equals(that.photoId) : that.photoId != null) return false;
        return tagId != null ? tagId.equals(that.tagId) : that.tagId == null;

    }

    @Override
    public int hashCode() {
        int result = photoId != null ? photoId.hashCode() : 0;
        result = 31 * result + (tagId != null ? tagId.hashCode() : 0);
        return result;
    }
}
