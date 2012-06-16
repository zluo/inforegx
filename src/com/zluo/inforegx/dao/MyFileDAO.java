package com.zluo.inforegx.dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.zluo.inforegx.model.History;
import com.zluo.inforegx.model.MyFile;
import com.zluo.inforegx.util.PMF;


public class MyFileDAO {

	
	public List<MyFile> list() {
		PersistenceManager manager = PMF.get().getPersistenceManager();
		Query query = manager.newQuery(MyFile.class);
		return (List<MyFile>) query.execute();
	}

	public List<MyFile> delete() {
		PersistenceManager manager = PMF.get().getPersistenceManager();
		Query query = manager.newQuery(MyFile.class);
		return (List<MyFile>) query.execute();
	}

	
	public void add(MyFile file) {
		PersistenceManager manager = PMF.get().getPersistenceManager();
		try {
			manager.currentTransaction().begin();
			manager.makePersistent(file);
			manager.currentTransaction().commit();
		}
        finally
        {
        	manager.close();
        }
	}

}
