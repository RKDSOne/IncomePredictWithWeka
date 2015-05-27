package com.mantiso;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import weka.core.Instance;
import weka.core.Instances;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.SerializationHelper;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.J48;
import weka.classifiers.meta.Bagging;

public class IndexServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		// PersonalInfo user = new PersonalInfo();

		// getServletContext().setAttribute("user", user);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PersonalInfo p1 = new PersonalInfo();
		p1.name = "Kevin";
		// user.setEmail("kevinj@mantiso.com");
		request.setAttribute("age", p1._age);
		request.setAttribute("workclass", p1._workclass);
		request.setAttribute("education", p1._education);
		request.setAttribute("maritalStatus", p1._maritalStatus);
		request.setAttribute("occupation", p1._occupation);
		request.setAttribute("relationship", p1._relationship);
		request.setAttribute("race", p1._race);
		request.setAttribute("sex", p1._sex);
		request.setAttribute("capitalGain", p1._capitalGain);
		request.setAttribute("capitalLoss", p1._capitalLoss);
		request.setAttribute("hoursPerWeek", p1._hoursPerWeek);
		request.setAttribute("nativeCountry", p1._nativeCountry);

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/WEB-INF/index.jsp");

		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * String nameStr = request.getParameter("name"); String ageStr =
		 * request.getParameter("testAge"); if(nameStr!=null){
		 * response.getWriter().println( nameStr+ "age is "+ ageStr);
		 * //response.getWriter().printf("You age is %s", ageStr);
		 * 
		 * }else{ response.getWriter().printf("Don't get your information"); }
		 */
		ServletContext context = getServletContext();
		NaiveBayes nb;
		J48 j48;
		Bagging bagging=null;
		ArrayList<String> resultDis = new ArrayList<String>();
		try {
			nb = (NaiveBayes) SerializationHelper
					.read(context
							.getResourceAsStream("/WEB-INF/data/NaiveBayesModel.model"));

			j48 = (J48) SerializationHelper.read(context
					.getResourceAsStream("/WEB-INF/data/J48Model.model"));
	//		bagging = (Bagging) SerializationHelper.read(context
		//			.getResourceAsStream("/WEB-INF/data/BaggingModel.model"));
		
		// String name = req.getParameter("name"); if(name != null && name !=
		// ""){ resp.getWriter().printf("Hello %s", name); } else {
		// resp.sendRedirect("work.do"); }

		PersonalInfo testP = new PersonalInfo();
		testP.name = request.getParameter("name");
		testP._strAge = request.getParameter("slctAge");
		testP._strWorkclass = request.getParameter("slctWorkClass");
		//testP._strEducation = request.getParameter("slctEducation");
		testP._strEducation = request.getParameter("slctEducation");
		testP._strMaritialStatus = request.getParameter("slctMaritalStatus");
		testP._strOccupation = request.getParameter("slctOccupation");
		testP._strRelationship = request.getParameter("slctRelationship");
		testP._strRace = request.getParameter("slctRace");
		testP._strSex = request.getParameter("slctSex");
		testP._strCapitalGain = request.getParameter("slctCapitalGain");
		testP._strCapitalLoss = request.getParameter("slctCapitalLoss");
		testP._strHoursPerWeek = request.getParameter("slctHoursPerWeek");
		testP._strNativeCountry = request.getParameter("slctNativeCountry");

		// response.getWriter().println( nameStr+ "age is "+ ageStr);
		// response.getWriter().printf("You age is %s", ageStr);
		
		PredictInstance prediIns = new PredictInstance(nb, j48, bagging);
		resultDis = prediIns.predict(testP);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * String result[] = null; String filename = "/WEB-INF/adultIncome.txt";
		 * ServletContext context = getServletContext(); InputStream is =
		 * context.getResourceAsStream(filename); if (is != null) {
		 * InputStreamReader isr = new InputStreamReader(is); BufferedReader
		 * reader = new BufferedReader(isr); // PrintWriter writer =
		 * response.getWriter(); String text = ""; NaiveBayesClassifier nb = new
		 * NaiveBayesClassifier(); try { result = nb.CalResult(reader); } catch
		 * (Exception e) { // TODO Auto-generated catch block //
		 * result=e.toString(); }
		 * 
		 * }
		 */

		/*
		 * for (String s : result) { resultDis.add(s); }
		 */
		String[] resultDis2 = new String[6];
		if(resultDis.get(0).equals("0.0")){
			resultDis2[0]="NaiveBayes predict: you salary is >50K";
		}else{
			resultDis2[0]="NaiveBayes predict: you salary is <=50K";
		}
		resultDis2[1]="Probability of >50K: "+resultDis.get(1);
		resultDis2[2]="Probability of <=50K: " +resultDis.get(2);
		if(resultDis.get(3).equals("0.0")){
			resultDis2[3]="C4.5 predict: you salary is >50K";
		}else{
			resultDis2[3]="C4.5 predict: you salary is <=50K";
		}
		resultDis2[4]="Probability of >50K: "+resultDis.get(4);
		resultDis2[5]="Probability of <=50K: " +resultDis.get(5);
		
		ArrayList<String> outResult = new ArrayList<String>();
		for (String s : resultDis2) {
			outResult.add(s);
		}
		request.setAttribute("result", outResult);

		request.setAttribute("classifierName", "Naive Bayes and C4.5");
		// response.getWriter().println(result);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/WEB-INF/result.jsp");

		dispatcher.forward(request, response);
	}
}
