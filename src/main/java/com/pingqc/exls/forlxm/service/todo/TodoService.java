package com.pingqc.exls.forlxm.service.todo;

import com.pingqc.exls.forlxm.dao.todo.TodoDao;
import com.pingqc.exls.forlxm.domain.ErrorCode;
import com.pingqc.exls.forlxm.domain.Todo;
import com.pingqc.exls.forlxm.exception.ExlsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        todoDao.add(content);
    }

    public void delete(int id) {
        Todo todo = todoDao.getOne(id);
        if (todo == null) {
            return;
        }
        todo.setStatus(2); // 删除标记
        todoDao.update(todo);
    }

    public void update(int id, String content) {
        Todo todo = todoDao.getOne(id);
        if (todo == null) {
            throw new ExlsException(ErrorCode.TODO_NOT_FOUND);
        }
        todo.setContent(content);
        todoDao.update(todo);
    }

    /**
     * 待办完成
     * @param id
     */
    public void finish(int id) {
        Todo todo = todoDao.getOne(id);
        if (todo == null) {
            throw new ExlsException(ErrorCode.TODO_NOT_FOUND);
        }
        todo.setStatus(1);
        todo.setFinishTime(System.currentTimeMillis());
        todoDao.update(todo);
    }

    /**
     * 撤销待办完成
     * @param id
     */
    public void unfinish(int id) {
        Todo todo = todoDao.getOne(id);
        if (todo == null) {
            throw new ExlsException(ErrorCode.TODO_NOT_FOUND);
        }
        todo.setStatus(0);
        todo.setFinishTime(System.currentTimeMillis());
        todoDao.update(todo);
    }

    /**
     * 取消待办
     * @param id
     */
    public void cancel(int id) {
        Todo todo = todoDao.getOne(id);
        if (todo == null) {
            throw new ExlsException(ErrorCode.TODO_NOT_FOUND);
        }
        todo.setStatus(2);
        todoDao.update(todo);
    }

    public Todo getOne(int id) {
        return todoDao.getOne(id);
    }

}
