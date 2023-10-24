class MyStack {
    Queue<Object> q = new LinkedList<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        Queue<Object> q1 = new LinkedList<>();
        q1.offer(x);
        q1.offer(q);
        q= q1;
    }
    
    public int pop() {
        int val = (int)q.poll();
        q=(Queue)q.poll();
        return val;
    }
    
    public int top() {
        return (int)q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */