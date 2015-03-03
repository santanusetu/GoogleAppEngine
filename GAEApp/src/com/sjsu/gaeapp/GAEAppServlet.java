package com.sjsu.gaeapp;

import java.io.IOException;
import com.google.appengine.api.datastore.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class GAEAppServlet extends HttpServlet 
{

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		String id = null, firstname = null, lastname = null, 
		department = null; 
		id = req.getParameter ("id");
		firstname = req.getParameter ("firstname");
		lastname = req.getParameter ("lastname");
		department = req.getParameter ("department");

		Entity student = new Entity ("student");
		student.setProperty("id", id);
		student.setProperty("firstname", firstname);
		student.setProperty("lastname", lastname);
		student.setProperty("department", department);
 
DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
 		datastore.put(student);
 
 		resp.getWriter().println("Hello, Santanu Here :)");
}
}
