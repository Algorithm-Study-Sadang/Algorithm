package week02.boj11866;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        Queue<Integer> que = new LinkedList<>();
        Queue<Integer> rQue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            que.add(i);
        }
        int cnt  = 1;

        while(rQue.size() < n) {
            Integer remove = que.poll();
            if(cnt == k) {
                rQue.add(remove);
                cnt = 1;
            }else {
                que.add(remove);
                cnt++;
            }
        }

        String ans = rQue.toString();
        ans = ans.replace("[", "<");
        ans = ans.replace("]", ">");

        System.out.println(ans);

    }
}
