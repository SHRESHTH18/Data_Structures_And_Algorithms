package step8_stack_and_queue.lec4_implementation_problems;
import java.util.*;
public class p2_stock_spanner {
    class pair{
        int price;
        int span;
        public pair(int price, int span){
            this.price= price;
            this.span=span;
        }
    }
    Stack<pair> st = new Stack<>();
    public p2_stock_spanner() {
        
    }

    public int next(int price) {
        int count=1;
        while(!st.empty() && price>=st.peek().price){
            count+=st.peek().span;
            st.pop();

        }
        st.push(new pair(price,count));
        return count;
    }
}
