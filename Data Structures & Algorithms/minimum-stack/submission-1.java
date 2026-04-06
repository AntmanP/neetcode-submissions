class MinStack {
    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
      if(st.isEmpty()){
        st.push(0L);
        min = val;
      }
      else{
        st.push(val-min);
        if(min>val) min=val;
      }
    }
    
    public void pop() {
       long temp = st.pop();
       if(temp<0) min = min - temp;
    }
    
    public int top() {
        long top= st.peek();
      if(top>0){
       return (int)(min+top);
      }

        return (int)min;

    }
    
    public int getMin() {
        return (int) min;
    }
}
