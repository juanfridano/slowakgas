package com.slogas.model;

public class Formatter {

	public Formatter(){
		
	}
	
	public String dateformatter (String s){
		
		String formatted = "";

		switch (s) {

		case "01":
			formatted = "Jan";
			break;
		case "02":
			formatted = "Feb";
			break;
		case "03":
			formatted = "Mar";
			break;
		case "04":
			formatted = "Apr";
			break;
		case "05":
			formatted = "May";
			break;
		case "06":
			formatted = "Jun";
			break;
		case "07":
			formatted = "Jul";
			break;
		case "08":
			formatted = "Aug";
			break;
		case "09":
			formatted = "Sep";
			break;
		case "10":
			formatted = "Oct";
			break;
		case "11":
			formatted = "Nov";
			break;
		case "12":
			formatted = "Dec";
			break;

		}

		return formatted;
	}
	
}
