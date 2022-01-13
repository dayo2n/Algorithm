package BOJ;

import java.util.*;

public class BOJ2775 {
    static int [][] apartment;

    static void init(){
        apartment = new int[15][15]; // 0충은 있고,0호는 없다
        for(int a=0; a<apartment.length; a++){
            for(int b=1; b<apartment[0].length; b++){
                if(a==0){
                    apartment[a][b] = b;
                }else if (b==0){
                    apartment[a][b] = 1;
                }else{
                    apartment[a][b] = apartment[a][b-1] + apartment[a-1][b];
                }
            }
        }
    }
    public static void main(String[] args) {

        init();
        StringBuilder sb = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            int k = sc.nextInt();
            int n = sc.nextInt();
            sb.append(apartment[k][n]).append("\n");
        }
        System.out.println(sb);
    }
}

