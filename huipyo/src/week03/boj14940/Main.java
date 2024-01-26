package week03.boj14940;

import java.util.*;
import java.util.function.Function;

// 45%에서 메모리 초과 발생하네요
public class Main {
    static int[] mStart;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[][] arrays = initArrays(scanner);
        Queue<int[]> queue = new ArrayDeque<>(List.of(mStart));

        while (!queue.isEmpty()) {
            int[] outed = queue.poll();

            for (int[] next : new int[][] {
                    {outed[0] - 1, outed[1]},
                    {outed[0], outed[1] + 1},
                    {outed[0] + 1, outed[1]},
                    {outed[0], outed[1] - 1}
            }) {
                if (next[0] > -1 && next[0] < arrays.length && next[1] > -1 && next[1] < arrays[0].length && arrays[next[0]][next[1]] == -1) {
                    int nextLevel = outed[2] + 1;
                    arrays[next[0]][next[1]] = nextLevel;

                    queue.offer(new int[] {next[0], next[1], nextLevel});
                }
            }
        }
        System.out.println(String.join("\n", mapToString(arrays, array -> String.join(" ", mapToString(array, String::valueOf)))));
        scanner.close();
    }

    private static Integer[][] initArrays(Scanner scanner) {
        int n = scanner.nextInt(), m = scanner.nextInt();
        Integer[][] arrays = new Integer[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                switch (scanner.nextInt()) {
                    case 0:
                        arrays[i][j] = 0;
                        break;
                    case 1:
                        arrays[i][j] = -1;
                        break;
                    case 2:
                        arrays[i][j] = 0;
                        mStart = new int[] {i, j, 0};
                        break;
                }
            }
        }
        return arrays;
    }

    private static <T> String[] mapToString(T[] array, Function<T, String> function) {
        String[] result = new String[array.length];

        Arrays.setAll(result, i -> function.apply(array[i]));
        return result;
    }
}