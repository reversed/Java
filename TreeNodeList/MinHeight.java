// Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height.

public class MinHeight
{
    static Node root;
    
    static Node buildTree(int[] arr, int low, int high)
    {
        if (low > high) return null;
        
        int mid = (low + high) / 2;
        
        Node n = new Node(arr[mid]);
        
        n.left = buildTree(arr, low, mid - 1);
        n.right = buildTree(arr, mid + 1, high);
        return n;
    }
    
    public static void build(int[] arr)
    {
        root = buildTree(arr, 0, arr.length - 1);
    }
    
    public static void printTree(Node n)
    {
        if (n == null) return;
        
        System.out.print(n.data + " ");
        printTree(n.left);
        printTree(n.right);
    }
    
    public static void print()
    {
        printTree(root);
        System.out.println();
    }
    
    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        
        MinHeight.build(arr);
        MinHeight.print();
    }
}

