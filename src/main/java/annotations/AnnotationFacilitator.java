package annotations;

import java.lang.reflect.Field;

/**
 * Facilitates annotation indicated job
 */
public class AnnotationFacilitator {
  public static void init(Object parent) {
    try {
      Field fields[] = parent.getClass().getDeclaredFields();
      processFields(fields, parent);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void processFields(Field[] fields, Object parent)
      throws InstantiationException, IllegalAccessException {

    for (Field f : fields) {
      f.setAccessible(true);
      if (f.isAnnotationPresent(Init.class)) {
        Class<?> objectType = f.getType();
        Object instance = objectType.newInstance();
        f.set(parent, instance);
      }
    }
  }
}
