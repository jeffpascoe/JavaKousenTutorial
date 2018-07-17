package SearchAlgorithms;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

//This an implementation of breadth first search
public class BreadthFirstSearch {
    Queue<Node> queue = new LinkedBlockingQueue<>();

    public boolean search(Node root, Node desiredNode) {
        queue.add(root);

        while (!queue.isEmpty()) {

            Node node = queue.remove();

            System.out.print(" " + node.data);
            if(node.equals(desiredNode)) {
                return true;
            }
            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right!= null) {
                queue.add(node.right);
            }
        }
        return false;
    }
}
