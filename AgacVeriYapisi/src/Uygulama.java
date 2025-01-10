public class Uygulama {

    public static void main(String[] args) {

        BTree bt = new BTree();

        bt.root = bt.insert(bt.root, 10);
        bt.root = bt.insert(bt.root, 15);
        bt.root = bt.insert(bt.root, 8);
        bt.root = bt.insert(bt.root, 20);
        bt.root = bt.insert(bt.root, 4);
        bt.root = bt.insert(bt.root, 12);

        System.out.println("Kökün datası: " + bt.root.data);
        System.out.println("Kökün sağındaki ilk eleman: " + bt.root.right.data);
        System.out.println("Kökün solundaki ilk eleman: " + bt.root.left.data);
        System.out.println("Kökün solunun solundaki eleman: " + bt.root.left.left.data);



    }
}