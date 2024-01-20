/**
 *  영역 구하기
 *  https://www.acmicpc.net/problem/2583
 *  [ 효율성 ]
 *  - 메모리: 19852KB
 *  - 시간 : 288ms
 */

package week03.boj2583;

import java.util.*;

public class Main {
    private static final int VISITED = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arrays = initArrays(scanner);
        List<Integer> counts = new ArrayList<>();

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                if (arrays[i][j] == 0) {
                    int count = dfsAndGetSearchCount(arrays, new int[] {i, j});

                    counts.add(count);
                }
            }
        }
        counts.sort(Comparator.naturalOrder());
        System.out.println(counts.size() + "\n" + String.join(" ", mapToStrings(counts)));
        scanner.close();
    }

    private static int dfsAndGetSearchCount(int[][] array, int[] start) {
        int count = 1;
        Stack<int[]> stack = new Stack<>() { { push(start); } };
        array[start[0]][start[1]] = VISITED;

        while (!stack.isEmpty()) {
            int[] outed = stack.pop();

            for (int[] next : new int[][] {
                    {outed[0] - 1, outed[1]},
                    {outed[0], outed[1] + 1},
                    {outed[0] + 1, outed[1]},
                    {outed[0], outed[1] - 1}
            }) {
                if (next[0] < 0 || next[0] >= array.length || next[1] < 0 || next[1] >= array[0].length) continue;
                if (array[next[0]][next[1]] == 0) {
                    array[next[0]][next[1]] = VISITED;
                    count++;
                    stack.push(next);
                }
            }
        }
        return count;
    }

    private static List<String> mapToStrings(List<Integer> list) {
        return new ArrayList<>() {
            {
                for (int num : list) add(String.valueOf(num));
            }
        };
    }

    private static int[][] initArrays(Scanner scanner) {
        int m = scanner.nextInt(), n = scanner.nextInt(), k = scanner.nextInt();
        int[][] arrays = new int[m][n];

        for (int a = 0; a < k; a++) {
            int startX = scanner.nextInt(), startY = scanner.nextInt();
            int endX = scanner.nextInt(), endY = scanner.nextInt();

            for (int b = startY; b <= endY - 1; b++) {
                for (int c = startX; c <= endX - 1; c++) {
                    arrays[b][c] = 1;
                }
            }
        }
        return arrays;
    }
}