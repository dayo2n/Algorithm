package BOJ;

import java.util.*;
import java.io.*;

class Size{
    int height, weight, order;
    Size(int h, int w){
        this.height = h;
        this.weight = w;
        this.order = 1;
    }

    int compareSize(Size o){
        if(this.height > o.height && this.weight > o.height)
            return 0;
        else if(this.height < o.height && this.weight < o.weight)
            return 1;
        return 0;
    }
}

public class BOJ7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        List<Size> list = new LinkedList<>();
        int h, w;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            list.add(new Size(h, w));
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            Size target = list.get(i);
            for(int j=0; j<list.size(); j++){
                if(i!=j)
                    target.order += target.compareSize(list.get(j));
            }
            sb.append(target.order).append(" ");
        }
        System.out.println(sb);

    }
}
