package com.pingqc.exls.forlxm.dao.photo;

import com.pingqc.exls.forlxm.model.photo.PhotoTag;
import com.pingqc.exls.forlxm.model.pk.PhotoTagPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

/**
 * Created by pingqc on 16/9/3.
 */
public interface PhotoTagDao extends JpaRepository<PhotoTag, PhotoTagPk>{

    List<PhotoTag> findByPhotoIdIn(Collection<Long> photoIds);

    @Query(value = "select tag_id, count(*) as cnt from photo_info_tags group by tag_id", nativeQuery = true)
    List<Object[]> countPhotoOfEveryTag();

    void deleteByTagId(Long tagId);

}
