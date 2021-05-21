package rough;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.Test;

public class FileTests {

  @Test
  public void TestArrayStream() {
    byte x[] = {'a', 'b', 'c'};
    ByteArrayInputStream stream = new ByteArrayInputStream(x);

    int l;
    while ((l = stream.read()) > -1) {
      System.out.println((char) l);
    }
  }

  @Test
  public void TestStreamChaining() throws IOException {
    BufferedReader br =
        Files.newBufferedReader(Path.of("src/test/java/rough/xyz.txt"));

//        new BufferedInputStream(
//        new FileInputStream(""));

    String line;
    while ((line = br.readLine()) != null) {
      System.out.print(line);
    }
    System.out.println();
  }
}
