package guvava;


import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class GuvavaLibraryTest1 {

  private boolean flag = true;

  class XYZ {

    private XYZ xyz;

    public XYZ() {
    }

    public XYZ(XYZ xyz) {
      checkNotNull(xyz);
    }
  }

  @Test
  public void testCommonBase() {
    // check not null
//    XYZ xyz = new XYZ(null);

    //
//    int x = 10;
//    checkArgument(x > 10, "x is less than %s", x);
//    checkState(x > 10 , "should be greater than 10");

    // split of string
    System.out.println(Splitter.on(",")
        .trimResults()
        .omitEmptyStrings()
        .split("hey, this,  ,is sunil,"));

  }


  @Test
  public void testFunctionalProgramming() {
    Predicate<String> isSuspect = s -> {
      assert s != null;
      return s.startsWith("t");
    };

    List<String> suspectsList = new ArrayList<>();
    suspectsList.add("tkk");
    suspectsList.add("skk");
    suspectsList.add("vkk");

    System.out.println(suspectsList.stream()
        .filter(isSuspect)
        .collect(Collectors.toUnmodifiableList()));

  }

  @Test
  public void testBool() {
    System.out.println(flag);
  }
}
