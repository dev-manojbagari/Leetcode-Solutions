class MyStack {

    Queue queue=new LinkedList<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        Queue q = new LinkedList();
        q.add(x);
        q.add(queue);
        queue=q;
    }
    
    public int pop() {
        int x =(Integer)queue.remove();
        queue = (Queue)queue.poll(); 
        return x;
    }
    
    public int top() {
        return (Integer)queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
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