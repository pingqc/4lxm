package com.pingqc.exls.forlxm.dao.photo;

import com.pingqc.exls.forlxm.model.photo.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by pingqc on 16/8/31.
 */
public interface TagDao extends JpaRepository<Tag, Long> {

    List<Tag> findByIdIn(Collection<Long> ids);

    List<Tag> findByNameLike(String name);

}
