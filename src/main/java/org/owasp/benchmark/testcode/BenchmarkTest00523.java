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

@WebServlet("/BenchmarkTest00523")
public class BenchmarkTest00523 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		String param = "";
		boolean flag = true;
		java.util.Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements() && flag) {
			String name = (String) names.nextElement();		    	
			String[] values = request.getParameterValues(name);
			if (values != null) {
				for(int i=0;i<values.length && flag; i++){
					String value = values[i];
					if (value.equals("vector")) {
						param = name;
					    flag = false;
					}
				}
			}
		}
		
		
		// Chain a bunch of propagators in sequence
		String a44178 = param; //assign
		StringBuilder b44178 = new StringBuilder(a44178);  // stick in stringbuilder
		b44178.append(" SafeStuff"); // append some safe content
		b44178.replace(b44178.length()-"Chars".length(),b44178.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map44178 = new java.util.HashMap<String,Object>();
		map44178.put("key44178", b44178.toString()); // put in a collection
		String c44178 = (String)map44178.get("key44178"); // get it back out
		String d44178 = c44178.substring(0,c44178.length()-1); // extract most of it
		String e44178 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d44178.getBytes() ) )); // B64 encode and decode it
		String f44178 = e44178.split(" ")[0]; // split it on a space
		org.owasp.benchmark.helpers.ThingInterface thing = org.owasp.benchmark.helpers.ThingFactory.createThing();
		String g44178 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g44178); // reflection
		
		
		// Code based on example from:
		// http://examples.javacodegeeks.com/core-java/crypto/encrypt-decrypt-file-stream-with-des/

		try {
			javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("RSA/ECB/PKCS1Padding", "SunJCE");
            // Prepare the cipher to encrypt
            java.security.KeyPairGenerator keyGen = java.security.KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(1024);
            java.security.PublicKey publicKey= keyGen.genKeyPair().getPublic();
            c.init(javax.crypto.Cipher.ENCRYPT_MODE, publicKey);
			
			// encrypt and store the results
			byte[] input = { (byte)'?' };
			Object inputParam = bar;
			if (inputParam instanceof String) input = ((String) inputParam).getBytes();
			if (inputParam instanceof java.io.InputStream) {
				byte[] strInput = new byte[1000];
				int i = ((java.io.InputStream) inputParam).read(strInput);
				if (i == -1) {
					response.getWriter().println("This input source requires a POST, not a GET. Incompatible UI for the InputStream source.");
					return;
				}
				input = java.util.Arrays.copyOf(strInput, i);
			}
			byte[] result = c.doFinal(input);
			
			java.io.File fileTarget = new java.io.File(
					new java.io.File(org.owasp.benchmark.helpers.Utils.testfileDir),"passwordFile.txt");
			java.io.FileWriter fw = new java.io.FileWriter(fileTarget,true); //the true will append the new data
			    fw.write("secret_value=" + org.owasp.esapi.ESAPI.encoder().encodeForBase64(result, true) + "\n");
			fw.close();
			response.getWriter().println("Sensitive value: '" + org.owasp.esapi.ESAPI.encoder().encodeForHTML(new String(input)) + "' encrypted and stored<br/>");
			
		} catch (java.security.NoSuchAlgorithmException e) {
			response.getWriter().println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) Test Case");
			e.printStackTrace(response.getWriter());
			throw new ServletException(e);
		} catch (java.security.NoSuchProviderException e) {
			response.getWriter().println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) Test Case");
			e.printStackTrace(response.getWriter());
			throw new ServletException(e);
		} catch (javax.crypto.NoSuchPaddingException e) {
			response.getWriter().println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) Test Case");
			e.printStackTrace(response.getWriter());
			throw new ServletException(e);
		} catch (javax.crypto.IllegalBlockSizeException e) {
			response.getWriter().println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) Test Case");
			e.printStackTrace(response.getWriter());
			throw new ServletException(e);
		} catch (javax.crypto.BadPaddingException e) {
			response.getWriter().println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) Test Case");
			e.printStackTrace(response.getWriter());
			throw new ServletException(e);
		} catch (java.security.InvalidKeyException e) {
			response.getWriter().println("Problem executing crypto - javax.crypto.Cipher.getInstance(java.lang.String,java.security.Provider) Test Case");
			e.printStackTrace(response.getWriter());
			throw new ServletException(e);
		}
		response.getWriter().println("Crypto Test javax.crypto.Cipher.getInstance(java.lang.String,java.lang.String) executed");
	}
}
