package ll;

public class Node<T> {
  public T data;
  public Node<T> next;
  public Node<T> prev;

  public Node() {
  }

  public Node(T data) {
    this.data = data;
    this.next = null;
    this.prev = null;
  }

  public Node(T data, Node next) {
    this.data = data;
    this.next = next;
  }

  public Node(T data, Node next, Node prev) {
    this.data = data;
    this.next = next;
    this.prev = prev;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public Node<T> getNext() {
    return next;
  }

  public Node<T> setNext(Node next) {
    this.next = next;
    return this;
  }

  public Node<T> getPrev() {
    return prev;
  }

  public Node<T> setPrev(Node prev) {
    this.prev = prev;
    return this;
  }

  @Override
  public String toString() {
    return "Node{" +
        "data=" + data +
        ", next=" + next +
        ", prev=" + prev +
        '}';
  }
}
