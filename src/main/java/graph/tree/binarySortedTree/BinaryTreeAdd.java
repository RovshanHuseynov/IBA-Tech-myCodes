package graph.tree.binarySortedTree;

public class BinaryTreeAdd {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.add(20);
        bt.add(10);
        bt.add(30);
        bt.add(35);
        bt.add(31);

        System.out.println(bt.contains(20));
        System.out.println(bt.contains(10));
        System.out.println(bt.contains(30));
        System.out.println(bt.contains(31));
        System.out.println(bt.contains(35));
        System.out.println(bt.contains(100));
        System.out.println(bt.contains(101));
        System.out.println(bt.contains(102));
    }
}
