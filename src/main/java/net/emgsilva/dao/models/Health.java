package net.emgsilva.dao.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Health {

	private String status;

	protected Health() {
	}

	public Health(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
