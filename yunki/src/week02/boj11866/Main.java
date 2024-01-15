package week02.boj11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringJoiner;

/**
 * MEM      20MB
 * TIME     184ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        System.out.println(new Josephus(n, k));
    }
}

class Josephus {
    private final int[] series;

    Josephus(int n, int k) {
        this.series = new int[n];
        generate(n, k);
    }

    private void generate(int n, int k) {
        Queue<Integer> q = new ArrayDeque<>(n);

        // 1. [1,n] 까지 사람 넣고
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        // 2. q 가 빌 때까지 한 사람씩 방문하면서 방문한 사람은 다시 뒤로 가라고 하자
        // 여기서 방문이란 행위는 q.remove(i) 와 같고
        // 뒤로 가라고 하는 행위는 다시 큐에 집어넣는 q.add(i) 와 같다.
        // 즉 뺐다가 다시 집어넣는것임.
        int iter = 0;
        while(!q.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                int person = q.remove();
                q.add(person);
            }
            series[iter++] = q.remove();
        }
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "<", ">");

        for (int item : series) {
            joiner.add(String.valueOf(item));
        }

        return joiner.toString();
    }
}