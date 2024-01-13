package week01.boj4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while(!(input = br.readLine()).equals(".")){
            String[] split = input.split("");
            Stack<String> lStack = new Stack<String>();
            boolean failFlag = false;

            for (int i = 0; i < split.length; i++) {
                if(split[i].equals("(") ||  split[i].equals("[")){
                    lStack.add(split[i]);
                }else if(split[i].equals(")") || split[i].equals("]")){
                    if(lStack.isEmpty()){
                        failFlag = true;
                        break;
                    }else if(split[i].equals("]") && lStack.peek().equals("[")){
                        lStack.pop();
                    }else if(split[i].equals(")") && lStack.peek().equals("(")){
                        lStack.pop();
                    }else{
                        failFlag = true;
                        break;
                    }
                }
            }

            if(failFlag || !lStack.isEmpty()){
                System.out.println("no");
            }else{
                System.out.println("yes");
            }
        }

    }
}