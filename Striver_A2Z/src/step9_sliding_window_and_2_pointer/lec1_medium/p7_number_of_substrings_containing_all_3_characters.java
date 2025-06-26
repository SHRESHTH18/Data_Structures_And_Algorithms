package step9_sliding_window_and_2_pointer.lec1_medium;

public class p7_number_of_substrings_containing_all_3_characters {
    public int numberOfSubstrings(String s) {

        int count=0;
        int n= s.length();
        int[] last_seen = new int[3];
        for(int i=0;i<3;i++){
            last_seen[i]=-1;
        }

        for(int i=0;i<n;i++){
            last_seen[s.charAt(i) - 'a']=i;
            int a= last_seen[0];
            int b=last_seen[1];
            int c= last_seen[2];
            if(a>=0 && b>=0 && c>=0){
                int index=Math.min(a,Math.min(b,c));
                count += index+1;
            }
        }
        return count;

    }
}
