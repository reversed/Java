public class BinTree
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
    
    public static void main(String[] args)
    {
        String s = "ABC##DE#G##F###";
        //String s = "#";
        
        BinTree t = new BinTree();
        t.buildTree(s.toCharArray());
        t.printTree();
    }
}

class Node
{
    char data;
    Node left = null;
    Node right = null;
    
    Node(char val) { data = val; }
}




