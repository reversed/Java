public class SubTree
{
    public static boolean containTree(Node root1, Node root2)
    {
        if (root1 == null)
        {
            return false;
        }
        
        if (matchTree(root1, root2))
        {
            return true;
        }
        else
        {
            return containTree(root1.left, root2) || containTree(root1.right, root2);
        }
    }
    
    static boolean matchTree(Node root1, Node root2)
    {
        if (root2 == null)
        {
            return true;
        }
        
        if (root1 == null)
        {
            return false;
        }
        
        if (root1.data == root2.data)
        {
            return matchTree(root1.left, root2.left) && matchTree(root1.right, root2.right);
        }
        else
        {
            return false;
        }
    }
    
    public static void main(String[] args)
    {
        String s1 = "ABC##DE#G##F##H#IJ##K##";
        TreeWithParent t1 = new TreeWithParent();
        t1.buildTree(s1.toCharArray());
        t1.printTree();
        
        System.out.println();
        
        //String s2 = "B#DE##F##";
        String s2 = "IJ###";
        TreeWithParent t2 = new TreeWithParent();
        t2.buildTree(s2.toCharArray());
        t2.printTree();
        
        boolean res = SubTree.containTree(t1.root, t2.root);
        System.out.println("Contains tree: " + (res ? "true" : "false"));
    }
}










