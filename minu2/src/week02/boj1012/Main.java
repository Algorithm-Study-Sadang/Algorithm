package week02.boj1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int tc, width, height, C;
    static int[][] area;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken()); // 밭 가로길이
            height = Integer.parseInt(st.nextToken()); // 밭 세로길이
            C = Integer.parseInt(st.nextToken()); // 심어져있는 배추 개수

            area = new int[width][height]; // 배추 밭 크기
            visited = new boolean[width][height]; // 방문 여부

            for(int j = 0; j < C; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // 배추 위치 x
                int y = Integer.parseInt(st.nextToken()); // 배추 위치 y
                area[x][y] = 1; // 배추 심기
            }

            // 배추밭에 배추가 다 심어졌고, 필요한 지렁이만 구하면 됨!
            // 배추밭을 순회하며, 배추가 심어졌지만 첫방문이라면 dfs를 통해 지렁이 수를 구함
            int result = 0;
            for (int d = 0; d < width; d++) {
                for (int e = 0; e < height; e++) {
                    if (area[d][e] == 1 && !visited[d][e]) {
                        dfs(d, e);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
        br.close();
    }


    static void dfs(int x, int y) {
        if (visited[x][y])
            return;

        visited[x][y] = true;
        // 현재위치 {x, y} 에서 상하좌우로 이동하며 배추가 심어져있고, 방문하지 않았다면 dfs 수행
        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            // 이동하는 좌표가 범위를 제한된 위치를 벗어나면 무시
            if (cx >= width || cy >= height || cx < 0 || cy < 0)
                continue;
            // 이미 방문을 한곳이거나 배추가 심어져 있지 않다면 무시
            if (visited[cx][cy] || area[cx][cy] != 1)
                continue;

            dfs(cx, cy);
        }
    }
}
