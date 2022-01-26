package tree;

import java.util.ArrayList;
import java.util.List;

public class BTree {

  private Node root;

  public void add(int data) {
    root = add(data, root);
  }

  private Node add(int data, Node root) {
    if (root == null) {
      root = newNode(data);
    } else if (data > root.data) {
      root.right = add(data, root.right);
    } else {
      root.left = add(data, root.left);
    }
    return root;
  }

  private Node newNode(int data) {
    return new Node(data, null, null);
  }

  public void delete(int data) {

  }

  public List<Node> print() {
    List<Node> elements = new ArrayList<>();
    print(root, elements);
    return elements;
  }

  private void print(Node root, List<Node> elements) {
    if (root == null) {
      return;
    }
    if (root.left != null) {
      print(root.left, elements);
    }

    if (root.right != null) {
      print(root.right, elements);
    }
    elements.add(root);
    System.out.println(root.data);
  }
}
