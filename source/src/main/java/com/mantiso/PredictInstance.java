package com.mantiso;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.meta.Bagging;
import weka.classifiers.trees.J48;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PredictInstance {
	NaiveBayes nb;
	J48 j48;
	Bagging bagging;

	public PredictInstance(NaiveBayes nb, J48 j48, Bagging bagging) {
		this.nb = nb;
		this.j48 = j48;
		this.bagging = bagging;
	}

	public ArrayList<String> predict(PersonalInfo person){
		ArrayList<String> outputStr=new ArrayList<String>();
		double result = 0;
		double result2 = 0;
		double[] fDistribution = null;
		double[] fDistribution2 = null;
		try{
			FastVector fvAge = new FastVector();
			for (String	value: PersonalInfo._age.values()) {
				fvAge.addElement(value);
			}
			Attribute age = new Attribute("age", fvAge);
			FastVector fvworkclass = new FastVector();
			for (String	value: PersonalInfo._workclass.values()) {
				fvworkclass.addElement(value);
			}
			Attribute workclass = new Attribute("workclass",fvworkclass);
/*			FastVector fveducationNum = new FastVector();
			for (String	value: PersonalInfo._education.values()) {
				fveducationNum.addElement(value);
			}*/
			//the only numerical attribute
			Attribute educationNum = new Attribute("education-num");
			FastVector fvmaritialStatus = new FastVector();
			for (String	value: PersonalInfo._maritalStatus.values()) {
				fvmaritialStatus.addElement(value);
			}
			Attribute maritialStatus = new Attribute("marital-status",fvmaritialStatus);
			FastVector fvoccupation = new FastVector();
			for (String	value: PersonalInfo._occupation.values()) {
				fvoccupation.addElement(value);
			}
			Attribute occupation = new Attribute("occupation",fvoccupation);
			FastVector fvrelationship = new FastVector();
			for (String	value: PersonalInfo._relationship.values()) {
				fvrelationship.addElement(value);
			}
			Attribute relationship = new Attribute("relationship",fvrelationship);
			FastVector fvrace = new FastVector();
			for (String	value: PersonalInfo._race.values()) {
				fvrace.addElement(value);
			}
			Attribute race = new Attribute("race",fvrace);
			FastVector fvsex = new FastVector();
			for (String	value: PersonalInfo._sex.values()) {
				fvsex.addElement(value);
			}
			Attribute sex = new Attribute("sex",fvsex);
			FastVector fvcapitalGain = new FastVector();
			for (String	value: PersonalInfo._capitalGain.values()) {
				fvcapitalGain.addElement(value);
			}
			Attribute capitalGain = new Attribute("capital-gain",fvcapitalGain);
			FastVector fvcapitalLoss = new FastVector();
			for (String	value: PersonalInfo._capitalLoss.values()) {
				fvcapitalLoss.addElement(value);
			}
			Attribute capitalLoss = new Attribute("capital-loss",fvcapitalLoss);
			FastVector fvhoursPerWeek = new FastVector();
			for (String	value: PersonalInfo._hoursPerWeek.values()) {
				fvhoursPerWeek.addElement(value);
			}
			Attribute hoursPerWeek = new Attribute("hours-per-week",fvhoursPerWeek);
			FastVector fvnativeCountry = new FastVector();
			for (String	value: PersonalInfo._nativeCountry.values()) {
				fvnativeCountry.addElement(value);
			}
			Attribute nativeCountry = new Attribute("native-contry",fvnativeCountry);
			FastVector fvClassVal = new FastVector(2);
			fvClassVal.addElement(">50K");
			fvClassVal.addElement("<=50K");
			Attribute ClassAttribute = new Attribute("incomeSalary", fvClassVal);
			FastVector fvWekaAttributes = new FastVector();
			fvWekaAttributes.addElement(age);
			fvWekaAttributes.addElement(workclass);
			fvWekaAttributes.addElement(educationNum);
			fvWekaAttributes.addElement(maritialStatus);
			fvWekaAttributes.addElement(occupation);
			fvWekaAttributes.addElement(relationship);
			fvWekaAttributes.addElement(race);
			fvWekaAttributes.addElement(sex);
			fvWekaAttributes.addElement(capitalGain);
			fvWekaAttributes.addElement(capitalLoss);
			fvWekaAttributes.addElement(hoursPerWeek);
			fvWekaAttributes.addElement(nativeCountry);
			fvWekaAttributes.addElement(ClassAttribute);
			Instances isTestingSet = new Instances("incomeSalary", fvWekaAttributes, 1);
			isTestingSet.setClassIndex(12);
			Instance sample = new Instance(13);
			sample.setValue((Attribute)fvWekaAttributes.elementAt(0), person._strAge);
			sample.setValue((Attribute)fvWekaAttributes.elementAt(1), person._strWorkclass);
			sample.setValue((Attribute)fvWekaAttributes.elementAt(2),Double.parseDouble(person._strEducation));
			sample.setValue((Attribute)fvWekaAttributes.elementAt(3), person._strMaritialStatus);
			sample.setValue((Attribute)fvWekaAttributes.elementAt(4), person._strOccupation);
			sample.setValue((Attribute)fvWekaAttributes.elementAt(5), person._strRelationship);
			sample.setValue((Attribute)fvWekaAttributes.elementAt(6), person._strRace);
			sample.setValue((Attribute)fvWekaAttributes.elementAt(7), person._strSex);
			sample.setValue((Attribute)fvWekaAttributes.elementAt(8), person._strCapitalGain);
			sample.setValue((Attribute)fvWekaAttributes.elementAt(9), person._strCapitalLoss);
			sample.setValue((Attribute)fvWekaAttributes.elementAt(10), person._strHoursPerWeek);
			sample.setValue((Attribute)fvWekaAttributes.elementAt(11), person._strNativeCountry);
			//isTestingSet.add(sample);
			sample.setDataset(isTestingSet);
			fDistribution = nb.distributionForInstance(sample);
			fDistribution2 = j48.distributionForInstance(sample);
			result = nb.classifyInstance(sample);
			result2 = j48.classifyInstance(sample);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		outputStr.add(Double.toString(result));
		
		outputStr.add(Double.toString(fDistribution[0]));
		outputStr.add(Double.toString(fDistribution[1]));
		outputStr.add(Double.toString(result2));
		outputStr.add(Double.toString(fDistribution2[0]));
		outputStr.add(Double.toString(fDistribution2[1]));
		return outputStr;
		
	}
}
