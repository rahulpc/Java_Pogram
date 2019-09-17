package com.luv2code.springdemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

class DateRange {

	private Date startDate;
	private Date endDate;

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public DateRange(Date startDate, Date endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}

}

public class DateMerger {

	public List<DateRange> mergeDates(List<DateRange> dateRanges) {

		List<DateRange> returnList = new ArrayList<DateRange>();
		for (int i = 0; i < dateRanges.size(); i++) {
			DateRange temp = dateRanges.get(i);
			for (int k = i + 1; k < dateRanges.size(); k++) {
				DateRange temp1 = dateRanges.get(k);
				if (temp.getEndDate().compareTo(temp1.getStartDate()) >= 0) {
					System.out.println("Success: Condition Satisfied Hence Merging the Dates");
					temp.setEndDate(temp1.getEndDate());
					returnList.add(new DateRange(temp.getStartDate(), temp.getEndDate()));
				} else {
					System.out.println("Failed : Condition Failed Hence not Merging the Dates");
				}

			}
			System.out.println("****************************************");

		}

		return returnList;
	}

	public static void main(String[] args) throws ParseException {

		try {
			DateMerger d = new DateMerger();

			List<DateRange> l = new ArrayList<DateRange>();
			SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");

			// Case1

			l.add(new DateRange(sdf.parse("01 Jan 2014"), sdf.parse("30 Jan 2014")));
			l.add(new DateRange(sdf.parse("15 Jan 2014"), sdf.parse("15 Feb 2014")));
			l.add(new DateRange(sdf.parse("10 Mar 2014"), sdf.parse("15 Apr 2014")));
			l.add(new DateRange(sdf.parse("10 Apr 2014"), sdf.parse("15 May 2014")));

			// Case2
			/*
			 * l.add(new DateRange(sdf.parse("01 Jan 2014"), sdf.parse("15 Jan 2014")));
			 * l.add(new DateRange(sdf.parse("16 Jan 2014"), sdf.parse("30 Jan 2014")));
			 */

			// Case3
			/*
			 * l.add(new DateRange(sdf.parse("01 Jan 2014"), sdf.parse("15 Jan 2014")));
			 * l.add(new DateRange(sdf.parse("15 Jan 2014"), sdf.parse("30 Jan 2014")));
			 */

			List<DateRange> resultList = new ArrayList<DateRange>();
			resultList = d.mergeDates(l);

			System.out.println("*****Final Result*****");

			for (DateRange temp : resultList) {
				System.out.println("Start Date : " + temp.getStartDate() + "\tEnd Date : " + temp.getEndDate());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
