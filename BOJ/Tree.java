package BOJ;

public class Tree {
    int size;

    public Tree() {
        this.size = 0;
    }

    public class Node {
        Object data;
        Node left, right;
        public Node (Object data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public void addLeft(Node node) {
            this.left = node;
            size++;
        }

        public void addRight(Node node) {
            this.right = node;
            size++;
        }

        public void deleteLeft() {
            this.left = null;
            size++;
        }
    }

    public Node addNode(Object data) {
        Node n = new Node(data);
        return n;
    }

    public void preOrder(Node node) { // 전위 순회
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node) { // 중위 순회
        if (node == null ) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }
}
