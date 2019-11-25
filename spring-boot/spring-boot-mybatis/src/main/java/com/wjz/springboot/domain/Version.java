package com.wjz.springboot.domain;

import java.io.Serializable;
import java.util.Date;

public class Version implements Serializable {

	private static final long serialVersionUID = 3566843751261101988L;
	
	private Integer id;
	
	private String version;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Version{" +
				"id=" + id +
				", version='" + version + '\'' +
				'}';
	}
}
