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

    private Stack<int[]> st;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        // if the stack is empty, the min value should be the val itself
        if (st.isEmpty()) {
            int[] arr = new int[2];
            arr[0] = val;
            arr[1] = val;
            st.push(arr);
        }
        // now, compare the existed min val to this new added val
        else {
            int[] arr = new int[2];
            arr[0] = val;
            arr[1] = Math.min(getMin(), val);
            st.push(arr);
        }

    }

    public void pop() {
        st.pop();
    }

    public int top() {
        int[] arr = st.peek();
        return arr[0];
    }

    public int getMin() {
        // the current min value for the elements in the stacks currently
        // always store in the top element
        return st.peek()[1];
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
