package collection;

import java.util.HashMap;
import java.util.Map;

public class CollectionOperations {

  public static void main(String[] args) {
    retainAllSample();
  }

  public static void retainAllSample() {

    Map<String, String> sourceFieldsByFieldDefId = new HashMap<>();
    Map<String, String> destinationFieldsByFieldDefId = new HashMap<>();

    sourceFieldsByFieldDefId.put("1", "abc");
    sourceFieldsByFieldDefId.put("2", "abcd");
    sourceFieldsByFieldDefId.put("3", "abcde");

    destinationFieldsByFieldDefId.put("1", "abc");
    destinationFieldsByFieldDefId.put("3", "abcde");

    sourceFieldsByFieldDefId.keySet().retainAll(destinationFieldsByFieldDefId.keySet());

    sourceFieldsByFieldDefId.forEach((k, v) -> {
      System.out.println("k " + k);
      System.out.println("v " + v);
    });
  }
}


