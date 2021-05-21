package tree;

public class BTree {

  private Node root;

  public void add(int data) {
    root = add(data, root);
  }

  private Node add(int data, Node root) {
    if (root == null) {
      root = newNode(data);
    } else if (data > root.data) {
      root.right = (add(data, root.right));
    } else {
      return root.left = add(data, root.left);
    }
    return root;
  }

  private Node newNode(int data) {
    return new Node(data, null, null);
  }

  public void delete(int data) {

  }

  public void print() {
    print(root);
  }

  private void print(Node root) {
    if (root == null) {
      return;
    } else if (root.left != null) {
      print(root.left);
    } else if (root.right != null) {
      print(root.right);
    }

    System.out.println(root.data);
  }
}
