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

@WebServlet("/BenchmarkTest02380")
public class BenchmarkTest02380 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		org.owasp.benchmark.helpers.SeparateClassRequest scr = new org.owasp.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("vector");
		if (param == null) param = "";

		String bar = doSomething(param);
		
		String fileName = null;
		java.io.FileOutputStream fos = null;

		try {
			fileName = org.owasp.benchmark.helpers.Utils.testfileDir + bar;
	
			fos = new java.io.FileOutputStream(new java.io.File(fileName));
	        response.getWriter().write("Now ready to write to file: " + fileName);
		} catch (Exception e) {
			System.out.println("Couldn't open FileOutputStream on file: '" + fileName + "'");
//			System.out.println("File exception caught and swallowed: " + e.getMessage());
		} finally {
			if (fos != null) {
				try {
					fos.close();
                    fos = null;
				} catch (Exception e) {
					// we tried...
				}
			}
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a97064 = param; //assign
		StringBuilder b97064 = new StringBuilder(a97064);  // stick in stringbuilder
		b97064.append(" SafeStuff"); // append some safe content
		b97064.replace(b97064.length()-"Chars".length(),b97064.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map97064 = new java.util.HashMap<String,Object>();
		map97064.put("key97064", b97064.toString()); // put in a collection
		String c97064 = (String)map97064.get("key97064"); // get it back out
		String d97064 = c97064.substring(0,c97064.length()-1); // extract most of it
		String e97064 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d97064.getBytes() ) )); // B64 encode and decode it
		String f97064 = e97064.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g97064 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g97064); // reflection
	
		return bar;	
	}
}
