class StockSpanner {
    Deque<Integer> stack;
    int index=0;
    ArrayList<Integer> list=new ArrayList<>();
    public StockSpanner() {
        stack=new ArrayDeque<>();
    }
    
    public int next(int price) {
        list.add(price);
        while(!stack.isEmpty()&& list.get(stack.peek())<=price){
            stack.pop(); 
        }
        int val=stack.isEmpty()?index+1:(index-stack.peek());
        stack.push(index);
        index++;
        return val;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */