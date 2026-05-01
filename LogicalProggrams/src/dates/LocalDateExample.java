package dates;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDateExample {
	public static void main(String[] args) {
		LocalDate localDate=LocalDate.now();
		System.out.println("Local Date :"+localDate);
		
		LocalDate localDate1=LocalDate.of(2020, 12, 18);
		System.out.println("Local Date1 :"+localDate1);
		
		LocalDate localDate2=LocalDate.ofYearDay(2020, 365);
		System.out.println("Local Date2 :"+localDate2);
		
		System.out.println("get month "+localDate.getMonth());
		System.out.println("get month value "+localDate.getMonthValue());
		System.out.println("get day of week "+localDate.getDayOfWeek());
		System.out.println("get day of year "+localDate.getDayOfYear());
		System.out.println("day of month "+localDate.get(ChronoField.DAY_OF_MONTH));
		
        /**
         * Modifying Values in Local Date
         */
        System.out.println("Plus Weeks  : " + localDate.plusWeeks(1));
        System.out.println("Plus Years : " + localDate.plusYears(1));
        System.out.println("Plus Days " + localDate.plusDays(1));
        System.out.println("Plus Months : " + localDate.plusMonths(1));
        System.out.println("Minus Months : "+localDate.minusMonths(1));
        System.out.println("Chrono Unit : " + localDate.minus(2, ChronoUnit.YEARS));
        System.out.println("With Year : " + localDate.withYear(2019));
        System.out.println("With Year Chrono Field : " + localDate.with(ChronoField.YEAR , 2019));
        System.out.println("With Temporal Adjusters : " + localDate.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println("With Temporal Adjusters : " + localDate.with(TemporalAdjusters.dayOfWeekInMonth(1, DayOfWeek.FRIDAY))); // maps to the first friday of the week

        /**
         * Unsupported Scenarios
         */
        //  System.out.println("Chrono Unit : " + localDate.minus(2, ChronoUnit.SECONDS));
        System.out.println("is Supported : " + localDate.isSupported(ChronoUnit.DAYS));

        /**
         * Additional Support Methods
         */
        System.out.println("Not a Leap Year : " + localDate.isLeapYear());
        LocalDate  localDate20 = LocalDate.of(2020,01,31);
        System.out.println("Leap Year : " +  localDate20.isLeapYear());

        System.out.println("isBefore : " + localDate1.isBefore(localDate));
        System.out.println("isAfter : " + localDate1.isAfter(localDate));
        System.out.println("isEqual : " + localDate1.isEqual(localDate));

	}
}
