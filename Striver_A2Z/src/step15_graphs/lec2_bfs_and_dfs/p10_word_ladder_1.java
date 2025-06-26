package step15_graphs.lec2_bfs_and_dfs;
import java.util.*;
public class p10_word_ladder_1 {
    class Pair{
        String word;
        int len;

        public Pair(String word,int len){
            this.word=word;
            this.len=len;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(beginWord,1));
        while(!q.isEmpty()){
            Pair el = q.poll();
            String word = el.word;
            if(word.equals(endWord)) return el.len;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] arr = word.toCharArray();
                    arr[i]=ch;
                    String replace= new String(arr);
                    if(set.contains(replace)){
                        q.offer(new Pair(replace,el.len+1));
                        set.remove(replace);
                    }
                }
            }
        }
        return 0;
    }
}
