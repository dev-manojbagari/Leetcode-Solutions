class StockSpanner {
    class Data{
        int val;
        int span;
        Data(int val,int span){
            this.val=val;
            this.span=span;
        }
    }
    Stack<Data> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span=1;
        while(!stack.isEmpty()&&stack.peek().val<=price)
            span+=stack.pop().span;
        stack.push(new Data(price,span));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */