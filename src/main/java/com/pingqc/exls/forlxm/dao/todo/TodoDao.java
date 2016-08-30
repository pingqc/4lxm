package com.pingqc.exls.forlxm.dao.todo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pingqc.exls.forlxm.domain.TodoStatus;
import com.pingqc.exls.forlxm.model.Todo;

/**
 * Created by pingqc on 16/4/12.
 */
@Repository
public interface TodoDao extends JpaRepository<Todo, Integer> {

    @Query("from Todo where status != 2 order by createTime, finishTime")
    List<Todo> queryAll();

}
