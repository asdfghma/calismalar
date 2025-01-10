public class Uygulama3 {

    public static void main(String[] args)
    {

        SilmeTree bst = new SilmeTree();

        bst.root = bst.insert(bst.root, 10);
        bst.root = bst.insert(bst.root, 5);
        bst.root = bst.insert(bst.root, 15);
        bst.root = bst.insert(bst.root, 20);
        bst.root = bst.insert(bst.root, 4);
        bst.root = bst.insert(bst.root, 8);
        bst.root = bst.insert(bst.root, 12);

        bst.inOrder(bst.root);

        System.out.println("\nKök düğümdeki değer: " + bst.root.data);

        bst.root = bst.delete(bst.root, 10);

        System.out.println("\nSilme işleminden sonra:");

        bst.inOrder(bst.root);

        System.out.println("\nKök düğümdeki değer: " + bst.root.data);




    }
}
