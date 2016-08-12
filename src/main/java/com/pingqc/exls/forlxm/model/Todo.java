package com.pingqc.exls.forlxm.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pingqc.exls.forlxm.domain.TodoStatus;

/**
 * Created by pingqc on 16/4/12.
 */
@Entity
@Table(name = "LXM_TODOS")
public class Todo implements Serializable {

    @Id
    private int id;
    private String content;
    private Long createTime;
    private Long finishTime;
    @Enumerated(EnumType.ORDINAL)
    private TodoStatus status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Long finishTime) {
        this.finishTime = finishTime;
    }

    public TodoStatus getStatus() {
        return status;
    }

    public void setStatus(TodoStatus status) {
        this.status = status;
    }
}
