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
* @author Dave Wichers <a href="https://www.aspectsecurity.com">Aspect Security</a>
* @created 2015
*/

package org.owasp.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01569")
public class BenchmarkTest01569 extends HttpServlet {
	
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

		String bar = new Test().doSomething(param);
		
	org.owasp.benchmark.helpers.LDAPManager ads = new org.owasp.benchmark.helpers.LDAPManager();
	try {
			response.setContentType("text/html");
			javax.naming.directory.DirContext ctx = ads.getDirContext();
			String base = "ou=users,ou=system";
			javax.naming.directory.SearchControls sc = new javax.naming.directory.SearchControls();
			sc.setSearchScope(javax.naming.directory.SearchControls.SUBTREE_SCOPE);
			String filter = "(&(objectclass=person)(uid=" + bar
					+ "))";
			System.out.println("Filter " + filter);
			javax.naming.NamingEnumeration<javax.naming.directory.SearchResult> results = ctx.search(base, filter, sc);
			while (results.hasMore()) {
				javax.naming.directory.SearchResult sr = (javax.naming.directory.SearchResult) results.next();
				javax.naming.directory.Attributes attrs = sr.getAttributes();

				javax.naming.directory.Attribute attr = attrs.get("uid");
				javax.naming.directory.Attribute attr2 = attrs.get("street");
				if (attr != null){
					response.getWriter().write("LDAP query results:<br>"
							+ " Record found with name " + attr.get() + "<br>"
									+ "Address: " + attr2.get()+ "<br>");
					System.out.println("record found " + attr.get());
				}
			}
	} catch (javax.naming.NamingException e) {
		throw new ServletException(e);
	}finally{
    	try {
    		ads.closeDirContext();
		} catch (Exception e) {
			throw new ServletException(e);
		}
    }
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a43226 = param; //assign
		StringBuilder b43226 = new StringBuilder(a43226);  // stick in stringbuilder
		b43226.append(" SafeStuff"); // append some safe content
		b43226.replace(b43226.length()-"Chars".length(),b43226.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map43226 = new java.util.HashMap<String,Object>();
		map43226.put("key43226", b43226.toString()); // put in a collection
		String c43226 = (String)map43226.get("key43226"); // get it back out
		String d43226 = c43226.substring(0,c43226.length()-1); // extract most of it
		String e43226 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d43226.getBytes() ) )); // B64 encode and decode it
		String f43226 = e43226.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g43226 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g43226); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
