package com.aperture.pageobjects;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class test {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		String date="26 Dec - 1 Jan, 2019";
		String splitdate[]=date.split("-");
		String splitdate2[]=splitdate[1].split(",");
		if(splitdate[0].contains("Dec") && splitdate[1].contains("Jan"))
		splitdate2[1]=Integer.toString(Integer.parseInt(splitdate2[1].trim())-1);
		String startdate=splitdate[0].trim()+", "+splitdate2[1].trim();
		String enddate=splitdate[1].trim();
		System.out.println(startdate);
		System.out.println(enddate);

		final DateFormat sdf = new SimpleDateFormat("dd MMM, yyyy", Locale.ENGLISH);
		
        Date edate = sdf.parse(enddate);
        Date sdate = sdf.parse(startdate);
        

	}
	
	public int checkDateWeek(Date sdate,Date edate)
	{
		int status=0;
		Date currentdate = new Date();
		if(sdate.before(currentdate))
			status=-1;//previous week
		else if(sdate.before(currentdate)||edate.after(currentdate)) 
         status=0;//current week
         else if (edate.before(currentdate))
        	 status=1;//next week
         return status;
        }
	

}
