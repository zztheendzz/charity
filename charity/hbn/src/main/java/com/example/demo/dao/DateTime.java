package com.example.demo.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTime {
	
	public String getDate() {
        Calendar cal = Calendar.getInstance();
        Date _date = cal.getTime();
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm dd/MM/yyyy ");
        String date = sdf2.format(_date);
        return date;

	}

}
