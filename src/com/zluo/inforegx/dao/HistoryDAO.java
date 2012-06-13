package com.zluo.inforegx.dao;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.zluo.inforegx.model.History;
import com.zluo.inforegx.util.PMF;


public class HistoryDAO {

	
	public List<History> listHistory() {
		PersistenceManager manager = PMF.get().getPersistenceManager();
		Query query = manager.newQuery(History.class);
		return (List<History>) query.execute();
	}

	
	public void addHistory() {
		PersistenceManager manager = PMF.get().getPersistenceManager();
		try {
			manager.currentTransaction().begin();
			manager.makePersistent(new History());
			manager.currentTransaction().commit();
		}
        finally
        {
        	manager.close();
        }
	}

}
