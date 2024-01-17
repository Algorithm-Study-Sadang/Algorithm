package week02.boj1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int map[][];
    static int a[] = {0,0,-1,1};
    static int b[] = {1,-1,0,0};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < t; i++) {
            String[] input = br.readLine().split(" ");
            //가로길이 x값
            int m = Integer.parseInt(input[0]);
            //세로길이 y값
            int n = Integer.parseInt(input[1]);

            int k = Integer.parseInt(input[2]);
            map = new int[n][m];

            for(int j = 0 ; j < k ; j++) {
                String[] pointInput = br.readLine().split(" ");
                int x = Integer.parseInt(pointInput[0]);
                int y = Integer.parseInt(pointInput[1]);
                map[y][x] = 1;
            }


            int cnt = 0;
            for(int j = 0 ; j < n ; j++) {
                for(int l = 0 ; l < m ; l++) {
                    if(map[j][l] == 1 ) {
                        map[j][l] = 0;
                        dfs(l,j,m,n);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);

        }

    }


    public static void dfs(int x, int y, int row, int col) {
        for(int i = 0 ; i < 4 ; i++) {
            int mx = x + a[i];
            int my = y + b[i];

            if(mx >= 0 && mx < row && my >= 0 && my < col && map[my][mx] == 1 ) {
                map[my][mx] = 0;
                dfs(mx,my,row,col);
            }
        }
    }
}
