package tree;

import java.util.List;
import org.junit.Test;

public class TreeTest {

  @Test
  public void addTest() {
    BTree bTree = new BTree();
    bTree.add(10);
    bTree.add(11);
    bTree.add(12);
    bTree.add(9);

    System.out.println("Printing tree elements with print method");
    List<Node> elements = bTree.print();

    System.out.println("Printing tree elements with list");
    elements.forEach(e -> System.out.println(e.data));
  }

}
