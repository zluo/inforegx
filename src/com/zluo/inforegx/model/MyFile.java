package com.zluo.inforegx.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Blob;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class MyFile {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;

    @Persistent
    private String name;

    @Persistent
    Blob image;
    
    

    public MyFile(String name, Blob image) {
		super();
		this.name = name;
		this.image = image;
	}
	public Blob getImage()              { return image; }
	public void setImage(Blob image)    { this.image = image; }
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}

}