public class CommonAnc
{
    static boolean cover(Node root, Node target)
    {
        if (root == null) return false;
        
        if (root == target) return true;
        
        return cover(root.left, target) || cover(root.right, target);
    }
    
    static public Node find(Node root, Node p, Node q)
    {
        if (root == null) return null;
        
        if (cover(root.left, p))
        {
            if (cover(root.right, q))
            {
                return root;
            }
            else
            {
                return find(root.left, p, q);
            }
        }
        
        if (cover(root.right, p))
        {
            if (cover(root.left, q))
            {
                return root;
            }
            else
            {
                return find(root.right, p, q);
            }
        }
        return null;
    }
    
    
    public static void main(String[] args)
    {
        String s = "ABC##DE#G##F##H#IJ##K##";
        //String s = "#";
        
        TreeWithParent t = new TreeWithParent();
        t.buildTree(s.toCharArray());
        t.printTree();
        
        char c1 = 'F';
        Node n1 = t.findNode(c1);
        if (n1 != null)
        {
            System.out.println("Find Node " + c1 + ", its parent is " + (n1.parent == null ? "null" : n1.parent.data));
        }

        char c2 = 'C';
        Node n2 = t.findNode(c2);
        if (n2 != null)
        {
            System.out.println("Find Node " + c2 + ", its parent is " + (n2.parent == null ? "null" : n2.parent.data));
        }
        System.out.println();
        
        Node m = CommonAnc.find(t.root, n1, n2);
        System.out.println("Find Common Ancestor " + c1 + " " + c2 + ", its Ancestor is " + (m == null ? "null" : m.data));
    }
}