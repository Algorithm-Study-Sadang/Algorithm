package stack;

import java.util.*;

public class B10828_HuipyoHong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();

        new Stack<>() {
            {
                for (int i = 0; i < n; i++) {
                    switch (scanner.next()) {
                        case "push":
                            push(scanner.nextInt());
                            break;
                        case "pop":
                            stringBuilder.append(pop()).append("\n");
                            break;
                        case "size":
                            stringBuilder.append(size()).append("\n");
                            break;
                        case "empty":
                            stringBuilder.append(isEmpty() ? 1 : 0).append("\n");
                            break;
                        case "top":
                            stringBuilder.append(peek()).append("\n");
                            break;
                    }
                }
            }

            @Override
            public synchronized Object pop() {
                return isEmpty() ? -1: super.pop();
            }

            @Override
            public synchronized Object peek() {
                return isEmpty() ? -1 : super.peek();
            }
        };
        System.out.println(stringBuilder.toString().trim());
        scanner.close();
    }
}

