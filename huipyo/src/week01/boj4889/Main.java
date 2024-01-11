/**
 *  안정적인 문자열
 *  https://www.acmicpc.net/problem/4889
 *  [ 효율성 ]
 *  - 메모리: 19732KB
 *  - 시간 : 320ms
 */

package week01.boj4889;

import java.util.*;

public class Main {
    private static final char OPEN_BRACKET = '{';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        while (scanner.hasNext()) {
            int answer = 0;
            String readLine = scanner.next();
            Stack<Character> stack = new Stack<>();

            if (readLine.contains("-")) break;
            for (char c : readLine.toCharArray()) {
                if (c == OPEN_BRACKET) {
                    stack.push(c);
                } else {
                    if (!stack.isEmpty() && stack.peek() == OPEN_BRACKET) {
                        stack.pop();
                    } else {
                        answer++;
                        stack.push(OPEN_BRACKET);
                    }
                }
            }
            if (!stack.isEmpty()) answer += stack.size() / 2;
            System.out.println(++count + ". " + answer);
        }
        scanner.close();
    }
}