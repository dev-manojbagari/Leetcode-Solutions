class MyStack {
    Queue q;
    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        Queue queue = new LinkedList();
        queue.add(x);
        queue.add(q);
        q = queue;
        
    }
    
    public int pop() {
        int x = (int)q.poll();
        q = (Queue)q.poll();
        return x;
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