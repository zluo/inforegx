package com.zluo.inforegx;

import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.google.appengine.api.datastore.Blob;
import com.zluo.inforegx.model.MyFile;
import com.zluo.inforegx.util.PMF;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadFileServlet extends HttpServlet {
  private static final Logger log =
      Logger.getLogger(UploadFileServlet.class.getName());

  public void doPost(HttpServletRequest req, HttpServletResponse res) {
	    // Get the image representation
	    ServletFileUpload upload = new ServletFileUpload();
	    FileItemIterator iter;
	    PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			iter = upload.getItemIterator(req);
	    FileItemStream imageItem = iter.next();
	    InputStream imgStream = imageItem.openStream();

	    // construct our entity objects
	    Blob imageBlob = new Blob(IOUtils.toByteArray(imgStream));
	    MyFile myImage = new MyFile(imageItem.getName(), imageBlob);

	    // persist image
	    pm.makePersistent(myImage);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    finally
	    {
	    	pm.close();
	    }

	    // respond to query
	    res.setContentType("text/plain");
	    try {
			res.getOutputStream().write("OK!".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  
  void imageFor(String name, HttpServletResponse res) {
	    // find desired image
	    PersistenceManager pm = PMF.get().getPersistenceManager();
	    Query query = pm.newQuery("select from MyImage " +
	        "where name = nameParam " +
	        "parameters String nameParam");
	    List<MyFile> results = (List<MyFile>)query.execute(name);
	    Blob image = results.iterator().next().getImage();

	    // serve the first image
	    res.setContentType("image/jpeg");
	    try {
			res.getOutputStream().write(image.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}