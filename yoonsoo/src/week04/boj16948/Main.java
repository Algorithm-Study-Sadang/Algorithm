package week04.boj16948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int map[][];
    static int a[] = {-2,-2,0,0,2,2};
    static int b[] = {-1,1,-2,2,-1,1};
    static int n;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        List<Integer> points = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int r1 = points.get(0);
        int c1 = points.get(1);

        int r2 = points.get(2);
        int c2 = points.get(3);

        map = new int[n+1][n+1];

        bfs(r1,c1,r2,c2);

//        for(int arr[]: map) {
//            Arrays.fill(arr,1);
//        }

        System.out.println(map[c2][r2] == 0 ? -1 : map[c2][r2]);
//        for(int arr[] : map) {
//            System.out.println(Arrays.toString(arr));
//        }

    }

    public static void bfs(int startR, int startC,int r2, int c2) {
        Queue<Point> que = new LinkedList<>();

        que.add(new Point(startR,startC));
        map[startC][startR] = 0;

        while(!que.isEmpty()) {
            Point point = que.poll();

            if(point.r == r2 && point.c == c2) {
                break;
            }

            for(int i = 0 ; i < 6 ; i++) {
                int mr = point.r +a[i];
                int mc = point.c +b[i];
                if(mc >= 0 && mc <=n && mr >=0 && mr <=n && map[mc][mr] == 0) {
                    map[mc][mr] = map[point.c][point.r] +1;
                    que.offer(new Point(mr,mc));
                }
            }
        }

    }
}
