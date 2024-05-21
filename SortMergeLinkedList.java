public class SortMergeLinkedList {

  static class SinglyLinkedListNode {

    int data;
    SinglyLinkedListNode next;


    SinglyLinkedListNode(int data) {
      this.data = data;
    };
  }

  static void sort(SinglyLinkedListNode head1, SinglyLinkedListNode head2, SinglyLinkedListNode sorted) {

    if (head1 == null) {
      sorted.data = head2.data;
      sorted.next = head2.next;
    } else if(head2 == null) {
      sorted.data = head1.data;
      sorted.next = head1.next;
    } else if (head1.data > head2.data) {
      sorted.data = head2.data;
      sorted.next = new SinglyLinkedListNode(0);
      sort(head1, head2.next, sorted.next);
    } else {
      sorted.data = head1.data;
      sorted.next = new SinglyLinkedListNode(0);
      sort(head1.next, head2, sorted.next);
    }

  }

  static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedListNode node = new SinglyLinkedListNode(0);
        sort(head1, head2, node);
        System.err.println("Hello");
        
        return node;
    }

  public static void main(String[] args) {
    SinglyLinkedListNode one1 = new SinglyLinkedListNode(1);
    SinglyLinkedListNode one2 = new SinglyLinkedListNode(3);
    one1.next = one2;
    // SinglyLinkedListNode one3 = new SinglyLinkedListNode(7);
    // one2.next = one3;

    SinglyLinkedListNode two1 = new SinglyLinkedListNode(1);
    SinglyLinkedListNode two2 = new SinglyLinkedListNode(2);
    two1.next = two2;

    mergeLists(one1, two1);

  }

}
