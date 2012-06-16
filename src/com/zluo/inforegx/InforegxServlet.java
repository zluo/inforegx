package com.zluo.inforegx;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.*;

import com.zluo.inforegx.dao.HistoryDAO;
import com.zluo.inforegx.dao.MyFileDAO;
import com.zluo.inforegx.model.History;
import com.zluo.inforegx.model.MyFile;
import com.zluo.inforegx.service.EmailService;
import com.zluo.inforegx.service.IService;

@SuppressWarnings("serial")
public class InforegxServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		System.out.println("Before call send email");
		IService service = new EmailService(); 
		service.serve();
		System.out.println("After call send email");
		
		HistoryDAO jdo =new HistoryDAO();
		jdo.addHistory();
		
		resp.setContentType("text/html");
		
		resp.getWriter().println("<html><body>");
		resp.getWriter().println("Hello, world");
		
		List<History> collection = jdo.listHistory();
		
		for(History h: collection)
		{
			resp.getWriter().println ("<li>");
			resp.getWriter().println (h.getAccessDate());
			resp.getWriter().println ("</li>");
		}
		
		MyFileDAO myFileDAO = new MyFileDAO();
		List<MyFile> myFiles = myFileDAO.list();
		resp.getWriter().println("<hr>");
		
		for(MyFile myFile: myFiles)
		{
			resp.getWriter().println ("<li>");
			resp.getWriter().println ("<a href='xxx'>" +  myFile.getId() + "-" + myFile.getName() + "</a>");
			resp.getWriter().println ("</li>");
		}
		resp.getWriter().println("</body></html>");
	}
}
