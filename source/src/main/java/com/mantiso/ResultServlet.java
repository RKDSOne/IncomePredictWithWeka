package com.mantiso;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ResultServlet extends HttpServlet {
	String appName = "My Application";

	@Override
	public void init() throws ServletException {
		appName = getServletContext().getInitParameter("ProductName");
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String classifier = request.getParameter("class");
		if (classifier != null) {
			if (classifier.equals("naivebayes")) {
				String result[] = null;
				String filename = "/WEB-INF/data/adultIncome.txt";
				ServletContext context = getServletContext();
				InputStream is = context.getResourceAsStream(filename);
				if (is != null) {
					InputStreamReader isr = new InputStreamReader(is);
					BufferedReader reader = new BufferedReader(isr);
					NaiveBayesClassifier nb = new NaiveBayesClassifier();
					try {
						result = nb.CalResult(reader);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						// result=e.toString();
					}

				}

				ArrayList<String> resultDis = new ArrayList<String>();
				for (String s : result) {
					resultDis.add(s);
				}

				request.setAttribute("result", resultDis);
				request.setAttribute("classifierName", "Naive Bayes");
				// response.getWriter().println(result);
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/WEB-INF/result.jsp");

				dispatcher.forward(request, response);
			} else if (classifier.equals("c45")) {
				String result[] = null;
				String filename = "/WEB-INF/data/adultIncome.txt";
				ServletContext context = getServletContext();
				InputStream is = context.getResourceAsStream(filename);
				if (is != null) {
					InputStreamReader isr = new InputStreamReader(is);
					BufferedReader reader = new BufferedReader(isr);
					J48Classifier nb = new J48Classifier();
					try {
						result = nb.CalResult(reader);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						// result=e.toString();
					}

				}

				ArrayList<String> resultDis = new ArrayList<String>();
				for (String s : result) {
					resultDis.add(s);
				}

				request.setAttribute("result", resultDis);
				request.setAttribute("classifierName", "C4.5");
				// response.getWriter().println(result);
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/WEB-INF/result.jsp");

				dispatcher.forward(request, response);
			} else if (classifier.equals("bagging")) {
				String result[] = null;
				String filename = "/WEB-INF/data/adultIncome.txt";
				ServletContext context = getServletContext();
				InputStream is = context.getResourceAsStream(filename);
				if (is != null) {
					InputStreamReader isr = new InputStreamReader(is);
					BufferedReader reader = new BufferedReader(isr);
					BaggingClassifier nb = new BaggingClassifier();
					try {
						result = nb.CalResult(reader);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						// result=e.toString();
					}

				}

				ArrayList<String> resultDis = new ArrayList<String>();
				for (String s : result) {
					resultDis.add(s);
				}

				request.setAttribute("result", resultDis);
				request.setAttribute("classifierName", "Bagging using C4.5");
				// response.getWriter().println(result);
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/WEB-INF/result.jsp");

				dispatcher.forward(request, response);

			}
		} else {
			//throw new ServletException("A name should be entered");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/errorpage.jsp");
			dispatcher.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * String name = req.getParameter("name"); if(name != null && name !=
		 * ""){ resp.getWriter().printf("Hello %s", name); } else {
		 * resp.sendRedirect("work.do"); }
		 */
		/*
		 * PersonalInfo testP = new PersonalInfo(); testP.name =
		 * request.getParameter("name"); testP._strAge =
		 * request.getParameter("slctAge"); testP._strWorkclass =
		 * request.getParameter("slctWorkClass"); testP._strEducation =
		 * request.getParameter("slctEducation"); testP._strMaritialStatus =
		 * request.getParameter("slctMaritalStatus"); testP._strOccupation =
		 * request.getParameter("slctOccupation"); testP._strRelationship =
		 * request.getParameter("slctRelationship"); testP._strRace =
		 * request.getParameter("slctRace"); testP._strSex =
		 * request.getParameter("slctSex"); testP._strCapitalGain =
		 * request.getParameter("slctCapitalGain"); testP._strCapitalLoss =
		 * request.getParameter("slctCapitalLoss"); testP._strHoursPerWeek =
		 * request.getParameter("slctHoursPerWeek"); testP._strNativeCountry =
		 * request.getParameter("slctNativeCountry");
		 */
		// response.getWriter().println( nameStr+ "age is "+ ageStr);
		// response.getWriter().printf("You age is %s", ageStr);

	}
}
