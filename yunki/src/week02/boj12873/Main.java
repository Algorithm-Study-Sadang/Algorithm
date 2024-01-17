package week02.boj12873;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(new Gift(n).draw());
    }
}

class Gift {
    private final int n;

    Gift(int n) {
        this.n = n;
    }

    public int draw() {
        Queue<Integer> q = new ArrayDeque<>(n);
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        // 손으로 그려보니 이런 규칙이 있더라..
        // 레벨은 사람수 - 1 만큼만 늘어나게 되어있음. 한 사람 남을 때까지만 하니까
        for (int level = 1; level <= n - 1; level++) {
            // 사람수가 5000명이 되어버리면 5000^3 이 120억 정도 되어버리기 때문에 2초 안에 못 한다.
            // 손으로 그려보면 level^3 - 1 을 사람수로 나눈 나머지 만큼만 돌리면 되더라.
            long iter = (long) (Math.pow(level, 3) - 1) % q.size();

            for (int j = 0; j < iter; j++) {
                q.add(q.remove());
            }

            // 그리고 마지막에 만난 사람 제거해버리면 됨!
            q.remove();
        }

        return q.element();
    }
}
