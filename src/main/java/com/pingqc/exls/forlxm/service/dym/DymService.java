package com.pingqc.exls.forlxm.service.dym;

import com.pingqc.exls.forlxm.dao.dym.DymDao;
import com.pingqc.exls.forlxm.domain.DymRecord;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pingqc on 16/3/28.
 */
@Service
public class DymService {

    @Autowired
    DymDao dymDao;

    public List<DymRecord> queryAll() {
        return dymDao.queryAll();
    }

    public void add(String date) {
        if (dymDao.queryByDate(date) == null) {
            dymDao.add(date);
        }
    }

    /**
     * 距离上一次dym来的天数
     * @return
     */
    public int daysFromLastDymComes() {
        DymRecord record = dymDao.getNewestOne();
        if (record == null) {
            return 0;
        }
        DateTime d1 = new DateTime(record.getDate());
        DateTime d2 = new DateTime(System.currentTimeMillis());
        return Days.daysBetween(d1, d2).getDays();
    }
}
