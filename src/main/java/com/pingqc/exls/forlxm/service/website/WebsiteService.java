package com.pingqc.exls.forlxm.service.website;

import com.pingqc.exls.forlxm.dao.website.WebsiteDao;
import com.pingqc.exls.forlxm.domain.Website;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pingqc on 16/4/2.
 */
@Service
@Transactional
public class WebsiteService {

    @Autowired
    WebsiteDao websiteDao;

    public List<Website> queryAll() {
        return websiteDao.queryAll();
    }

    public void add(Website site) {
        websiteDao.add(site);
    }

    public void update(Website site) {
        websiteDao.update(site);
    }

    public void remove(int id) {
        websiteDao.remove(id);
    }
}