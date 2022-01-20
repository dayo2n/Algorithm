package BOJ;
import java.util.*;

public class BOJ1439_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        int zero = 0;
        int one = 0;
        for(int i=0; i<S.length()-1; i++){
            if(S.charAt(i) == '0'){
                zero++;
                while(i < S.length()-1){
                    i++;
                    if(S.charAt(i) != '0') {
                        i--;
                        break;
                    }
                }
            }else {
                one++;
                while(i < S.length()-1){
                    i++;
                    if(S.charAt(i) != '1') {
                        i--;
                        break;
                    }
                }
            }
        }
        System.out.println(Math.min(zero, one));
    }
}
