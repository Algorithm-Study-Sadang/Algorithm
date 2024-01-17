package week01.boj4889;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = 0;
        StringBuilder sb = new StringBuilder();
        while(true) {
            String input = sc.nextLine();
            if(input.startsWith("-")) {
                break;
            }
            num ++;
            Stack<String> st = new Stack<String>();
            Stack<String> cst = new Stack<String>();
            String[] list = input.split("");


            for (String s : list) {
                if(s.equals("{")) {
                    st.push("{");
                }else {
                    if(!st.isEmpty()) {
                        st.pop();
                    }else{
                        cst.push("}");
                    }
                }
            }

            int ans  =0 ;
            if(!cst.isEmpty()) {
                ans +=cst.size()%2 == 0 ? (cst.size()/2) : (cst.size()/2)+1;
            }

            if(!st.isEmpty()) {
                ans += st.size() %2 == 0 ? (st.size()/2) : (st.size()/2)+1;
            }

            sb.append(num + "." + " " + ans + "\n");

        }
        System.out.println(sb.toString());
    }
}
