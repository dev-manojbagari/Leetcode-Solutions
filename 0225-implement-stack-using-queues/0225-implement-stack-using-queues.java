class MyStack {
    Queue q = new LinkedList<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        Queue q1 = new LinkedList<>();
        q1.offer(x);
        q1.offer(q);
        q = q1;
    }
    
    public int pop() {
        int res = (int)q.poll();
        q = (Queue)q.poll();
        return res;
    }
    
    public int top() {
        return (Integer)q.peek();
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