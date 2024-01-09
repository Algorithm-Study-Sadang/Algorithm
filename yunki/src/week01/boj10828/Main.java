package week01.boj10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>(10001);

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Operation op = Operation.valueOf(st.nextToken());

            switch (op) {
                case push -> {
                    int item = Integer.parseInt(st.nextToken());
                    stack.push(item);
                }
                case pop -> {
                    try {
                        Integer item = stack.pop();
                        sb.append(item).append("\n");
                    } catch (Exception e) {
                        sb.append("-1").append("\n");
                    }
                }
                case top -> {
                    try {
                        sb.append(stack.top()).append("\n");
                    } catch (Exception e) {
                        sb.append("-1").append("\n");
                    }
                }
                case size -> sb.append(stack.size()).append("\n");
                case empty -> sb.append(stack.empty() ? "1" : "0").append("\n");
                default -> throw new IllegalArgumentException();
            }
        }

        System.out.println(sb);
    }
}

class Stack<E> extends Vector<E> {
    public Stack(int initialCapacity) {
        super(initialCapacity);
    }

    public void push(E item) {
        addElement(item);
    }

    public E pop() throws Exception {
        E item = top();

        int len = size();
        removeElementAt(len - 1);

        return item;
    }

    public E top() throws Exception {
        int len = size();
        if (len == 0) {
            throw new Exception("스택이 비어있습니다.");
        }
        return elementAt(len - 1);
    }

    public int size() {
        return super.size();
    }

    public boolean empty() {
        return super.size() == 0;
    }
}

enum Operation {
    push,
    pop,
    size,
    empty,
    top
}