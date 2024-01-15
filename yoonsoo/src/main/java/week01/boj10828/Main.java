package week01.boj10828;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();
        LinkedList<Integer> st = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i <= c ; i++) {
            String[] input = sc.nextLine().split(" ");
            String order = input[0];

            if(order.equals("push")) {
                st.add(Integer.parseInt(input[1]));
            }else if(order.equals("pop")) {
                if(st.isEmpty()) {
                    sb.append("-1\n");
                    continue;
                }
                sb.append(st.removeLast()+"\n");
            }else if(order.equals("size")) {
                sb.append(st.size()+"\n");
            }else if(order.equals("empty")) {
                sb.append((st.isEmpty() ? 1 : 0) +"\n");
            }else if(order.equals("top")) {
                if(st.isEmpty()) {
                    sb.append("-1\n");
                    continue;
                }
                sb.append(st.peekLast()+"\n");
            }

        }
        System.out.println(sb.toString());

    }
}


