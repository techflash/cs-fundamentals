package ll;

public class LLTest {

  public static void main(String[] args) {
    // Create Node entry
    LinkList<Integer> linkList = new LinkList<>();
    linkList.insert(1);
    linkList.insert(9);
    linkList.insert(9);
    linkList.insert(9);


    System.out.println("Inserted elements");
    linkList.print();
//
//    linkList.delete(1);
//    System.out.println("\nafter delete element from first position");
//    linkList.print();

//    linkList.delete(2);
//    System.out.println("\nafter delete element from second position");
//    linkList.print();
//    linkList.delete(4);
//    System.out.println("\nafter delete element from fourth position");
//    linkList.print();
//
//    linkList.insert(4, 1);
//    System.out.println("\nafter insert element at fourth position");
//    linkList.print();

//    linkList.recursiveReverse();
//    System.out.println("\nafter reverse");
//    linkList.print();

//    System.out.println("after removing duplicate");
//    linkList.removeDuplicateInSortedList();
//    linkList.print();

    System.out.println("before adding 1");
    linkList.print();
    System.out.println("after adding 1");
    linkList.addNumber(11);
    linkList.print();
  }
}
