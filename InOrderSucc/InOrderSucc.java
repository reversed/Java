public class InOrderSucc
{
    public static Node findSucc(Node n)
    {
        if (n == null) return null;
        
        if (n.right != null)
        {
            return findLeftMost(n.right);
        }
        else
        {
            Node e = n;
            Node p;
            while (e.parent != null)
            {
                p = e.parent;
                if (p.left == e)
                {
                    return p;
                }
                e = p;
            }
            return null;
        }
    }
    
    public static Node findLeftMost(Node n)
    {
        if (n == null) return null;
        
        while (n.left != null)
        {
            n = n.left;
        }
        return n;
    }
    
    public static void main(String[] args)
    {
        String s = "ABC##DE#G##F###";
        //String s = "#";
        
        TreeWithParent t = new TreeWithParent();
        t.buildTree(s.toCharArray());
        t.printTree();
        
        char c = 'F';
        Node n = t.findNode(c);
        if (n != null)
        {
            System.out.println("Find Node " + c + ", its parent is " + (n.parent == null ? "null" : n.parent.data));
        }
        
        System.out.println();
        Node m = InOrderSucc.findSucc(n);
        System.out.println("Find Succ " + c + ", its successor is " + (m == null ? "null" : m.data));
    }
}


