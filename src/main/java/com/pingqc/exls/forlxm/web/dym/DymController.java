package com.pingqc.exls.forlxm.web.dym;

import com.pingqc.exls.forlxm.domain.DymRecord;
import com.pingqc.exls.forlxm.service.dym.DymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public List<DymRecord> record(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            sdf.parse(date);
            dymService.add(date);
        } catch (ParseException e) {
        }
        return dymService.queryAll();
    }

    @RequestMapping(value="/days", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int days() {
        return dymService.daysFromLastDymComes();
    }

}
