package com.pingqc.exls.forlxm.service.dym;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pingqc.exls.forlxm.dao.dym.DymRecordDao;
import com.pingqc.exls.forlxm.model.DymRecord;

/**
 * Created by pingqc on 16/3/28.
 */
@Service
public class DymService {

    @Autowired
    DymRecordDao dymRecordDao;

    public List<DymRecord> queryAll() {
        return dymRecordDao.findAll();
    }

    public void add(Date date) {
        Optional<DymRecord> optional = dymRecordDao.findByDate(date);
        if (!optional.isPresent()) {
            DymRecord record = new DymRecord();
            record.setDate(date);
            dymRecordDao.save(record);
        }
    }

    public int daysFromLastDymComes() {
        Optional<DymRecord> record = dymRecordDao.getNewestOne();
        if (!record.isPresent()) {
            return 0;
        }
        DateTime d1 = new DateTime(record.get().getDate());
        DateTime d2 = new DateTime(System.currentTimeMillis());
        return Days.daysBetween(d1, d2).getDays();
    }
}
