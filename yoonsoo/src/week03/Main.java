package week03;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int m;
    static int map[][];
    static int a[] = {0,0,1,-1,};
    static int b[] = {1,-1,0,0};
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String size[] = br.readLine().split(" ");

        n = Integer.parseInt(size[0]);
        m = Integer.parseInt(size[1]);
        map = new int[n][m];
        visited = new boolean[n][m];

        Pair start = null;
        for(int i = 0 ; i < n; i++){
            String inputLine[] = br.readLine().split(" ");
            for(int j = 0 ; j < m ; j++){
                map[i][j] = Integer.parseInt(inputLine[j]);
                if(map[i][j] == 2){
                    start = new Pair(i,j);
                    map[i][j] = 0;
                }
            }
        }

        bfs(start);

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < n;i++){
            for(int j = 0 ; j < m ;j++){
                if(!visited[i][j] && map[i][j] == 1){
                    sb.append(-1+" ");
                    continue;
                }
                sb.append(map[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(Pair start){
        Queue<Pair> st = new LinkedList<>();


        st.add(start);
        visited[start.x][start.y] = true;
        while(!st.isEmpty()){
            Pair pair = st.poll();
            for(int i = 0 ; i < 4 ; i++){
                int x = pair.x+a[i];
                int y = pair.y+b[i];
                if(x >=0 && n>x  && y >= 0 && m >y && map[x][y]==1 && !visited[x][y]){
                    visited[x][y] = true;
                    map[x][y] = map[pair.x][pair.y]+1;
                    st.add(new Pair(x,y));
                }
            }


        }


    }


}