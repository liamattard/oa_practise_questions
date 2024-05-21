public class TestWithReference {
  
    static class Struct {

      int data;
      Struct next;

    }

    public static void main(String[] args) {
      Struct one = new Struct();
      Struct two = new Struct();
      Struct three = new Struct();
      Struct four = new Struct();


      one.data = 1;
      one.next = two;

      two.data = 2;
      two.next = three;

      three.data = 3;
      three.next = four;

      System.out.println("This is the data of one:");
      System.out.println("One.data = " + one.data);
      System.out.println("One.next = " + one.next.data);

      Struct theTest = new Struct();
      Struct theNewPointer = new Struct();
      theNewPointer.data = 700;

      theTest = one.xx;
      theTest.next = theNewPointer;

      System.out.println("--------------------");
      System.out.println("This is the data of new one:");
      System.out.println("One.data = " + one.data);
      System.out.println("One.next = " + one.next.data);

    }

    
}
