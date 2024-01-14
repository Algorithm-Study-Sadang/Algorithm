package week02.boj10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 	MEM     20MB
 * 	TIME    0.2s
 */
public class Main {
    private static final int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        CircularQueue q = new CircularQueue(MAX);

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().split(" ");
            String op = tokens[0];

            switch (op) {
                case "push" -> {
                    int item = Integer.parseInt(tokens[1]);
                    try {
                        q.push(item);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "pop" -> {
                    try {
                        int item = q.pop();
                        sb.append(item).append("\n");
                    } catch (Exception e) {
                        sb.append("-1\n");
                    }
                }
                case "size" -> sb.append(q.size).append("\n");
                case "empty" -> sb.append(q.isEmpty() ? "1" : '0').append("\n");
                case "front" -> sb.append(q.front()).append("\n");
                case "back" -> sb.append(q.back()).append("\n");
            }
        }

        System.out.println(sb);
    }
}

class CircularQueue {
    private final int capacity;
    private final int[] elements;
    private int front, rear;
    public int size;

    CircularQueue(int capacity) {
        this.capacity = capacity;
        this.elements = new int[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int front() {
        if (isEmpty()) {
            return -1;
        }

        return elements[front];
    }

    public int back() {
        if (isEmpty()) {
            return -1;
        }

        return elements[rear];
    }

    public void push(int item) throws Exception {
        if (isFull()) {
            throw new Exception("큐가 가득찼어요.");
        }

        rear = (rear + 1) % capacity;
        elements[rear] = item;

        size++;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("큐가 비어있어요.");
        }

        int element = elements[front];
        front = (front + 1) % capacity;

        size--;

        return element;
    }
}
