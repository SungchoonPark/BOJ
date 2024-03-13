import java.util.*;

class Node {
    int data;
    int x;
    int y;
    Node left;
    Node right;

    public Node(int data, int x, int y) {
        this.data = data;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static Node[] nodes;

    public int[][] solution(int[][] nodeinfo) {
        nodes = new Node[nodeinfo.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }

        Arrays.sort(nodes, (a, b) -> b.y - a.y);

        Node root = constructTree(nodes);

        List<Integer> preOrder = new ArrayList<>();
        pre(root, preOrder);

        List<Integer> postOrder = new ArrayList<>();
        post(root, postOrder);

        return new int[][] {
                preOrder.stream().mapToInt(Integer::intValue).toArray(),
                postOrder.stream().mapToInt(Integer::intValue).toArray()
        };
    }

    private Node constructTree(Node[] nodes) {
        Node root = nodes[0];

        for (int i = 1; i < nodes.length; i++) {
            insert(root, nodes[i]);
        }

        return root;
    }

    private void insert(Node root, Node node) {
        if (node.x > root.x) {
            if (root.right == null) {
                root.right = node;
            } else {
                insert(root.right, node);
            }
        } else {
            if (root.left == null) {
                root.left = node;
            } else {
                insert(root.left, node);
            }
        }
    }

    private void pre(Node node, List<Integer> visited) {
        if (node == null) return;

        visited.add(node.data);
        pre(node.left, visited);
        pre(node.right, visited);
    }

    private void post(Node node, List<Integer> visited) {
        if (node == null) return;

        post(node.left, visited);
        post(node.right, visited);
        visited.add(node.data);
    }
}