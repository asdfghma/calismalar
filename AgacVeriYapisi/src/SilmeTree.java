public class SilmeTree {

    Node3 root;

    public SilmeTree()
    {
       root = null;
    }

    Node3 newNode(int x)
    {
        root = new Node3(x);
        return root;
    }

    Node3 insert(Node3 root, int x)
    {
        if (root != null)
        {
            if (x < root.data)
                root.left = insert(root.left, x);
            else
                root.right = insert(root.right, x);
        }
        else
            root = newNode(x);

        return root;
    }


    void inOrder(Node3 root)
    {
        if (root!=null)
        {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);

        }

    }


    Node3 delete(Node3 root, int x) {
        if (root == null) {
            return null; // Eğer ağaç boşsa, hiçbir şey yapma
        }

        if (x < root.data) {
            // Silinecek değer, sol alt ağaçta bulunuyor
            root.left = delete(root.left, x);
        } else if (x > root.data) {
            // Silinecek değer, sağ alt ağaçta bulunuyor
            root.right = delete(root.right, x);
        } else {
            // Silinecek değer bulundu
            if (root.left == null && root.right == null) {
                // Düğüm yaprak düğümse, direkt olarak silinir
                root = null;
            } else if (root.left == null) {
                // Sadece sağ çocuk varsa, sağ çocuk ile değiştirilir
                root = root.right;
            } else if (root.right == null) {
                // Sadece sol çocuk varsa, sol çocuk ile değiştirilir
                root = root.left;
            } else {
                // Hem sol hem de sağ çocuk varsa
                // Sağ alt ağaçta en küçük elemanı bulup, onu kök yerine koyabiliriz
                Node3 t1 = root.right;
                while (t1.left != null) {
                    t1 = t1.left;
                }

                // En küçük eleman sağ alt ağaçtadır, onu kök yerine koyacağız
                root.data = t1.data;
                // Bu elemanı silmek için sağ alt ağacı tekrar güncelleriz
                root.right = delete(root.right, t1.data);
            }
        }
        return root;
    }

}
