package com.zluo.inforegx.model;


import java.util.Date;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class History {
	@PrimaryKey
    private String id=null;
	
	private String accessDate= new Date().toString();

	public String getAccessDate() {
		return accessDate;
	}

	public void setAccessDate(String accessDate) {
		this.accessDate = accessDate;
	}


	
}
