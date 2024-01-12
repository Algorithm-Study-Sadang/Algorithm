package week01.boj4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    // 인풋 종료 시퀀스
    private static final String END_INPUT = ".";

    // 오답용 표시용 스택 아이템
    private static final char NO_ITEM = 'x';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String line;
        while (!END_INPUT.equals(line = br.readLine())) {
            char[] charArray = line.toCharArray();

            try {
                loop:
                for (char c : charArray) {
                    switch (c) {
                        case '(', '[' -> stack.push(c);
                        case ')' -> {
                            if (stack.pop() != '(') {
                                stack.push(NO_ITEM);
                                break loop;
                            }
                        }
                        case ']' -> {
                            if (stack.pop() != '[') {
                                stack.push(NO_ITEM);
                                break loop;
                            }
                        }
                    }
                }

                if (stack.isEmpty()) {
                    sb.append("yes\n");
                } else {
                    sb.append("no\n");
                }
            } catch (Exception e) {
                sb.append("no\n");
            }

            stack.clear();
        }

        System.out.println(sb);
    }
}
