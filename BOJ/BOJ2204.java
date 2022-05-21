package BOJ;

import java.io.*;
import java.util.*;

class Word implements Comparable<Word> {
    String castToLower;
    String originWord;
    public Word (String castToLower, String originWord){
        this.castToLower = castToLower;
        this.originWord = originWord;
    }


    @Override
    public int compareTo(Word o2) {
        if (this.castToLower.charAt(0) < o2.castToLower.charAt(0))
            return -1;
        else if (this.castToLower.charAt(0) == o2.castToLower.charAt((0))) {
                return this.originWord.charAt(0) - o2.originWord.charAt(0);
        }
        return 1;
    }
}

public class BOJ2204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n;
        int N;
        Word[] words;
        StringBuffer sb = new StringBuffer();
        while(Integer.parseInt(n = br.readLine()) != 0) {
            N = Integer.parseInt(n);
            words = new Word[N];
            for(int i=0; i<N; i++){
                String str = br.readLine();
                words[i] = new Word(str.toLowerCase(), str);
            }
            Arrays.sort(words);
            sb.append(words[0].originWord).append("\n");
        }
        System.out.println(sb);
    }
}
