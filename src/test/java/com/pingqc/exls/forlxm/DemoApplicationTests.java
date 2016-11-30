package com.pingqc.exls.forlxm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pingqc.exls.forlxm.dao.photo.PhotoInfoDao;
import com.pingqc.exls.forlxm.dao.photo.PhotoTagDao;
import com.pingqc.exls.forlxm.dao.photo.TagDao;
import com.pingqc.exls.forlxm.model.photo.Tag;
import com.pingqc.exls.forlxm.service.photo.TagService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
public class DemoApplicationTests {

    @Autowired
    PhotoInfoDao photoInfoDao;

    @Autowired
    PhotoTagDao photoTagDao;

    @Autowired
    TagDao tagDao;

    @Autowired
    TagService tagService;

    @Test
    public void test() {
        Tag tag = new Tag();
        tag.setName("xxx");
        tag.setBgcolor("#abc124");
        tag.setColor("#ffee22");
        tagService.add(tag);
    }

}
