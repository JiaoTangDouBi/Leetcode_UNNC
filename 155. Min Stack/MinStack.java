class MinStack {
    Stack<Integer> stack;
    PriorityQueue<Integer> pq;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        pq    = new PriorityQueue<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        pq.add(x);
    }
    
    public void pop() {
        int temp = stack.pop();
        pq.remove(temp);
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return pq.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */