package com.pingqc.exls.forlxm.dao.todo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pingqc.exls.forlxm.domain.TodoStatus;
import com.pingqc.exls.forlxm.model.Todo;

/**
 * Created by pingqc on 16/4/12.
 */
@Repository
public class TodoDao2 {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 添加待办
     * @param content
     */
    public void add(String content) {
        final String SQL = "INSERT INTO LXM_TODOS(ID, CONTENT, CREATE_TIME, FINISH_TIME, STATUS) VALUES(NULL, ?, ?, NULL, 0)";
        jdbcTemplate.update(SQL, new Object[]{
                content,
                System.currentTimeMillis()
        });
    }

    /**
     * 更新待办事项
     * @param todo
     */
    public void update(Todo todo) {
        final String SQL = "UPDATE LXM_TODOS SET CONTENT = ?, FINISH_TIME = ?, STATUS = ? WHERE ID = ?";
        jdbcTemplate.update(SQL, new Object[]{
                todo.getContent(),
                todo.getFinishTime(),
                todo.getStatus(),
                todo.getId()
        });
    }

    /**
     * 查询所有（排除删除状态）
     * @return
     */
    public List<Todo> queryAll() {
        final String SQL = "SELECT ID, CONTENT, CREATE_TIME, FINISH_TIME, STATUS FROM LXM_TODOS WHERE STATUS <> 2 ORDER BY CREATE_TIME, FINISH_TIME";
        return jdbcTemplate.query(SQL, new RowMapper<Todo>() {
            @Override
            public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
                Todo todo = new Todo();
                todo.setId(rs.getInt("ID"));
                todo.setContent(rs.getString("CONTENT"));
                todo.setCreateTime(rs.getLong("CREATE_TIME"));
                todo.setFinishTime(rs.getLong("FINISH_TIME"));
                todo.setStatus(TodoStatus.values()[rs.getInt("STATUS")]);
                return todo;
            }
        });
    }

    /**
     * 根据id查询待办信息
     * @param id
     * @return
     */
    public Todo getOne(int id) {
        final String SQL = "SELECT ID, CONTENT, CREATE_TIME, FINISH_TIME, STATUS FROM LXM_TODOS WHERE ID = ?";
        try {
            return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new RowMapper<Todo>() {
                @Override
                public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Todo todo = new Todo();
                    todo.setId(rs.getInt("ID"));
                    todo.setContent(rs.getString("CONTENT"));
                    todo.setCreateTime(rs.getLong("CREATE_TIME"));
                    todo.setFinishTime(rs.getLong("FINISH_TIME"));
                    todo.setStatus(TodoStatus.values()[rs.getInt("STATUS")]);
                    return todo;
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
