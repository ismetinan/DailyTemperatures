import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] days = new int[temperatures.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0 ; i < temperatures.length ; i++) {
            while (!stack.isEmpty()  && temperatures[stack.peek()] < temperatures[i]) {
                int top = stack.pop();
                days[top] = i - top;
            }
            stack.push(i);
        } 
        while (!stack.isEmpty()) {
            int top  = stack.pop();
            days[top] = 0;
        }
        return days;
    }
}