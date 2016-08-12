package com.pingqc.exls.forlxm.web.todo;

import com.pingqc.exls.forlxm.domain.Todo;
import com.pingqc.exls.forlxm.service.todo.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by pingqc on 16/4/12.
 */
@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    @RequestMapping(value = {"/data/all", "/data"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Todo> queryAll() {
        return todoService.queryAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String add(String content) {
        todoService.add(content);
        return "{\"result\":\"success\"}";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Todo update(int id, String content) {
        todoService.update(id, content);
        return todoService.getOne(id);
    }

    @RequestMapping(value = "/finish/{id}", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Todo finish(@PathVariable("id") int id) {
        todoService.finish(id);
        return todoService.getOne(id);
    }

    @RequestMapping(value = "/unfinish/{id}", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Todo unfinish(@PathVariable("id") int id) {
        todoService.unfinish(id);
        return todoService.getOne(id);
    }

    @RequestMapping(value = "/cancel/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String cancel(@PathVariable("id") int id) {
        todoService.cancel(id);
        return "{\"result\":\"success\"}";
    }

}
