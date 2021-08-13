package src.leetcode.easy.p559;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class Solution {
    public int maxDepth2(Node root) {
        if (root == null) return 0;
        int maxDepth = 0;
        if (root.children != null && !root.children.isEmpty()) {
            for (int i = 0; i < root.children.size(); i++) {
                maxDepth = Math.max(maxDepth(root.children.get(i)), maxDepth);
            }
        }
        return maxDepth + 1;
    }

    public int maxDepth(Node root) {
        Deque<Node> queue = new ArrayDeque<>();
        if (root != null) {
            queue.addLast(root);
        }
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            maxDepth++;
            for (int i = 0; i < len; i++) {
                Node node = queue.removeFirst();
                if (node.children != null) {
                    for (int j = 0; j < node.children.size(); j++) {
                        if (node.children.get(j) != null) {
                            queue.addLast(node.children.get(j));
                        }
                    }
                }
            }
        }
        return maxDepth;
    }
}
