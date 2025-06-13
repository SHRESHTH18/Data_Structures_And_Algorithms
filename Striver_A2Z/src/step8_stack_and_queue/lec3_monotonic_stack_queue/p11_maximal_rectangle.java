package step8_stack_and_queue.lec3_monotonic_stack_queue;
import java.util.Stack;
public class p11_maximal_rectangle {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m= matrix[0].length;
        int max_area=0;
        int[][] prefix = new int[n][m];
        for(int i=0;i<m;i++){
            int sum=0;
            for(int j=0;j<n;j++){
                sum++;
                if(matrix[j][i]=='0'){
                    sum=0;
                }
                prefix[j][i]=sum;
            }
        }
        for(int i=0;i<matrix.length;i++){
            int area=largestRectangleArea(prefix[i]);
            max_area=Math.max(area,max_area);
        }
        return max_area;
    }
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
}
