package BOJ;

import java.io.*;
import java.util.*;

class Node{
    int data;
    Node parent;
    LinkedList<Node> child;

    Node (int data) {
        this.data = data;
        this.parent = null;
        this.child = new LinkedList<>();
    }

    int childCount() {
        return child.size();
    }
}

public class BOJ1068 {

    static Node root;
    static Node [] tree;
    static boolean [] visited;
    static StringBuilder sb;
    static int cntLeaf;

    static void dfs(int idx) {
        if (visited[idx]) return;
        visited[idx] = true;

        if (tree[idx].childCount() == 0) cntLeaf++;
        int size = tree[idx].child.size();
        for (int i=0; i<size; i++) {
            dfs(tree[idx].child.get(i).data);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        tree = new Node[N];
        visited = new boolean[N];

        // 각 노드 초기화 먼저
        for (int n = 0; n < N; n++) {
            tree[n] = new Node(n);
        }

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = tree[n];
            } else {
                tree[n].parent = tree[parent];
                tree[parent].child.add(tree[n]);
            }
        }

        // 지정된 노드의 연결을 트리로부터 끊음
        int deleteTarget = Integer.parseInt(br.readLine());
        Node targetParent =  tree[deleteTarget].parent;
        if (deleteTarget == root.data) {
            System.out.println(0);
            return;
        }
        int targetIdx = targetParent.child.indexOf(tree[deleteTarget]);
        targetParent.child.remove(targetIdx);

        cntLeaf = 0;
        dfs(root.data);
        System.out.println(cntLeaf);
    }
}
/*
입력
6
2 2 -1 2 0 0
0

오답
1

정답
2
        2
       /|\
      0 1 3
     /|
    4 5
 */

/*
입력
7
2 2 -1 2 0 0  3
0

오답
1

result:
2
        2
       /|\
      0 1 3
     /|    \
    4 5     6
 */

/*
9
8 0  4 0 7 4  1 8 -1
4

result>
3
    7---8
    |    \
    | 6-1-0
    |     |
  2-4-5   3
 */