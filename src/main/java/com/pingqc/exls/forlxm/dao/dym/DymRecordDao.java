package com.pingqc.exls.forlxm.dao.dym;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pingqc.exls.forlxm.model.DymRecord;

/**
 * Created by darcy on 2016/8/12.
 */
@Repository
public interface DymRecordDao extends JpaRepository<DymRecord, Long> {

	Optional<DymRecord> findByDate(Date date);

	@Query(value = "SELECT * FROM LXM_DYM ORDER BY DATE DESC LIMIT 1", nativeQuery = true)
	Optional<DymRecord> getNewestOne();

}
