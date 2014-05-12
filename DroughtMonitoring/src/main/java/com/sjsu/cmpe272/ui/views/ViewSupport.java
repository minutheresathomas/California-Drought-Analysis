package com.sjsu.cmpe272.ui.views;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.joda.time.DateTime;
import org.joda.time.Days;
	
public class ViewSupport {
		     public static void main(String args[]) throws ParseException{
		    	 ViewSupport difference = new ViewSupport();
		     }

		     ViewSupport() throws ParseException {
		        
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date sysdate = new Date();
				String stringdate = dateFormat.format(sysdate);
				Date currentDate = dateFormat.parse(stringdate);
				System.out.println("Current date is : "+currentDate);
//		        String s = "2008-08-01";
		        String e = "2014-04-03";
		        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
//		        Date start = f.parse(s);
//		        System.out.println("start date= "+start); 
		        Date end = f.parse(e);
		        System.out.println("end date= "+end); 
		        DateTime startDateTime = new DateTime(currentDate.getTime());
				DateTime endDateTime = new DateTime(end.getTime());
				
//				int days = daysBetween(start, end);
				Days d = Days.daysBetween(endDateTime, startDateTime);
				int days = d.getDays();
//		        cal1.set(2008, 8, 1); 
//		        cal2.set(2008, 9, 31);
		        System.out.println("Days= "+days);
		    }
		     public int daysBetween(Date d1, Date d2){
		        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
		     }
		 
	

}
