package week02.boj1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * MEM  17MB
 * TIME 172ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            String[] tokens = br.readLine().split(" ");
            int X = Integer.parseInt(tokens[0]); // 가로
            int Y = Integer.parseInt(tokens[1]); // 세로
            int k = Integer.parseInt(tokens[2]); // 배추개수

            int[][] map = new int[Y][X];
            boolean[][] check = new boolean[Y][X];
            ArrayList<int[]> searchPositions = new ArrayList<>();

            // 배추를 심어주자
            for (int i = 0; i < k; i++) {
                String[] coord = br.readLine().split(" ");
                int x = Integer.parseInt(coord[0]);
                int y = Integer.parseInt(coord[1]);

                map[y][x] = 1;

                // 콩심은 데 콩 나고 배추 심은데 배추난다.
                searchPositions.add(new int[]{y, x});
            }

            int warms = 0;
            for (int[] pos : searchPositions) {
                int y = pos[0];
                int x = pos[1];

                // 안 간 곳이 있으면 지렁이를 푼다.
                if (!check[y][x]) {
                    warms++;
                    dfs(map, check, y, x);
                }
            }

            sb.append(warms).append("\n");
        }

        System.out.println(sb);
    }

    // 다음 위치 계산용 배열
    private static final int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static void dfs(int[][] map, boolean[][] check, int y, int x) {
        check[y][x] = true;

        for (int i = 0; i < dir.length; i++) {
            int ny = y + dir[i][0]; // 다음 y 좌표
            int nx = x + dir[i][1]; // 다음 x 좌표

            // 사방으로 배추 흰나비 애벌레를 이동시키자
            if (isIn(map, ny, nx) && !check[ny][nx] && map[ny][nx] == 1) {
                dfs(map, check, ny, nx);
            }
        }
    }

    private static boolean isIn(int[][] map, int y, int x) {
        return (0 <= y && y < map.length) && (0 <= x && x < map[0].length);
    }
}

