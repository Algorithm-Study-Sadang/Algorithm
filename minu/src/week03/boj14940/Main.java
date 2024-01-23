package week03.boj14940;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] area, result; // 지도, 결과
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int walkX, walkY;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 지도의 넓이
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        area = new int[N][M];
        result = new int[N][M];
        visited = new boolean[N][M];

        walkX = 0;
        walkY = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                if (area[i][j] == 2) {
                    // 목표지점
                    walkX = i;
                    walkY = j;
                } else if (area[i][j] == 0) {
                    // 갈 수 없는 땅
                    visited[i][j] = true;
                }
            }
        }
        bfs(walkX, walkY);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    // 도달할 수 없는 지역
                    result[i][j] = -1;
                }
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        br.close();
    }

    private static void bfs(int walkX, int walkY) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {walkX, walkY});
        visited[walkX][walkY] = true;

        while (!deque.isEmpty()) {
            int[] now = deque.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx>=0 && nx< N && ny>=0 && ny<M) {
                    if(!visited[nx][ny] && area[nx][ny]==1) {
                        visited[nx][ny]=true;
                        result[nx][ny]= result[now[0]][now[1]]+1;
                        deque.add(new int[] {nx,ny});
                    }
                }
            }
        }
    }

}
