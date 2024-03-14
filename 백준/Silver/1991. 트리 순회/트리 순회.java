import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static Node head = new Node("A", null, null);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeNum = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[nodeNum];

        for (int i = 0; i < nodeNum; i++) {
            st = new StringTokenizer(br.readLine());
            // 항상 A가 루트노드
            String data = st.nextToken();
            String leftStr = st.nextToken();
            String rightStr = st.nextToken();

            insertNode(head, data, leftStr, rightStr);
        }
        pre(head);
        System.out.println();
        middle(head);
        System.out.println();
        post(head);
    }

    private static void insertNode(Node tmp, String data, String leftStr, String rightStr) {
        if (Objects.equals(tmp.data, data)) {
            tmp.left = leftStr.equals(".") ? null : new Node(leftStr, null, null);
            tmp.right = rightStr.equals(".") ? null : new Node(rightStr, null, null);
        } else {
            if (tmp.left != null) insertNode(tmp.left, data, leftStr, rightStr);
            if (tmp.right != null) insertNode(tmp.right, data, leftStr, rightStr);
        }
    }

    private static void pre(Node node) {
        if (node == null) return;

        System.out.print(node.data);
        pre(node.left);
        pre(node.right);
    }

    private static void middle(Node node) {
        if (node == null) return;

        middle(node.left);
        System.out.print(node.data);
        middle(node.right);
    }

    private static void post(Node node) {
        if (node == null) return;

        post(node.left);
        post(node.right);
        System.out.print(node.data);
    }

}

class Node {
    String data;
    Node parent;
    Node left;
    Node right;

    public Node(String data) {
        this.data = data;
    }

    public Node(String data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}