public class TreeWithParent
{
    Node root;
    private int cur = 0;
    
    // Build Tree in order, '#' is for leaves.
    public void buildTree(char[] arr)
    {
        this.cur = 0;
        Node[] parent = {root};
        
        root = build(arr, parent);
    }
    
    public Node build(char[] arr, Node[] parent)
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
            Node[] p = {n};

            cur++;
            n.parent = parent[0];
            n.left = build(arr, p);
            n.right = build(arr, p);

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
            System.out.println(n.data + " parent: " + (n.parent == null ? "null" : n.parent.data));
            print(n.left);
            print(n.right);
        }
    }
    
    public Node findNode(char c)
    {
        return find(c, root);
    }
    
    public Node find(char c, Node n)
    {
        if (n == null) return null;
        
        if (n.data == c) return n;
        
        Node left = find(c, n.left);
        if (left != null) return left;
        
        Node right = find(c, n.right);
        if (right != null) return right;
        
        return null;
    }
    
    public static void main(String[] args)
    {
        String s = "ABC##DE#G##F###";
        //String s = "#";
        
        TreeWithParent t = new TreeWithParent();
        t.buildTree(s.toCharArray());
        t.printTree();
        
        char c = 'D';
        Node n = t.findNode(c);
        if (n != null)
        {
            System.out.println("Find Node " + c + ", its parent is " + n.parent.data);
        }
    }
}




