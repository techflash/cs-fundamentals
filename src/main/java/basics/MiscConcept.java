package basics;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

enum Button {
    ON(30), OFF(10);
    private int value;

    Button(int value) {
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
public class MiscConcept {

  public static void main(String[] args) throws ParseException {
    Map<String, String> map = new HashMap<>();
    map.put("key", "vvalue");
    map.put("xx", "vvalue");
    map.put("rr", "vvalue");
    map.put("ON", "vvalue");
    map.put("OF", "vvalue");

//    System.out.println(map.get(Button.valueOf("ere")));
    System.out.println(Button.valueOf("ON").getValue());

  }

}
