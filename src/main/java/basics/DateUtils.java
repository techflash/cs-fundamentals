package basics;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.Date;

public class DateUtils {

  public static void main(String[] args) throws InterruptedException {
    Date date1 = new Date();
    Thread.sleep(1000);


    System.out.println(isItTimeToRetry(date1));
  }

  private static boolean isItTimeToRetry(Date lastRetry) {
    return add(lastRetry, "2s").compareTo(new Date()) >= 0;
  }


  private static TemporalAmount parse(String feString) {
    if (feString.matches("(\\d)+d")) {
      // for d as day we have to use D
      feString = feString.toUpperCase();
    }
    if (Character.isUpperCase(feString.charAt(feString.length() - 1))) {
      return Period.parse("P" + feString);
    } else {
      return Duration.parse("PT" + feString);
    }
  }

  public static Date add(Date date, String token) {
    TemporalAmount amount = parse(token);
    LocalDateTime ldt = convertToLocalDateTimeViaInstant(date);
    ldt = ldt.plus(amount);
    return convertToDateViaInstant(ldt);
  }
  public static Date remove(Date date, String token) {
    TemporalAmount amount = parse(token);
    LocalDateTime ldt = convertToLocalDateTimeViaInstant(date);
    ldt = ldt.minus(amount);
    return convertToDateViaInstant(ldt);
  }

  public static OffsetDateTime toOffsetDateTime(Date date) {
    if (date == null) {
      return null;
    }
    return OffsetDateTime.ofInstant(date.toInstant(), ZoneOffset.UTC)
        .truncatedTo(ChronoUnit.SECONDS);
  }

  public static Date toDate(OffsetDateTime dateTime) {
    long epochMilli = dateTime.toInstant().toEpochMilli();
    Date date = new Date(epochMilli);
    return date;
  }

  protected static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
    return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
  }

  protected static Date convertToDateViaInstant(LocalDateTime dateToConvert) {
    return Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
  }
}
