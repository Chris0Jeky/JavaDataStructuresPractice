public class Main {
    public static void main(String[] args) {
    BinaryTree biny = new BinaryTree();
    biny.addNode(23);
    biny.addNode(22);
    //System.out.println(biny.addNode(22));
    System.out.println(biny.containsNode(23));
    biny.deleteNode(23);

    System.out.println(biny.containsNode(23));


    }
}

