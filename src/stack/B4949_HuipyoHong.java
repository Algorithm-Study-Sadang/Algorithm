package stack;

import java.util.*;

/**
 *  [ 효율성 ]
 *  - 메모리: 33576KB
 *  - 시간 : 580ms
 */

public class B4949_HuipyoHong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            Stack<Character> stack = new Stack<>();
            boolean isTrue = true;

            if (nextLine.equals(".")) break;
            for (int i = 0; i < nextLine.length(); i++) {
                switch (nextLine.charAt(i)) {
                    case '(':
                    case '[':
                        stack.push(nextLine.charAt(i));
                        break;
                    case ')':
                        if (!stack.empty() && stack.peek() == '(') stack.pop();
                        else isTrue = false;
                        break;
                    case ']':
                        if (!stack.empty() && stack.peek() == '[') stack.pop();
                        else isTrue = false;
                        break;
                }
            }
            System.out.println(stack.isEmpty() && isTrue ? "yes" : "no");
        }
        scanner.close();
    }
}
