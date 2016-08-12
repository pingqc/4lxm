package com.pingqc.exls.forlxm.service.website;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pingqc.exls.forlxm.dao.website.WebsiteDao;
import com.pingqc.exls.forlxm.model.Website;

/**
 * Created by pingqc on 16/4/2.
 */
@Service
@Transactional
public class WebsiteService {

    @Autowired
    WebsiteDao websiteDao;

    @Cacheable("website")
    public List<Website> queryAll() {
        Sort sort = new Sort(Sort.Direction.ASC, "type").and(new Sort(Sort.Direction.ASC, "seqNo"));
        return websiteDao.findAll(sort);
    }

    @CacheEvict(value = "website", allEntries = true)
    public void add(Website site) {
        websiteDao.save(site);
    }

    @CacheEvict(value = "website", allEntries = true)
    public void update(Website site) {
        websiteDao.save(site);
    }

    @CacheEvict(value = "website", allEntries = true)
    public void remove(long id) {
        websiteDao.delete(id);
    }
}
