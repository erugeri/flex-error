package com.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.security.SecureRandom;
import java.math.BigInteger;

public class Test extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private SecureRandom random = new SecureRandom();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer step = 1;
		if (req.getParameter("step") != null) {
			step = Integer.valueOf(req.getParameter("step"));
		}

		StringBuilder sb = new StringBuilder();
		sb.append("<html><body>");
		sb.append("<h1>Step "+step+" - "+(step*step)+" lines</h1>");
		sb.append("<div style='font-size:8px;'>");	
		for (int i=0; i < step; i++) {
			for (int j=0; j < step; j++) {
				sb.append(new BigInteger(1024, random).toString(64)+"<br/>");
			}
		}
		sb.append("</div>");
		sb.append("<script type='text/javascript'>setTimeout(function(){ window.location='test?step="+(step+1)+"'; }, 1000);</script>");
		sb.append("</body></html>");
		resp.getOutputStream().write(sb.toString().getBytes("UTF-8"));
	}
}