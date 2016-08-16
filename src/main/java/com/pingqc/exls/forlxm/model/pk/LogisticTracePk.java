package com.pingqc.exls.forlxm.model.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * Created by pingqc on 2016/8/16.
 */
@Embeddable
public class LogisticTracePk implements Serializable {

	private String shipperCode;
	private String logisticCode;

	public String getShipperCode() {
		return shipperCode;
	}

	public void setShipperCode(String shipperCode) {
		this.shipperCode = shipperCode;
	}

	public String getLogisticCode() {
		return logisticCode;
	}

	public void setLogisticCode(String logisticCode) {
		this.logisticCode = logisticCode;
	}
}
