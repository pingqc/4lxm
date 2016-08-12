package com.pingqc.exls.forlxm.web.website;

import com.pingqc.exls.forlxm.domain.Website;
import com.pingqc.exls.forlxm.service.website.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by pingqc on 16/4/2.
 */
@RestController
@RequestMapping("/website")
public class WebsiteController {

    @Autowired
    WebsiteService websiteService;

    @RequestMapping(
            value = "/data",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Website> data() {
        return websiteService.queryAll();
    }

    @RequestMapping(
            value = "/add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public Object add(Website site) {
        websiteService.add(site);
        return "{\"result\":\"success\"}";
    }

    @RequestMapping(
            value = "/update",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public Object update(Website site) {
        websiteService.update(site);
        return "{\"result\":\"success\"}";
    }

    @RequestMapping(
            value = "/remove/{id}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public Object remove(@PathVariable("id") int id) {
        websiteService.remove(id);
        return "{\"result\":\"success\"}";
    }

}
