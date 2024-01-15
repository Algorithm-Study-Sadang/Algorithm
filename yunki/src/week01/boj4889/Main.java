package week01.boj4889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int iter = 0;
        String line;
        while ((line = br.readLine()) != null) {
            // 종료 시퀀스
            if (line.charAt(0) == '-') {
                break;
            }

            int count = 0;
            char[] chars = line.toCharArray();

            for (char c : chars) {
                if (c == '{') {
                    stack.push(c);
                } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            
            while (!stack.isEmpty()) {
                // 문제에서 문자열 길이가 짝수개라 했기 때문에 위의 조건식으로 짝 하나가 들어와 버리면 다른놈도 짝이 없기 떄문에 같이 들어온다. 그래서 항상 두 개씩 꺼낼 수 있음
                char e1 = stack.pop();
                char e2 = stack.pop();
                if (e1 == e2) { // 모양이 같으면 하나만 바꿔주면 되고.
                    count += 1;
                } else { // 모양이 다르면 결국 둘 다 바꿔줘야함
                    count += 2;
                }
            }

            sb.append(++iter)
                    .append(". ")
                    .append(count)
                    .append('\n');

            stack.clear();
        }

        System.out.println(sb);
    }
}
