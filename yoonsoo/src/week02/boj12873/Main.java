package week02.boj12873;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int step = 1;
        Queue<Integer> que = new LinkedList<>();

        for(int i = 1; i <= n ;i++ ) {
            que.add(i);
        }
        while(que.size() > 1) {
            long pow =  (long) Math.pow(step, 3) -1;
            long mod = pow % que.size() < 0 ? pow % que.size() + que.size() : pow % que.size();

            for(int i = 1 ; i <= mod ; i++ ) {
                que.add(que.poll());
            }
            que.poll();
            step++;
        }
        System.out.println(que.poll());

    }
}
