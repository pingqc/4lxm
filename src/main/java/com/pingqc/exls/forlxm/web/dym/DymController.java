package com.pingqc.exls.forlxm.web.dym;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pingqc.exls.forlxm.model.DymRecord;
import com.pingqc.exls.forlxm.service.dym.DymService;

/**
 * Created by pingqc on 16/3/28.
 */
@RestController
@RequestMapping("/dym")
public class DymController {

    @Autowired
    DymService dymService;

    @RequestMapping("/data")
    public List<DymRecord> data() {
        return dymService.queryAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public List<DymRecord> record(Date date) {
        dymService.add(date);
        return dymService.queryAll();
    }

    @RequestMapping(value="/days", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int days() {
        return dymService.daysFromLastDymComes();
    }

}
