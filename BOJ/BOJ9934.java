//package BOJ;
//
//import java.io.*;
//import java.util.StringTokenizer;
//
////class Node{
////    int data;
////    Node left, right;
////
////    Node (int data) {
////        this.data = data;
////        this.left = null;
////        this.right = null;
////    }
////}
//
//public class BOJ9934 {
//    static int [] route;
//    static boolean [] visited;
//    static Node [] tree;
//    static void makeBuilding(Node node, int idx) {
//        if (node.left == null) makeBuilding(new Node(route[idx+1]), idx+1);
//    }
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int K = Integer.parseInt(br.readLine());
//        int numberNodes = (int)Math.pow(2.0, K) - 1;
//        tree = new Node[numberNodes + 1];
//        visited = new boolean[numberNodes + 1];
//        Node start = null;
//        for (int k=0; k<numberNodes; k++) {
//            st = new StringTokenizer(br.readLine());
//            int cur = Integer.parseInt(st.nextToken());
//            if (k==0) start = new Node(cur);
//            route[k] = cur;
//        }
//        makeBuilding(start, 0);
//    }
//}
