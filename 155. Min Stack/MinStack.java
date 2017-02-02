public class MinStack {
    /*use two stacks in which one is used to store all elements and the other is used to store the minimum value.
    Both of them r dynamic
    */
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> min   = new Stack<Integer>();
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        stack.push(x);
        if (min.isEmpty()) min.push(x);
        else{
            if (min.peek()>x){
                min.pop();
                min.push(x);
            }
        }
    }
    
    public void pop() {
        int c = stack.peek(), b = min.peek();
        if (c==b){ 
            min.pop();
            stack.pop();
            if (!stack.isEmpty()){
                int a = stack.peek();
                Stack<Integer> temp = new Stack<Integer>();
                while(!stack.isEmpty()){
                    if (stack.peek() < a){
                        a = stack.peek();
                    }
                    temp.push(stack.pop());
                }
                while (!temp.isEmpty() ){
                    stack.push(temp.pop());
                }
                min.push(a);
            }
        }
        else
            stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
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