/**
 *  트리
 *  https://www.acmicpc.net/problem/1068
 *  [ 효율성 ]
 *  - 메모리: 17836KB
 *  - 시간 : 208ms
 */

package week03.bo1068;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, List<Integer>> graph = new HashMap<>() {
            {
                for (int i = 0; i < n; i++) {
                    int input = scanner.nextInt();

                    computeIfAbsent(input, j -> new ArrayList<>()).add(i);
                }
            }
        };
        int removable = scanner.nextInt();
        int answer = 0;

        // 루트 노드를 삭제하면 0이 나와야한다.
        if (!graph.get(-1).contains(removable)) {
            answer += backtracking(graph, -1, new HashSet<>(), removable);
        }
        System.out.println(answer);
        scanner.close();
    }

    private static int backtracking(Map<Integer, List<Integer>> graph, int start, Set<Integer> visited, int removed) {
        int result = 0;

        // 방향이 있는 그래프에서 인접노드가 없거나 또는 1개인데 그 노드가 지워진 노드면 리프노드
        if (!graph.containsKey(start) || (graph.containsKey(start) && graph.get(start).size() == 1 && graph.get(start).get(0) == removed)) return 1;
        for (int next : graph.getOrDefault(start, new ArrayList<>())) {
            // 방문처리 한것 또는 방문할 노드가 제거된 노드면 가지치기
            if (visited.contains(next) || next == removed) continue;
            visited.add(next);
            result += backtracking(graph, next, visited, removed);
        }
        return result;
    }
}
