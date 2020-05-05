package basics;

import javax.naming.ServiceUnavailableException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public final class MessageReProcessorUtil {
  public static void main(String[] args) {
    try {
      throw new NullPointerException();
    }catch (Exception e){
      System.out.println(isRetryableException(e));
    }

  }
  private static final List<Throwable> retryableExceptions =
      Arrays.asList(new IOException(), new ServiceUnavailableException());

  public static boolean isRetryableException(Exception exception) {
    Throwable cause = exception.getCause() == null ? exception : exception.getCause();
    for (Throwable e : retryableExceptions) {
      if (e.getClass().getName().equals(cause.getClass().getName())) {
        return true;
      }
    }
    return false;
  }
}
