package ll;

public class LinkList<T> {

  private Node<T> head;
  private Node<T> tail;

  public void insert(T data) {
    if (head == null) {
      head = new Node<>(data);
      tail = head;
      return;
    }
    tail.next = new Node(data);
    tail = tail.next;
  }

  public void delete() {
    if (head == null) {
      return;
    }
    head = head.next;
  }

  public void delete(int position) {
    if (head == null) {
      return;
    }

    if (position == 1) {
      head = head.next;
      return;
    }

    Node<T> prev = null, targetNode = head;
    int i = 1;
    while (targetNode != null && position > i) {
      prev = targetNode;
      targetNode = targetNode.next;
      i++;
    }
    if (targetNode == null) {
      throw new RuntimeException("wrong position");
    }
    prev.next = targetNode.next;
  }

  public void insert(T data, int position) {
    if (head == null && position != 1) {
      throw new RuntimeException("invalid");
    }

    if (head == null && position == 1) {
      head = new Node<>(data);
      return;
    }

    if (head != null && position == 1) {
      head = new Node<>(data).setNext(head);
      return;
    }

    Node<T> prev = null, targetNode = head;
    int i = 1;
    while (i < position && targetNode != null) {
      prev = targetNode;
      targetNode = targetNode.next;
      i++;
    }

    if (targetNode == null && i != position) {
      throw new RuntimeException("Invalid position");
    }

    Node<T> newNode = new Node<>(data);
    newNode.next = targetNode;
    prev.next = newNode;
  }

  public void reverse() {
    Node<T> current = head, prev = null, next;
    if (head == null || head.next == null) {
      return;
    }

    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    head = prev;
  }

  public void recursiveReverse() {
    recursiveReverse(head);
  }

  private void recursiveReverse(Node<T> node) {
    if (node.next == null) {
      head = node;
      return;
    }
    recursiveReverse(node.next);
    node.next.next = node;
    node.next = null;
  }

  public void print() {
    Node<T> node = head;
    while (node != null) {
      System.out.print(node.data.toString());
      if (node.next != null) {
        System.out.print("->");
      }
      node = node.next;
    }
    System.out.println();
  }

  /**
   * 1 -> 2 -> 3 -> 4 -> 5
   * <p>
   * Answer 3.
   */
  public void printMid() {
    Node<T> node = head, mid = head;
    while (node != null && node.next != null) {
      mid = mid.next;
      node = node.next.next;
    }

    System.out.println("mid node" + mid.toString());
  }

  /**
   * 1 -> 2 -> 3 -> 3 -> 4
   * <p>
   * Answer 1 -> 2 -> 3 -> 4 -> 5
   */
  public void removeDuplicateInSortedList() {
    if (!(head.data instanceof Integer)) {
      throw new RuntimeException("Data type not supported");
    }
    Node<T> node = head, prev = head;
    while (node != null && node.next != null) {
      prev = node;
      node = node.next;

      while (node != null && ((Integer) prev.data - (Integer) node.data) == 0) {
        node = node.next;
        prev.next = node;
      }
    }
  }

  /**
   * Is buggy
   *
   * @param num
   */
  public void addNumber(Integer num) {
    if (head == null) {
      return;
    }
    reverse();
    Node revList = head;
    if (((Integer) revList.data + num) > 9) {
      Integer carry = 0;
      if (((Integer) revList.data + num) % 10 == 0) {
        revList.setData((Integer) 0);
        carry = 1;
      } else {
        carry = 1;
        revList.setData(((Integer) revList.data + num) % 10);
      }

      revList = revList.next;
      while (revList != null && ((Integer) revList.data + carry) > 9) {
        revList.setData(((Integer) revList.data + carry) % 10);
        carry = 1;
        revList = revList.next;
      }
      if (revList != null && ((Integer) revList.data + carry) < 9) {
        revList.setData((Integer) revList.data + carry);
      }
    } else {
      revList.setData((Integer) revList.data + num);
    }

    recursiveReverse();
  }
}
