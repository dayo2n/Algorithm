//package BOJ;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//class Node {
//    char data;
//    Node left, right;
//
//    public Node(char data) {
//        this.data = data;
//        this.left = null;
//        this.right = null;
//    }
//}
//
//public class BOJ1991 {
//
//    static Node [] tree;
//    static StringBuilder sb;
//
//    static void preOrder(int idx){
//        sb.append(tree[idx].data);
//        if (tree[idx].left != null)  preOrder(tree[idx].left.data - 'A');
//        if (tree[idx].right != null)  preOrder(tree[idx].right.data - 'A');
//    }
//
//    static void inOrder(int idx){
//        if (tree[idx].left != null)  inOrder(tree[idx].left.data - 'A');
//        sb.append(tree[idx].data);
//        if (tree[idx].right != null)  inOrder(tree[idx].right.data - 'A');
//    }
//
//    static void postOrder(int idx){
//        if (tree[idx].left != null)  postOrder(tree[idx].left.data - 'A');
//        if (tree[idx].right != null)  postOrder(tree[idx].right.data - 'A');
//        sb.append(tree[idx].data);
//    }
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        sb = new StringBuilder();
//        int N = Integer.parseInt(br.readLine());
//        tree = new Node[N];
//
//        for (int n=0; n<N; n++) tree[n] = new Node((char) ('A' + n));
//
//        for (int n=0; n<N; n++) {
//            String input = br.readLine();
//            Node root = new Node(input.charAt(0));
//            Node left = new Node(input.charAt(2));
//            Node right = new Node(input.charAt(4));
//            if (left.data != '.') tree[root.data - 'A'].left = tree[left.data - 'A'];
//            if (right.data != '.') tree[root.data - 'A'].right = tree[right.data - 'A'];
//        }
//        preOrder(0);
//        sb.append("\n");
//        inOrder(0);
//        sb.append("\n");
//        postOrder(0);
//        sb.append("\n");
//        System.out.println(sb);
//    }
//}
