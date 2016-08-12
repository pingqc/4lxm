package com.pingqc.exls.forlxm.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by pingqc on 16/3/28.
 */
@Entity
@Table(name = "LXM_DYM")
public class DymRecord {

    @Id
    private long id;
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
