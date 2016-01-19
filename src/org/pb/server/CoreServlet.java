package org.pb.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.*;
import org.dom4j.io.*;

import org.pb.util.SignUtil;

/**
 * Servlet implementation class CoreServlet
 */
@WebServlet("/CoreServlet")
public class CoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sign = request.getParameter("signature");
		
		String timestamp = request.getParameter("timestamp");
		
		String random_num = request.getParameter("nonce");
		
		String random_str = request.getParameter("echostr");
		
		PrintWriter out = response.getWriter();
		
		if (sign == "" || timestamp == "" || random_num == "" || random_str == "")
		{
			out.print("<html><head><title>hello</title></head><body><span>hello world</span></body></html>");
		}
		else 
		{
			if (SignUtil.check(sign, timestamp, random_num))
			{
				out.print(random_str);
			}
		}
		
		out.close();
		out = null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String resp_msg = CoreService.process(request);
		
		PrintWriter writer = response.getWriter();
		writer.print(resp_msg);
		writer.close();
		
	}
	
	
}



