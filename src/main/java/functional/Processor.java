package functional;

import java.util.function.Predicate;

public class Processor {

  public void process(Predicate<ProcessStatus> predicate) {
    if (predicate.test(ProcessStatus.START)) {
      System.out.println("processing something...");
    }
  }
}
