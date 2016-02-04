package com.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class Testing
 */
@WebServlet(name = "logging", urlPatterns = { "/loggingEx" })
@MultipartConfig
public class LoggingExample extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7062164898853320106L;

	private final static Logger logger = Logger.getLogger(LoggingExample.class);

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// PrintWriter out = response.getWriter();
		try {
			for (int i = 0; i < 200; i++) {
				logger.info("Value of i: " + i);
				if (i > 195) {
					throw new Exception(
							"Demo Exception Value oF i greater than 195");
				}
			}

		} catch (Exception fe) {
			logger.error("Exception In doPost Method LoggingExample:", fe);
		} finally {
			request.setAttribute("log", readLog());
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	private String readLog() throws IOException {
		StringBuilder result = new StringBuilder();
		String folderPath = null;
		if (System.getenv("OPENSHIFT_DATA_DIR") != null) {
			folderPath = System.getenv("OPENSHIFT_DATA_DIR") + "/logs/";
		} else {
			folderPath = "C:\\Users\\Hemanth\\Desktop\\logs";
		}
		for (File inputFile : FileUtils.getFile(folderPath).listFiles()) {
			logger.info("Contents of file: " + inputFile.getName());
			result.append(
					"************************************************************")
					.append("\n")
					.append("*********Contents of file: " + inputFile.getName())
					.append("\n");

			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				result.append(strLine).append("\n");
			}
			br.close();
		}
		System.out.println(result.toString());
		return result.toString();

	}
}