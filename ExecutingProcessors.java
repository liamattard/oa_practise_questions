import java.util.Map;

public class ExecutingProcessors {

  public static class Node {
    int value;
    Node next;
    
    public Node (int value) {
      this.value = value;
    }
  }


  public static Node locateLongestList(Node currNode){

    Node result = currNode;
    Node currentSubNode = currNode;
    int maxLength = Integer.MIN_VALUE;
    int length = 1;

    while (currNode.next != null) {
      if(currNode.value < currNode.next.value){
        if (length > maxLength) {
          result = currentSubNode;
          maxLength = length;
          currentSubNode = currNode.next;
          length = 1;

          Node nextNode = currNode.next;
          currNode.next = null;
          currNode = nextNode;
        } else {
          currentSubNode = currNode.next;
          length = 1;
        }
      } else {
        length++;
        currNode = currNode.next;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Node one = new Node(2);
    Node two = new Node(3);
    Node three = new Node(2);
    Node four = new Node(1);
    Node five = new Node(4);

    one.next = two;
    two.next = three;
    three.next = four;
    four.next = five;
    locateLongestList(one);
  }
  
}
