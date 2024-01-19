/**
 *  기념품
 *  https://www.acmicpc.net/problem/12873
 *  [ 효율성 ]
 *  - 메모리: 17972KB
 *  - 시간 : 576ms
 */

package week02.boj12873;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Queue<Integer> queue = new ArrayDeque<>() {
            {
                for (int i = 0; i < n; i++) offer(i + 1);
            }
        };
        int level = 1;

        while (queue.size() > 1) {
            // 가지치기해서 비효율적인 회전은 줄인다
            for (int i = 0; i < (Math.pow(level, 3) - 1) % queue.size(); i++) {
                queue.offer(queue.poll());
            }
            level++;
            queue.poll();
        }
        System.out.println(queue.peek());
        scanner.close();
    }
}