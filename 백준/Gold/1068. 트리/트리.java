import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int nodeNum, count;
    static Node[] nodes;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nodeNum = Integer.parseInt(br.readLine());
        nodes = new Node[nodeNum];
        visited = new boolean[nodeNum];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<nodeNum; i++) {
            nodes[i] = new Node(i);
        }

        Node root = null;
        int rootIdx = -1;
        for(int i=0; i<nodeNum; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp == -1) {
                nodes[i].parent = null;
                root = nodes[i];
                rootIdx = i;
            } else {
                nodes[i].parent = nodes[tmp];
                nodes[tmp].children.add(nodes[i]);
            }
        }

        int deleteNodeNum = Integer.parseInt(br.readLine());
        if (deleteNodeNum == rootIdx) {
            System.out.println(0);
            return;
        }
        Node deleteNode = nodes[deleteNodeNum];
        if (deleteNode.parent != null) {
            deleteNode.parent.children.remove(deleteNode);
            nodes[deleteNodeNum] = null;
        }

        search(root);
        System.out.println(count);
    }

    private static void search(Node node) {
        if (node.children.isEmpty()) {
            count++;
            return;
        }

        for (Node child : node.children) {
            if (!visited[child.data]) {
                visited[child.data] = true;
                search(child);
            }
        }
    }
}

class Node {
    int data;
    Node parent;
    List<Node> children = new ArrayList<>();

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node parent) {
        this.data = data;
        this.parent = parent;
    }

    @Override
    public String toString() {
        return String.valueOf(this.data);
    }
}

