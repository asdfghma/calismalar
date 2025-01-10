public class BTree2 {

    Node2 root;

    public BTree2()
    {
        root = null;
    }

    Node2 newNode(int data)
    {
        root = new Node2(data);
        return root;
    }

    Node2 insert(Node2 root, int data)
    {
        if (root != null)
        {
            if (data < root.data)
            {
                root.left = insert(root.left, data);
            }
            else
            {
                root.right = insert(root.right, data);
            }
        }
        else
            root = newNode(data);
        return root;
    }

    void preOrder(Node2 root)
    {
        if (root != null)
        {
            System.out.print(root.data + " ");
            preOrder( root.left);
            preOrder( root.right);
        }
    }

    void inOrder( Node2 root)
    {
        if (root != null)
        {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    void postOrder ( Node2 root)
    {
        if (root != null)
        {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }


    int height(Node2 root)
    {
        if (root == null)
        {
            return -1;
        }
        else
        {
            int sol=0 ,sağ=0;

            sol = height(root.left);
            sağ = height( root.right);

            if (sol > sağ)
            {
                return sol+1;
            }
            else
            {
                return sağ+1;
            }
        }

    }


    int size( Node2 root)
    {
        if (root == null)
        {
            return 0;
        }
        else
        {
            return size(root.left) + 1 + size(root.right);
        }
    }








}
