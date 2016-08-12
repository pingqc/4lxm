package com.pingqc.exls.forlxm.domain;

import java.io.Serializable;

/**
 * Created by pingqc on 16/4/12.
 */
public class Todo implements Serializable {

    private int id;
    private String content;
    private Long createTime;
    private Long finishTime;
    /**
     * 0-todo
     * 1-done
     * 2-canceled
     */
    private int status;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
