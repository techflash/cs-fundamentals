package annotations;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Annotation {

  @Init
  private String name;

  @Before
  public void before(){
    AnnotationFacilitator.init(this);
  }

  @Test
  public void testNotNull(){
    Assert.assertNotNull(name);
  }
}
