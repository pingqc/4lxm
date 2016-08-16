package com.pingqc.exls.forlxm.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.pingqc.exls.forlxm.model.pk.LogisticTracePk;

/**
 * Created by pingqc on 2016/8/16.
 */
@Entity
public class LogisticTrace implements Serializable {

	@EmbeddedId
	private LogisticTracePk pk;

	private String trace;
	private String status;

	public LogisticTracePk getPk() {
		return pk;
	}

	public void setPk(LogisticTracePk pk) {
		this.pk = pk;
	}

	public String getTrace() {
		return trace;
	}

	public void setTrace(String trace) {
		this.trace = trace;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
