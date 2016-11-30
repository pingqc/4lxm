package com.pingqc.exls.forlxm.web.photo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.ImmutableMap;
import com.pingqc.exls.forlxm.domain.AjaxResp;
import com.pingqc.exls.forlxm.model.photo.Tag;
import com.pingqc.exls.forlxm.service.photo.TagService;

/**
 * Created by pingqc on 16/9/1.
 */
@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    TagService tagService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Tag> list() {
        return tagService.findAll();
    }

    @RequestMapping(value = {"/filter"}, method = RequestMethod.GET)
    public List<Tag> filter(String keyword) {
        return tagService.filterByName(keyword);
    }

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public ImmutableMap<Object, Object> statistics() {
        return tagService.getTagStatistics();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Tag add(@RequestBody Tag tag) {
        return tagService.add(tag);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Tag modify(@RequestBody Tag tag, @PathVariable("id") Long id) {
        return tagService.update(tag);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public AjaxResp delete(@PathVariable("id") Long id) {
        tagService.delete(id);
        return new AjaxResp();
    }

}