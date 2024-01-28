package week04.boj2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {


    static boolean relationArr[][];
    static boolean visited[][];
    static Integer result[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> input = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int pCount = Integer.parseInt(br.readLine());
        relationArr = new boolean[n+1][n+1];
        visited = new boolean[n+1][n+1];
        result = new Integer[n+1];

        Arrays.fill(result,0);

        for(int i = 1 ; i <= pCount ; i++) {
            List<Integer> relation = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            //x
            Integer parent = relation.get(0);
            //y
            Integer child = relation.get(1);

            relationArr[child][parent] = true;
            relationArr[parent][child] = true;
        }
        Integer startC = input.get(0);
        Integer startP = input.get(1);

        visited[startC][startP] = true;
        visited[startP][startC] = true;

        bfs(startC);

        System.out.println(result[startP] == 0 ? -1 : result[startP]);
        System.out.println(Arrays.toString(result));

    }

    public static void bfs(int start) {
        Queue<Integer> que  = new LinkedList<>();
        que.add(start);
        while(!que.isEmpty()) {
            int cur = que.poll();
            for(int i = 1 ; i < relationArr.length ; i++) {
                if(relationArr[cur][i] && !visited[cur][i] && !visited[i][cur]) {
                    visited[cur][i] = true;
                    visited[i][cur] = true;
                    que.add(i);
                    result[i] = result[cur] +1;
                }
            }

        }
    }
}
