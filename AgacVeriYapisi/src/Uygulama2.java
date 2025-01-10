public class Uygulama2 {


    public static void main(String[] args)
    {
       BTree2 bt = new BTree2();


       bt.root = bt.insert(bt.root, 10);
       bt.root = bt.insert(bt.root, 8);
       bt.root = bt.insert(bt.root, 15);
       bt.root = bt.insert(bt.root, 5);
       bt.root = bt.insert(bt.root, 12);
       bt.root = bt.insert(bt.root, 20);
       bt.root = bt.insert(bt.root, 9);


       System.out.println("PreOrder: ");
       bt.preOrder(bt.root);

       System.out.println();


       System.out.println("inOrder: ");
       bt.inOrder(bt.root);

       System.out.println();

       System.out.println("PostOrder: ");
       bt.postOrder(bt.root);


      System.out.println("\nAğacın yüksekliği: " + bt.height(bt.root));


      System.out.println("\nAğaçdaki eleman sayısı: " + bt.size(bt.root));







    }
}
