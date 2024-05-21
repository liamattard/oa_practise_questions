import java.util.Scanner;
import java.util.Stack;

public class TextEditor {

    public static class Operation {
        int operation;
        String text;

        public Operation(int operation, String text) {
            this.operation = operation;
            this.text = text;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numberOfOperations = s.nextInt();
        Stack<Operation> alteredTexts = new Stack<>();
        StringBuilder myText = new StringBuilder();

        for (int i = 0; i < numberOfOperations; i++) {
            int nextOp = s.nextInt();

            if (nextOp == 1) {
                String text = s.next();
                alteredTexts.add(new Operation(1, Integer.toString(text.length())));
                myText.append(text);
            } else if (nextOp == 2) {
                int deleteK = s.nextInt();
                alteredTexts.add(new Operation(2, myText.substring(myText.length() - deleteK)));
                myText.setLength(myText.length() - deleteK);
            } else if (nextOp == 3) {
                int printK = s.nextInt() - 1;
                System.out.println(myText.charAt(printK));
            } else if (nextOp == 4) {
                Operation lastOperation = alteredTexts.pop();
                if (lastOperation.operation == 1) {
                    int length = Integer.parseInt(lastOperation.text);
                    myText.setLength(myText.length() - length);
                } else if (lastOperation.operation == 2) {
                    myText.append(lastOperation.text);
                }
            }
        }

        s.close();
    }
}
