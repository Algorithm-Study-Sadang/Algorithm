package week03.pgs43164;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[][] {
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        })); // ["ICN", "JFK", "HND", "IAD"]
        System.out.println(new Solution().solution(new String[][] {
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL", "SFO"}
        })); // ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
        System.out.println(new Solution().solution(new String[][] {
                {"ICN", "AAA"},
                {"ICN", "CCC"},
                {"CCC", "DDD"},
                {"AAA", "BBB"},
                {"AAA", "BBB"},
                {"DDD", "ICN"},
                {"BBB", "AAA"}
        })); // ["ICN", "CCC", "DDD", "ICN", "AAA", "BBB", "AAA", "BBB"]
        System.out.println(new Solution().solution(new String[][] {
                {"ICN", "BBB"},
                {"BBB", "AAA"},
                {"AAA", "ICN"}
        })); // ["ICN", "BBB", "AAA", "ICN"]
        System.out.println(new Solution().solution(new String[][] {
                {"ICN", "COO"},
                {"ICN", "BOO"},
                {"COO", "ICN"},
                {"BOO", "DOO"}
        })); // ICN -> COO -> ICN -> BOO -> DOO
        System.out.println(new Solution().solution(new String[][] {
                {"ICN", "A"},
                {"A", "B"},
                {"B", "A"},
                {"A", "ICN"},
                {"ICN", "A"}
        })); // ["ICN", "A", "B", "A", "ICN", "A"]
        System.out.println(new Solution().solution(new String[][] {
                {"ICN", "A"},
                {"ICN", "B"},
                {"B", "ICN"}
        })); // ["ICN", "B", "ICN", "A"]
    }
}

class Solution {
    private static final String START = "ICN";

    public List<String> solution(String[][] tickets) {
        PairStack pairStack = new PairStack(START);
        Stack<String> answer = new Stack<>();
        Runnable backtracking = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < tickets.length; i++) {
                    if (pairStack.indexContains(i) || pairStack.isNotValidPath(tickets, i)) continue;
                    pairStack.push(i, tickets[i][1]);
                    if (pairStack.size() < tickets.length) run();
                    else if (answer.isEmpty()) {
                        //System.out.println(pairStack.mIndexStack + ", " + pairStack.mIndexStack.stream().map(j -> Arrays.toString(tickets[j])).toList() + ", " + pairStack.mPathStack);
                        answer.addAll(pairStack.mPathStack);
                    }
                    pairStack.pop();
                }
            }
        };

        Arrays.sort(tickets, Comparator.comparing(o -> o[1]));
        backtracking.run();
        return answer;
    }
}

class PairStack {
    Stack<Integer> mIndexStack = new Stack<>();

    Stack<String> mPathStack = new Stack<>();

    public PairStack(String start) {
        mPathStack.push(start);
    }

    public void push(int idx, String path) {
        mIndexStack.push(idx);
        mPathStack.push(path);
    }

    public void pop() {
        mIndexStack.pop();
        mPathStack.pop();
    }

    public int size() {
        return mIndexStack.size();
    }

    public boolean indexIsEmpty() {
        return mIndexStack.isEmpty();
    }

    public int indexPeek() {
        return mIndexStack.peek();
    }

    public boolean indexContains(int index) {
        return mIndexStack.contains(index);
    }

    public boolean isNotValidPath(String[][] tickets, int i) {
        return (!mPathStack.peek().equals(tickets[i][0])) || !indexIsEmpty() && !tickets[indexPeek()][1].equals(tickets[i][0]);
    }
}