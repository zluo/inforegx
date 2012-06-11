package com.zluo.inforegx.jdo;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.zluo.inforegx.model.History;
import com.zluo.inforegx.util.PMF;

public class HistoryJDO {
	PersistenceManager manager;
	public List<History> listHistory()
  {
	  manager = PMF.get().getPersistenceManager();
	  Query query=manager.newQuery(History.class);
	  return (List<History>) query.execute();
  }
  
  public void addHistory()
  {
	  PersistenceManager manager = PMF.get().getPersistenceManager();
	  manager.currentTransaction().begin();
	  manager.makePersistent(new History());
	  manager.currentTransaction().commit();
  }
  
  
  
}
