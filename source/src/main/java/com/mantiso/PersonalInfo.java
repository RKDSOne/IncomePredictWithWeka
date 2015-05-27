package com.mantiso;

import java.util.Hashtable;

public class PersonalInfo {
	public String name;
	public static Hashtable<String, String> _age;
	public static Hashtable<String, String> _workclass;
	public static Hashtable<String, String> _education;
	public static Hashtable<String, String> _maritalStatus;
	public static Hashtable<String, String> _occupation;
	public static Hashtable<String, String> _relationship;
	public static Hashtable<String, String> _race;
	public static Hashtable<String, String> _sex;
	public static Hashtable<String, String> _capitalGain;
	public static Hashtable<String, String> _capitalLoss;
	public static Hashtable<String, String> _hoursPerWeek;
	public static Hashtable<String, String> _nativeCountry;
	public static Hashtable<String, String> _incomeSalary;
	public String _strAge;
	public String _strWorkclass;
	public String _strEducation;
	public String _strMaritialStatus;
	public String _strOccupation;
	public String _strRelationship;
	public String _strRace;
	public String _strSex;
	public String _strCapitalGain;
	public String _strCapitalLoss;
	public String _strHoursPerWeek;
	public String _strNativeCountry;
	public String _strIincomeSalary;

	@SuppressWarnings("serial")
	public PersonalInfo() {
		name = "Tester";
		_age = new Hashtable<String, String>() {
			{
				put("Less Than 24", "'\'(-inf-24.5]\''");
				put("25 - 30", "'\'(24.5-30.5]\''");
				put("31 - 36", "'\'(30.5-36.5]\''");
				put("37 - 43", "'\'(36.5-43.5]\''");
				put("44 - 52", "'\'(43.5-52.5]\''");
				put("Greater than 52", "'\'(52.5-inf)\''");
			}
		};
		_workclass = new Hashtable<String, String>() {
			{
				put("Private", "Private");
				put("Self-Employment no company", "Self-emp-not-inc");
				put("Self-Employment has company", "Self-emp-inc");
				put("Federal-gov", "Federal-gov");
				put("Local-gov", "Local-gov");
				put("State-gov", "State-gov");
				put("Without-pay", "Without-pay");
				put("Never-worked", "Never-worked");
			}
		};
		_education = new Hashtable<String, String>() {
			{
				put("Bachelors", "14");
				put("Some-college", "13");
				put("11th", "7");
				put("HS-grad", "9");
				put("Professional School", "10");
				put("Associate acadmic", "11");
				put("Assoc-voc", "12");
				put("9th", "5");
				put("7th-8th", "4");
				put("12th", "8");
				put("Masters", "15");
				put("1st-4th", "2");
				put("10th", "6");
				put("Doctorate", "16");
				put("5th-6th", "3");
				put("Preschool", "1");
			}
		};
		_maritalStatus = new Hashtable<String, String>() {
			{
				put("Married-civ-spouse", "Married-civ-spouse");
				put("Married-AF-spouse", "Married-AF-spouse");
				put("Married-spouse-absent", "Married-spouse-absent");
				put("Divorced", "Divorced");
				put("Never-married", "Never-married");
				put("Separated", "Separated");
				put("Widowed", "Widowed");
			}
		};
		_occupation = new Hashtable<String, String>() {
			{
				put("Tech-support", "Tech-support");
				put("Craft-repair", "Craft-repair");
				put("Other-service", "Other-service");
				put("Sales", "Sales");
				put("Exec-managerial", "Exec-managerial");
				put("Prof-specialty", "Prof-specialty");
				put("Handlers-cleaners", "Handlers-cleaners");
				put("Machine-op-inspct", "Machine-op-inspct");
				put("Adm-clerical", "Adm-clerical");
				put("Farming-fishing", "Farming-fishing");
				put("Transport-moving", "Transport-moving");
				put("Priv-house-serv", "Priv-house-serv");
				put("Protective-serv", "Protective-serv");
				put("Armed-Forces", "Armed-Forces");
			}
		};
		_relationship = new Hashtable<String, String>() {
			{
				put("Wife", "Wife");
				put("Own-child", "Own-child");
				put("Husband", "Husband");
				put("Not-in-family", "Not-in-family");
				put("Other-relative", "Other-relative");
				put("Unmarried", "Unmarried");
			}
		};
		_race = new Hashtable<String, String>() {
			{
				put("White", "White");
				put("Asian-Pac-Islander", "Asian-Pac-Islander");
				put("Amer-Indian-Eskimo", "Amer-Indian-Eskimo");
				put("Other", "Other");
				put("Black", "Black");
			}
		};
		_sex = new Hashtable<String, String>() {
			{
				put("Female", "Female");
				put("Male", "Male");
			}
		};
		_capitalGain = new Hashtable<String, String>() {
			{
				put("Less than 57", "'\'(-inf-57]\''");
				put("58-2397", "'\'(57-2397]\''");
				put("2398 - 3205", "'\'(2397-3205]\''");
				put("3206-4243", "'\'(3205-4243.5]\''");
				put("4244-5316", "'\'(4243.5-5316.5]\''");
				put("5317-7364", "'\'(5316.5-7364]\''");
				put("7365-7792", "'\'(7364-7792]\''");
				put("7793-15022", "'\'(7792-15022]\''");
				put("15023-15427", "'\'(15022-15427.5]\''");
				put("Greater than 15427", "'\'(15427.5-inf)\''");
			}
		};
		_capitalLoss = new Hashtable<String, String>() {
			{
				put("Less than 77", "'\'(-inf-77.5]\''");
				put("78-1558", "'\'(77.5-1568.5]\''");
				put("1569-1670", "'\'(1568.5-1670.5]\''");
				put("1671-1834", "'\'(1670.5-1834.5]\'');");
				put("1835-1881", "'\'(1834.5-1881.5]\''");
				put("1882-1893", "'\'(1881.5-1894.5]\''");
				put("1894-1923", "'\'(1894.5-1923]\''");
				put("1924-1978", "'\'(1923-1978.5]\''");
				put("1979-2262", "'\'(1978.5-2262.5]\''");
				put("Greater than 2262", "'\'(2262.5-inf)\''");
			}
		};
		_hoursPerWeek = new Hashtable<String, String>() {
			{
				put("Less than 35 hours", "'\'(-inf-35.5]\''");
				put("36-39", "'\'(35.5-39.5]\''");
				put("40", "'\'(39.5-40.5]\''");
				put("41-50", "'\'(40.5-50.5]\''");
				put("Greater than 50", "'\'(50.5-inf)\''");
			}
		};
		_nativeCountry = new Hashtable<String, String>() {
			{
				put("United-States", "United-States");
				put("Cambodia", "Cambodia");
				put("England", "England");
				put("Puerto-Rico", "Puerto-Rico");
				put("Canada", "Canada");
				put("Germany", "Germany");
				put("Outlying-US(Guam-USVI-etc)", "Outlying-US(Guam-USVI-etc)");
				put("India", "India");
				put("Japan", "Japan");
				put("Greece", "Greece");
				put("South(Korea)", "South");
				put("China", "China");
				put("Cuba", "Cuba");
				put("Iran", "Iran");
				put("Honduras", "Honduras");
				put("Philippines", "Philippines");
				put("Italy", "Italy");
				put("Poland", "Poland");
				put("Vietnam", "Vietnam");
				put("Mexico", "Mexico");
				put("Portugal", "Portugal");
				put("Ireland", "Ireland");
				put("France", "France");
				put("Dominican-Republic", "Dominican-Republic");
				put("Laos", "Laos");
				put("Ecuador", "Ecuador");
				put("Taiwan", "Taiwan");
				put("Haiti", "Haiti");
				put("Columbia", "Columbia");
				put("Hungary", "Hungary");
				put("Guatemala", "Guatemala");
				put("Nicaragua", "Nicaragua");
				put("Scotland", "Scotland");
				put("Thailand", "Thailand");
				put("Yugoslavia", "Yugoslavia");
				put("El-Salvador", "El-Salvador");
				put("Trinadad&Tobago", "Trinadad&Tobago");
				put("Peru", "Peru");
				put("Hong", "Hong");
				put("Holand-Netherlands", "Holand-Netherlands");
			}
		};
		_incomeSalary = new Hashtable<String, String>(){
			{
				put(">50K",">50K");
				put("<=50K","<=50K");
			}
		};
		_strIincomeSalary = "0";
	}
	public String display(){
		return _strAge;
		
	}
}
