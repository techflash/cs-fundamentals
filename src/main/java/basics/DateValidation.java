package basics;

import java.time.OffsetDateTime;

public class DateValidation {
    enum Button {
        ON("ON"),
        OFF("OFF");

        private String value;

        Button(String value) {
            this.value = value;
        }

        public void doSomething() {
            System.out.println("doing nothing!");
        }
    }

    public static void main(String[] args) {
//        final Date startDate = Date.from(Instant.parse("3001-01-28T00:00:00.000Z"));
//        final OffsetDateTime myDate = OffsetDateTime.parse("2020-01-28T00:00:00.000Z");
//        System.out.println(myDate.isAfter(MIN_DATE) && myDate.isBefore(MAX_DATE));
            System.out.println();
        Button.ON.doSomething();


    }

    private static final OffsetDateTime MAX_DATE = OffsetDateTime.parse("3000-12-31T00:00:00.000Z");
    private static final OffsetDateTime MIN_DATE = OffsetDateTime.parse("1800-12-31T00:00:00.000Z");

    public static boolean isDateInValidRange(OffsetDateTime date){
        return date.isBefore(MAX_DATE) && date.isAfter(MIN_DATE);
    }
}
