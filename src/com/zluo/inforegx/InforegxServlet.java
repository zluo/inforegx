package com.zluo.inforegx;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.*;

import com.zluo.inforegx.jdo.HistoryJDO;
import com.zluo.inforegx.model.History;

@SuppressWarnings("serial")
public class InforegxServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		
		HistoryJDO jdo =new HistoryJDO();
		jdo.addHistory();
		
		resp.setContentType("text/plain");
		
		resp.getWriter().println("Hello, world");
		
		List<History> collection = jdo.listHistory();
		
		for(History h: collection)
		{
			resp.getWriter().println (h.getAccessDate());
		}
		
	}
}
