package file;

import java.io.IOException;
import java.util.function.Supplier;

public class FileStreamDemo {
  public static void main(String[] args) throws IOException {
    runAfunc(() -> "shit");
  }

  private static void runAfunc(Supplier<String> doShit) {
    System.out.println(doShit.get());
  }

}

