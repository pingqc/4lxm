package com.pingqc.exls.forlxm.dao.dym;

import com.pingqc.exls.forlxm.domain.DymRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by pingqc on 16/3/28.
 */
@Repository
public class DymDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<DymRecord> queryAll() {
        final String SQL = "SELECT ID, DATE FROM LXM_DYM ORDER BY DATE DESC";
        return jdbcTemplate.query(SQL, new RowMapper<DymRecord>() {
            @Override
            public DymRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
                DymRecord bean = new DymRecord();
                bean.setId(rs.getLong("ID"));
                bean.setDate(rs.getDate("DATE"));
                return bean;
            }
        });
    }

    public void add(String date) {
        final String SQL = "INSERT INTO LXM_DYM(DATE) VALUES(?)";
        jdbcTemplate.update(SQL, new Object[]{
                date
        });
    }

    public DymRecord queryByDate(String date) {
        final String SQL = "SELECT ID, DATE FROM LXM_DYM WHERE DATE = ?";
        try {
            return jdbcTemplate.queryForObject(SQL, new Object[]{date}, new RowMapper<DymRecord>() {
                @Override
                public DymRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
                    DymRecord bean = new DymRecord();
                    bean.setId(rs.getLong("ID"));
                    bean.setDate(rs.getDate("DATE"));
                    return bean;
                }
            });
        } catch (DataAccessException e) {
            if (e instanceof EmptyResultDataAccessException) {
                return null;
            } else {
                throw e;
            }
        }
    }

    /**
     * 获取最近一条数据
     * @return 最近一条数据 或 null
     */
    public DymRecord getNewestOne() {
        final String SQL = "SELECT * FROM LXM_DYM ORDER BY DATE DESC LIMIT 1";
        try {
            return jdbcTemplate.queryForObject(SQL, new RowMapper<DymRecord>() {
                @Override
                public DymRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
                    DymRecord bean = new DymRecord();
                    bean.setId(rs.getLong("ID"));
                    bean.setDate(rs.getDate("DATE"));
                    return bean;
                }
            });
        } catch (DataAccessException e) {
            if (e instanceof EmptyResultDataAccessException) {
                return null;
            } else {
                throw e;
            }
        }
    }
}
