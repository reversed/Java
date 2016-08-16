class BinTree
{
    Node root;
    private int cur = 0;
    
    // Build Tree in order, '#' is for leaves.
    public void buildTree(char[] arr)
    {
        this.cur = 0;
        
        root = build(arr);
    }
    
    public Node build(char[] arr)
    {
        if (cur >= arr.length)
        {
            System.out.println("Warning, input error.");
            return null;
        }
        
        if (arr[cur] == '#')
        {
            cur++;
            return null;
        }
        else
        {
            Node n = new Node(arr[cur]);
            cur++;
            n.left = build(arr);
            n.right = build(arr);
            return n;
        }
    }
    
    public void printTree()
    {
        if (root == null)
        {
            System.out.println("Empty Tree.");
        }
        
        print(root);
    }
    
    public void print(Node n)
    {
        if (n != null)
        {
            System.out.print(n.data + " ");
            print(n.left);
            print(n.right);
        }
    }
}

class Node
{
    char data;
    Node left = null;
    Node right = null;
    
    Node(char val) { data = val; }
}

public class IsBalanced
{
    static public int maxDepth(Node n)
    {
        if (n == null)
        {
            return 0;
        }
        
        int left = maxDepth(n.left) + 1;
        int right = maxDepth(n.right) + 1;
        
        return left > right ? left : right;
    }
    
    static public int minDepth(Node n)
    {
        if (n == null)
        {
            return 0;
        }
        
        int left = minDepth(n.left) + 1;
        int right = maxDepth(n.right) + 1;
        
        return left > right ? right : left;
    }
    
    static public boolean isBalanced(BinTree t)
    {
        int maxVal = maxDepth(t.root);
        int minVal = minDepth(t.root);
        
        if (maxVal - minVal > 1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public static void main(String[] args)
    {
        //String s = "ABC##DE#G##F##H##";
        String s = "AB##C##";
        
        BinTree t = new BinTree();
        t.buildTree(s.toCharArray());
        t.printTree();
        
        boolean res = IsBalanced.isBalanced(t);
        System.out.println();
        System.out.println("Max Depth: " + IsBalanced.maxDepth(t.root));
        System.out.println("Min Depth: " + IsBalanced.minDepth(t.root));
        System.out.println("IsBalance: " + res);
    }
}














