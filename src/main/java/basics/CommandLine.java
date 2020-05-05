package basics;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

public class CommandLine {
    public static void main(String[] args) {
        List<String> arguments = Arrays.asList("ewr");

          System.out.println(args);
//        LocalDate now = LocalDate.now();
//
//        System.out.println(new Date());
//        System.out.println(Date.from(now.atTime(LocalTime.MIDNIGHT).toInstant(ZoneOffset.UTC)));
    }
}
