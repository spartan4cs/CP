import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {


    Stack<Integer> st;
    Stack<Integer> min;
    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();

    }

    public void push(int val) {
        st.push(val);
        if (val<getMin()) {
            min.push(val);
        }
    }

    public void pop() {
        int val =st.pop();
        if (val==getMin()) {
            min.pop();
        }

    }

    public int top() {

        return st.peek();
    }

    public int getMin() {
        
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end
