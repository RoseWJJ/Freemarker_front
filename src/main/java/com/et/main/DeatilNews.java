package com.et.main;

import java.io.File;

/**
 * Servlet implementation class DeatilNews
 */
public class DeatilNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeatilNews() {
     
    }

    public static final String HTML_DIR = "E:\\html\\";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getParameter("path");
		String abString =HTML_DIR+path;
		byte[] bs;
		try {
			bs = FileUtils.readFileToByteArray(new File(abString));
			response.getOutputStream().write(bs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
		doGet(request, response);
	}

}
