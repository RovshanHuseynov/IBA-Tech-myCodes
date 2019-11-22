package graph.tree.binarySortedTree;

public class BinaryTree {
    public Node root = null;

    public void add(int value) {
        Node cur = root;
        Node newNode = new Node(value);
        if (cur == null) {
            root = newNode;
        } else {
            while (true) {
                if (value < cur.value) {
                    if (cur.left == null){
                        cur.left = newNode;
                        break;
                    }
                    else cur = cur.left;
                } else if (value > cur.value) {
                    if (cur.right == null){
                        cur.right = newNode;
                        break;
                    }
                    else cur = cur.right;
                }
            }
        }
    }

    public boolean contains(int value) {
        Node cur = root;

        while (cur != null) {
            if (value == cur.value) return true;

            if (value < cur.value) cur = cur.left;
            else cur = cur.right;
        }

        return false;
    }

    public void remove(int value){
        Node cur = root;

        while(true){
            if(value == cur.value){
                if(cur.right != null){

                }
            }

            if(value < cur.value) cur = cur.left;
            else cur = cur.right;
        }
    }
}
