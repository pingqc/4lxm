package com.pingqc.exls.forlxm.dao.website;

import com.pingqc.exls.forlxm.domain.Website;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by pingqc on 16/4/2.
 */
@Repository
public class WebsiteDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebsiteDao.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Cacheable("website")
    public List<Website> queryAll() {
        final String SQL = "SELECT ID, URL, NAME, ICO, SEQ_NO, `KEY`, TYPE, CREATE_TIME, EDITABLE FROM LXM_WEBSITE ORDER BY TYPE, SEQ_NO";
        return jdbcTemplate.query(SQL, new RowMapper<Website>() {
            @Override
            public Website mapRow(ResultSet rs, int rowNum) throws SQLException {
                Website site = new Website();
                site.setId(rs.getInt("ID"));
                site.setUrl(rs.getString("URL"));
                site.setName(rs.getString("NAME"));
                site.setIco(rs.getString("ICO"));
                site.setSeqNo(rs.getInt("SEQ_NO"));
                site.setKey(rs.getString("KEY"));
                site.setType(rs.getString("TYPE"));
                site.setCreateTime(rs.getLong("CREATE_TIME"));
                site.setEditable(rs.getBoolean("EDITABLE"));
                return site;
            }
        });
    }

    @CacheEvict(value = "website", allEntries = true)
    public void add(Website site) {
        final String SQL = "INSERT INTO LXM_WEBSITE(URL, NAME, ICO, `TYPE`, CREATE_TIME) VALUES(?, ?, ?, ?, ?)";
        jdbcTemplate.update(SQL, new Object[]{
                site.getUrl(),
                site.getName(),
                site.getIco(),
                site.getType(),
                System.currentTimeMillis()
        });
    }

    @CacheEvict(value = "website", allEntries = true)
    public void update(Website site) {
        final String SQL = "UPDATE LXM_WEBSITE SET NAME = ?, URL = ?, ICO = ?, `TYPE` = ? WHERE ID = ?";
        jdbcTemplate.update(SQL, new Object[]{
                site.getName(),
                site.getUrl(),
                site.getIco(),
                site.getType(),
                site.getId()
        });
    }

    @CacheEvict(value = "website", allEntries = true)
    public void remove(int id) {
        final String SQL = "DELETE FROM LXM_WEBSITE WHERE ID = ?";
        jdbcTemplate.update(SQL, new Object[]{id});
    }

}
