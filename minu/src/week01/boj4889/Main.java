package week01.boj4889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> deque;

        int idx = 1;
         while (true) {
             deque = new ArrayDeque<>();
             String input = br.readLine();

             if (input.charAt(0) == '-')
                 break;

             int result = 0;
             for(int i = 0; i < input.length(); i++) {
                 char c = input.charAt(i);
                 if (c == '{') {
                     deque.add(c);
                 } else {
                     if (deque.isEmpty()) {
                         deque.add('{');
                         result++;
                     } else {
                         deque.pop();
                     }
                 }
             }
             int leftStack = deque.size();
             result += (leftStack / 2);

             System.out.println(idx + ". " + result);
             idx++;

         }
    }
}