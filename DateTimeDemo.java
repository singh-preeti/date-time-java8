package com.demo;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.HijrahDate;
import java.time.chrono.ThaiBuddhistDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.Locale;
import java.util.Set;

public class DateTimeDemo {

	public static void main(String[] args) {
	
		LocalDate lDate = LocalDate.now();
		System.out.println(lDate); //prints the date

		LocalTime lTime = LocalTime.now();
		System.out.println(lTime); //prints the current time only. No date, no time-zone

		LocalDateTime lDateTime = LocalDateTime.now();
		System.out.println(lDateTime); //prints date and time but no timezone

		ZonedDateTime zDateTime = ZonedDateTime.now();
		System.out.println(zDateTime); //prints date time and time zone.

		LocalDate date1 = LocalDate.of(2022, Month.FEBRUARY, 01);
		System.out.println(date1); //prints 2002-02-01

		LocalDate date2 = LocalDate.of(2016, Month.FEBRUARY, 29); //throws exception because the day is invalid

		//date and time classes are immutable
		//manipulating date and times
				
		LocalDate date = LocalDate.of(2018, Month.DECEMBER, 25);
		date.plusDays(2);
		System.out.println(date); //prints the date as 2018-12-25, because date time classes are immutable.
		date = date.plusDays(2); //value reassigned
		System.out.println(date); //prints 2018-12-27
				
		date = date.plusWeeks(1); //adds 1 week to 2018-12-27
		System.out.println(date); //prints 2019-01-03
				
		date = date.plusMonths(1);
		System.out.println(date); //prints the same date but for the next month i.e. it will print 2019-02-03
				
		date = date.plusYears(1); //add 1 year to current date
		System.out.println(date); //2020-02-03

		//subtraction
				
		date = LocalDate.of(2016, Month.FEBRUARY, 13);
		date = date.minusDays(7); 
		System.out.println(date); //2016-02-06
				
				
		date = date.plusYears(3);
		System.out.println(date);//2019-02-06
				
		lDateTime = lDateTime.minusSeconds(300); //subtracts 300 seconds from current date time
		System.out.println(lDateTime);
				
		lDateTime = lDateTime.of(lDate, lTime).minusDays(1).minusHours(10).minusMinutes(20); //method chaining
		System.out.println(lDateTime);
				
		LocalDate lDate1 = LocalDate.of(1990, Month.JULY, 12);
		//lDate1 = lDate1.plusMinutes(1); //C.E. plusMinutes method not applicable on date.

		//Period
				
		Period yearAndWeek = Period.ofYears(1).ofWeeks(1); //chaining has no effect here. only the last method takes effect.
		System.out.println(yearAndWeek); //output is P7D, 
				
		yearAndWeek = Period.of(1, 0, 7);
		System.out.println(yearAndWeek); //Output is P1Y7D

		//formatting

		 lDateTime = LocalDateTime.now();
				
		String asBasicISODate = lDateTime.format(DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println("basic iso date "+ asBasicISODate);
				
		String asISOWeekDate = lDateTime.format(DateTimeFormatter.ISO_WEEK_DATE);
		System.out.println("basic iso week date "+ asISOWeekDate);
				
				
		String asISODateTime = lDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
		System.out.println("basic iso date time "+ asISODateTime);
				
		String asCustomPattern = LocalDate.of(2018,1,11).format(DateTimeFormatter.ofPattern("d/M/yyyy"));
		System.out.println("Custom pattern : " + asCustomPattern);
				
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(new Locale("be"));
		String belarusDateTime = lDateTime.format(formatter);
		System.out.println("Belarusian locale : " + belarusDateTime);
				
		HijrahDate hij = HijrahDate.now();
		System.out.println(hij);
				
		ThaiBuddhistDate tbd = ThaiBuddhistDate.now();
		System.out.println(tbd);
				
				
		ZoneId z = ZoneId.of("GMT+3");
		System.out.println(z);
				
		ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.now(), z);
		System.out.println(zdt);

		//Locale Example

		Locale locale = Locale.getDefault();
		System.out.println(locale);
				
		Locale loc = new Locale.Builder().setLanguage("fr").setRegion("FR").build();
		Locale.setDefault(loc);
		System.out.println(Locale.getDefault());

		//adjustInto example
		LocalDate ld1 = LocalDate.of(2015, 11, 25);
		Year y = Year.of(2014);
		System.out.println(ld1.adjustInto(y.atDay(1))); //adjust into method will have the same date as "this" in this case this is ld1

		//a lot more



		Month months = Month.APRIL;
		System.out.println(months);

		//DayOfWeek dayOfWeek = DayOfWeek.of(0);//runtime exception, invalid value
		//System.out.println(dayOfWeek);

		System.out.println(DayOfWeek.of(7)); //prints SUNDAY

		System.out.println(DayOfWeek.of(6)); //prints SATURDAY

		//LocalDate methods
		//public static LocalDate of(int year, int month, int dayOfMonth)
		//public static LocalDate of(int year, Month month, int dayOfMonth)

		 ld1 = LocalDate.of(1985, 2, 10);
		System.out.println(ld1);//prints 1985-02-10

		LocalDate ld2 = LocalDate.of(1985, Month.FEBRUARY, 10);
		System.out.println(ld2);//prints 1985-02-10

		//LocalTime
		//public static LocalTime of(int hour, int minute)
		//public static LocalTime of(int hour, int minute, int second)
		//public static LocalTime of(int hour, int minute, int second, int nanos)

		LocalTime time1 = LocalTime.of(10, 20);
		System.out.println(time1); //prints 10:20

		LocalTime time2 = LocalTime.of(10, 20,25);
		System.out.println(time2); //prints 10:20:25


		LocalTime time3 = LocalTime.of(10, 20, 30, 200);
		System.out.println(time3); //prints 10:20:30.000000200

		//similarly we have methods for LocalDteTime, taking into all possible combinations from LocalDate and LocalTime

		Set<String> zoneIds = ZoneId.getAvailableZoneIds(); //returns a modifiable copy of the set of zone IDs, not null
		System.out.println(zoneIds);

		ZoneId zid = ZoneId.of("Australia/Melbourne"); 
		ZonedDateTime zDt = ZonedDateTime.of(ld1, time2, zid);
		System.out.println(zDt);//prints 1985-02-10T10:20:25+11:00[Australia/Melbourne]

		//common yet confusing date methods

		System.out.println(ld1.getDayOfWeek()); //returns day of week DayOfWeek MONDAY, TUESDAY etc.
		System.out.println(ld1.getDayOfMonth()); //returns day of month int value 1-31
		System.out.println(ld1.getDayOfYear()); //returns day of year int value 1-365, 366 in case of leap year


		System.out.println(ld1.getMonthValue()); //returns int value of month 1-12
		System.out.println(ld1.getMonth()); //returns month enum, JANUARY, FEBRUARY etc


		//date manipulation
		LocalDate localDate = LocalDate.now();
		localDate = localDate.plusDays(100);//100 days added to the current date
		System.out.println(localDate); //prints the new date, current date+100 days

		localDate = localDate.plus(20, ChronoUnit.MONTHS); //adds 20 months to localDate
		System.out.println(localDate);

		System.out.println("local date before day adjustment = "+localDate);
		localDate = localDate.withDayOfMonth(10); //the day will be replaced with 10
		System.out.println("local date after day adjustment = "+localDate);

		System.out.println("local date before year adjustment = "+localDate);
		localDate = localDate.withYear(2109); //the year will be replaced with 2109
		System.out.println("local date after year adjustment = "+localDate);

		//Period examples
		Period p = Period.ZERO;
		System.out.println(p); //returns P0D

		p = Period.of(1, 1, 1); 
		System.out.println(p);//prints P1Y1M1D

		p = Period.ofDays(740);
		System.out.println(p);//prints P740D

		p = Period.of(200, 5000, 200000);
		System.out.println(p);//prints P200Y5000M200000D

		p = Period.ofMonths(3000);
		System.out.println(p);//prints P3000M

		p = Period.ofWeeks(20001);
		System.out.println(p);//prints P140007D. note that weeks are converted to days

		/*
		* This normalizes the years and months units, 
		* leaving the days unit unchanged.The months unit is adjusted to have an absolute value less 
		* than 11,with the years unit being adjusted to compensate.
		* For example, a period of"1 Year and 15 months" will be normalized to "2 years and 3 months". 
		* 
		* */


		System.out.println("normalized = "+Period.of(100, 500, 3000).normalized());


		//duration
		Duration d = Duration.ZERO;
		System.out.println(d);//prints PT0S

		d = Duration.ofMillis(1002);
		System.out.println(d);//prints PT1.002S


		d = Duration.ofSeconds(200);
		System.out.println(d); //prints PT3M20S

		d = Duration.ofDays(400);
		System.out.println(d);//prints PT9600H. note that days are converted to hours

		d = Duration.of(200, ChronoUnit.DAYS);
		System.out.println(d); //prints PT4800H. days converted to hours

		d = Duration.ofSeconds(3600);
		System.out.println(d);//prints PT1H. LOL

		d = Duration.ofHours(24);
		System.out.println("24 = "+d);

		d = Duration.ofMinutes(60);
		System.out.println(d);//prints PT1H


		d = Duration.ofDays(365);
		System.out.println(d);//prints PT8760H


		d = Duration.ofSeconds(60);
		System.out.println(d); //prints PT1M


		//60S=>1M, 60Min => 1H, doesn't go beyond hours

		//Instant
		Instant instant = Instant.now();
		System.out.println("instant = "+instant);

		//instant = instant.plus(20,ChronoUnit.MONTHS); //throws R.T.E java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Months

		//instant = instant.plus(20,ChronoUnit.YEARS); //throws R.T.E java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: years

		instant = instant.plus(100, ChronoUnit.DAYS); //runs fine, 

		instant = instant.plus(100, ChronoUnit.MINUTES);  //runs fine

		instant = instant.plus(100, ChronoUnit.SECONDS);  //runs fine

		instant = instant.plus(100, ChronoUnit.MILLIS); //runs fine

		instant = instant.plus(100, ChronoUnit.HOURS); //runs fine

		System.out.println(instant);


		//ZoneId example
		int thisYear = ZonedDateTime.now().getYear();
		int thisMonth = ZonedDateTime.now().getYear();
		//only the ZonedDateTIme class with the Period class can correctly modify time data when dealing with daylight savings time.
		//when you need to calculate across daylight savings times, then using regular plus or minus methods will not return a correct result.
		//A more correct approach is to use a Period class object.
		ZonedDateTime timeZ = ZonedDateTime.now().plus(Period.ofDays(7));
		System.out.println(timeZ);


		LocalDate lDate2 = LocalDate.now();
		DateTimeFormatter df = DateTimeFormatter.RFC_1123_DATE_TIME;
		//System.out.println(lDate2.format(df));//throws runtime exception because LaocalDate does not have time, and the formatter expects time component as well

		LocalDateTime ldt = LocalDateTime.now();
		//System.out.println(ldt.format(df)); //this too throws run time exception because the date formatter expects offsetSeconds


		 zdt = ZonedDateTime.now();
		System.out.println("RFC = "+zdt.format(df)); //runs fine


		//duration example
		ZonedDateTime depart = ZonedDateTime.of(2016,9,30,22,0,0,0,ZoneId.of("Europe/Paris"));
		ZonedDateTime arrive = ZonedDateTime.of(2016,10,1,1,30,0,0,ZoneId.of("Europe/Sofia"));

		System.out.println(depart);
		System.out.println(arrive);


		Duration flightTime = Duration.between(depart, arrive);
		System.out.println(flightTime); //prints PT2H30M, java automatically takes care of time zones

		Temporal t = LocalDate.now();
		System.out.println(t);

		TemporalUnit tU = ChronoUnit.YEARS;
		System.out.println(tU); //prints Years

		tU = ChronoUnit.ERAS;
		System.out.println(tU);//prints Eras


		//DateTimeFormatter constants

		DateTimeFormatter ISO_DATE_TIME = DateTimeFormatter.ISO_DATE_TIME;
		LocalDateTime isoDateTime = LocalDateTime.now();
		System.out.println(isoDateTime.format(ISO_DATE_TIME)); //run to see the output
		
		DateTimeFormatter ISO_LOCAL_DATE = DateTimeFormatter.ISO_LOCAL_DATE;
		System.out.println(isoDateTime.format(ISO_LOCAL_DATE)); //prints date only using this format yyyy-mm-dd

		//Unit must not have an estimated duration

		//Duration due = Duration.of(5, ChronoUnit.DECADES);

		//LocalDate.of(2000, Month.AUG, 28);				
	}	
}