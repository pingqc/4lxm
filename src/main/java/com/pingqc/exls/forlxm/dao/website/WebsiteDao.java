package com.pingqc.exls.forlxm.dao.website;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pingqc.exls.forlxm.model.Website;

/**
 * Created by pingqc on 16/4/2.
 */
@Repository
public interface WebsiteDao extends JpaRepository<Website, Long> {

}
