/**
* OWASP Benchmark Project v1.2beta
*
* This file is part of the Open Web Application Security Project (OWASP)
* Benchmark Project. For details, please see
* <a href="https://www.owasp.org/index.php/Benchmark">https://www.owasp.org/index.php/Benchmark</a>.
*
* The OWASP Benchmark is free software: you can redistribute it and/or modify it under the terms
* of the GNU General Public License as published by the Free Software Foundation, version 2.
*
* The OWASP Benchmark is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
* even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* @author Nick Sanidas <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02503")
public class BenchmarkTest02503 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String[] values = request.getParameterValues("vector");
		String param;
		if (values != null && values.length > 0)
		  param = values[0];
		else param = "";

		String bar = doSomething(param);
		
		int r = new java.util.Random().nextInt();
		String rememberMeKey = Integer.toString(r);
		
		String user = "Ingrid";
		String fullClassName = this.getClass().getName();
		String testCaseNumber = fullClassName.substring(fullClassName.lastIndexOf('.')+1+"BenchmarkTest".length());
		user+= testCaseNumber;
		
		String cookieName = "rememberMe" + testCaseNumber;
		
		boolean foundUser = false;
		javax.servlet.http.Cookie[] cookies = request.getCookies();
		for (int i = 0; cookies != null && ++i < cookies.length && !foundUser;) {
			javax.servlet.http.Cookie cookie = cookies[i];
			if (cookieName.equals(cookie.getName())) {
				if (cookie.getValue().equals(request.getSession().getAttribute(cookieName))) {
					foundUser = true;
				}
			}
		}
		
		if (foundUser) {
			response.getWriter().println("Welcome back: " + user + "<br/>");			
		} else {			
			javax.servlet.http.Cookie rememberMe = new javax.servlet.http.Cookie(cookieName, rememberMeKey);
			rememberMe.setSecure(true);
			request.getSession().setAttribute(cookieName, rememberMeKey);
			response.addCookie(rememberMe);
			response.getWriter().println(user + " has been remembered with cookie: " + rememberMe.getName() 
					+ " whose value is: " + rememberMe.getValue() + "<br/>");
		}
				
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a88835 = param; //assign
		StringBuilder b88835 = new StringBuilder(a88835);  // stick in stringbuilder
		b88835.append(" SafeStuff"); // append some safe content
		b88835.replace(b88835.length()-"Chars".length(),b88835.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map88835 = new java.util.HashMap<String,Object>();
		map88835.put("key88835", b88835.toString()); // put in a collection
		String c88835 = (String)map88835.get("key88835"); // get it back out
		String d88835 = c88835.substring(0,c88835.length()-1); // extract most of it
		String e88835 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d88835.getBytes() ) )); // B64 encode and decode it
		String f88835 = e88835.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g88835 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g88835); // reflection
	
		return bar;	
	}
}
