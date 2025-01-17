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

@WebServlet("/BenchmarkTest01882")
public class BenchmarkTest01882 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		javax.servlet.http.Cookie[] theCookies = request.getCookies();
		
		String param = "";
		if (theCookies != null) {
			for (javax.servlet.http.Cookie theCookie : theCookies) {
				if (theCookie.getName().equals("vector")) {
					param = java.net.URLDecoder.decode(theCookie.getValue(), "UTF-8");
					break;
				}
			}
		}

		String bar = doSomething(param);
		
 		try {
	        String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='" + bar + "'";
	
			java.util.List<String> results = org.owasp.benchmark.helpers.DatabaseHelper.JDBCtemplate.query(sql,  new org.springframework.jdbc.core.RowMapper<String>() {
	            public String mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
	                try {
	                	return rs.getString("USERNAME");
	                } catch (java.sql.SQLException e) {
	                	if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
	        				return "Error processing query.";
	        			}
						else throw e;
					}
	            }
	        });
			java.io.PrintWriter out = response.getWriter();
			
			out.write("Your results are: ");
	//		System.out.println("Your results are");
			for(String s : results){
				out.write(org.owasp.esapi.ESAPI.encoder().encodeForHTML(s) + "<br>");
	//			System.out.println(s);
			}
		} catch (org.springframework.dao.DataAccessException e) {
			if (org.owasp.benchmark.helpers.DatabaseHelper.hideSQLErrors) {
        		response.getWriter().println("Error processing request.");
        		return;
        	}
			else throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map36388 = new java.util.HashMap<String,Object>();
		map36388.put("keyA-36388", "a Value"); // put some stuff in the collection
		map36388.put("keyB-36388", param); // put it in a collection
		map36388.put("keyC", "another Value"); // put some stuff in the collection
		bar = (String)map36388.get("keyB-36388"); // get it back out
	
		return bar;	
	}
}
