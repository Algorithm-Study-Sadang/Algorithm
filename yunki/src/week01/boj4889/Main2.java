package week01.boj4889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2 {
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
                } else if (c == '}') {
                    // 스택이 비어있는데 } 를 만나면 모양을 바꿔서 다시 스택에 넣는다.
                    // 이로인해 스택엔 항상 { 만 들어가 있다.
                    if (stack.isEmpty()) {
                        stack.push('{');
                        count++;
                    } else { // 짝을 만났으니 스택에서 { 하나를 뺀다.
                        stack.pop();
                    }
                }
            }

            // 남아있는 애들은 { 뿐인데 모양이 같으니까 하나만 바꿔주면 된다.
            count += stack.size() / 2;

            sb.append(++iter)
                    .append(". ")
                    .append(count)
                    .append('\n');

            stack.clear();
        }

        System.out.println(sb);
    }
}
