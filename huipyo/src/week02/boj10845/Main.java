/**
 *  큐
 *  https://www.acmicpc.net/problem/10845
 *  [ 효율성 ]
 *  - 메모리: 34860KB
 *  - 시간 : 428ms
 */

package week02.boj10845;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Queue<Integer> queue = new ArrayDeque<>(100000) {
            @Override
            public Integer poll() {
                return isEmpty() ? -1 : super.poll();
            }

            @Override
            public Integer peek() {
                return isEmpty() ? -1 : super.peek();
            }
        };
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String s = scanner.next();

            switch (s) {
                case "push":
                    queue.offer(scanner.nextInt());
                    break;
                case "pop":
                    stringBuilder.append(queue.poll()).append("\n");
                    break;
                case "size":
                    stringBuilder.append(queue.size()).append("\n");
                    break;
                case "empty":
                    stringBuilder.append(queue.isEmpty() ? "1" : "0").append("\n");
                    break;
                case "front":
                    stringBuilder.append(queue.peek()).append("\n");
                    break;
                case "back":
                    List<Integer> list = new ArrayList<>(queue);
                    stringBuilder.append(queue.isEmpty() ? "-1" : list.get(list.size() - 1)).append("\n");
                    break;
            }
        }
        System.out.println(stringBuilder.toString().trim());
        scanner.close();
    }
}