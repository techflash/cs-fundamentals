package tree;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Node {
  public int data;
  public Node right;
  public Node left;
}
