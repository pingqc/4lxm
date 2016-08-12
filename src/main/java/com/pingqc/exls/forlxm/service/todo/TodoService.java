package com.pingqc.exls.forlxm.service.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pingqc.exls.forlxm.dao.todo.TodoDao;
import com.pingqc.exls.forlxm.domain.ErrorCode;
import com.pingqc.exls.forlxm.domain.TodoStatus;
import com.pingqc.exls.forlxm.exception.ExlsException;
import com.pingqc.exls.forlxm.model.Todo;

/**
 * Created by pingqc on 16/4/12.
 */
@Service
//@Transactional
public class TodoService {

    @Autowired
    TodoDao todoDao;

    public List<Todo> queryAll() {
        return todoDao.queryAll();
    }

    public void add(String content) {
        Todo todo = new Todo();
        todo.setContent(content);
        todo.setCreateTime(System.currentTimeMillis());
        todoDao.save(todo);
    }

    public void delete(long id) {
        Todo todo = todoDao.findOne(id);
        if (todo == null) {
            return;
        }
        todo.setStatus(TodoStatus.CANCELED); // 删除标记
        // todoDao.update(todo);
    }

    public Todo update(long id, String content) {
        Todo todo = todoDao.findOne(id);
        if (todo == null) {
            throw new ExlsException(ErrorCode.TODO_NOT_FOUND);
        }
        todo.setContent(content);
        // todoDao.update(todo);
        return todo;
    }

    /**
     * 待办完成
     * @param id
     */
    public Todo finish(long id) {
        Todo todo = todoDao.findOne(id);
        if (todo == null) {
            throw new ExlsException(ErrorCode.TODO_NOT_FOUND);
        }
        todo.setStatus(TodoStatus.DONE);
        todo.setFinishTime(System.currentTimeMillis());
        return todo;
        // todoDao.update(todo);
    }

    /**
     * 撤销待办完成
     * @param id
     */
    public Todo unfinish(long id) {
        Todo todo = todoDao.findOne(id);
        if (todo == null) {
            throw new ExlsException(ErrorCode.TODO_NOT_FOUND);
        }
        todo.setStatus(TodoStatus.TODO);
        todo.setFinishTime(System.currentTimeMillis());
        return todo;
        // todoDao.update(todo);
    }

    /**
     * 取消待办
     * @param id
     */
    public void cancel(long id) {
        Todo todo = todoDao.findOne(id);
        if (todo == null) {
            throw new ExlsException(ErrorCode.TODO_NOT_FOUND);
        }
        todo.setStatus(TodoStatus.CANCELED);
        // todoDao.update(todo);
    }

    public Todo getOne(long id) {
        return todoDao.findOne(id);
    }

}
