package step8_stack_and_queue.lec3_monotonic_stack_queue;
import java.util.Stack;
public class p10_largest_rectangle_in_histogram {

    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int max_area=0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.empty() && heights[i]<=heights[st.peek()]){
                int el = st.pop();
                int nse = i;
                int pse = st.empty()?-1:st.peek();
                int area= heights[el] * (nse-pse-1);
                max_area= Math.max(max_area,area);
            }
            st.push(i);
        }
        while(!st.empty()){
            int nse=n;
            int el= st.pop();
            int pse = st.empty()?-1:st.peek();
            int area= heights[el] * (nse-pse-1);
            max_area= Math.max(max_area,area);
        }
        return max_area;
    }

        //better - O(5N)
//    public int largestRectangleArea(int[] heights) {
//        int n=heights.length;
//        int max_area=0;
//        int[] nse = find_nse(heights);
//        int[] pse = find_pse(heights);
//        for(int i=0;i<n;i++){
//            int area = heights[i] * (nse[i]-pse[i]-1);
//            max_area=Math.max(area,max_area);
//        }
//        return max_area;
//    }
//
//    public int[] find_nse(int[] heights){
//        int n = heights.length;
//        int[] nse = new int[n];
//        Stack<Integer> st = new Stack<>();
//        for(int i=n-1;i>=0;i--){
//            while(!st.empty() && heights[i]<=heights[st.peek()]){
//                st.pop();
//            }
//            if(st.empty()){
//                nse[i]=n;
//            }
//            else{
//                nse[i]=st.peek();
//            }
//            st.push(i);
//        }
//        return nse;
//
//    }
//    public int[] find_pse(int[] heights){
//        int n = heights.length;
//        int[] pse = new int[n];
//        Stack<Integer> st= new Stack<>();
//        for(int i=0;i<n;i++){
//            while(!st.empty() && heights[i]<=heights[st.peek()]){
//                st.pop();
//            }
//            if(st.empty()){
//                pse[i]=-1;
//            }
//            else{
//                pse[i]=st.peek();
//            }
//            st.push(i);
//        }
//        return pse;
//    }

    //TLE - O(N**2)
//    public int largestRectangleArea(int[] heights) {
//        int n=heights.length;
//        int max_area=0;
//        for(int i=0;i<n;i++){
//            int min=heights[i];
//            for(int j=i;j<n;j++){
//                min=Math.min(min,heights[j]);
//                max_area=Math.max(max_area,min*(j-i+1));
//            }
//        }
//        return max_area;
//    }
}
