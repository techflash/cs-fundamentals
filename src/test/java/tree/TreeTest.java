package tree;

import org.junit.Test;

public class TreeTest {

  @Test
  public void addTest() {
    BTree bTree = new BTree();
    bTree.add(10);
    bTree.add(11);
    bTree.add(12);
    bTree.add(9);

    bTree.print();
  }

}
