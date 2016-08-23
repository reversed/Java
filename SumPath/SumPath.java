import java.util.ArrayList;
import java.util.LinkedList;

public class SumPath
{
    static void run(Node n, int sum)
    {
        ArrayList<Integer> lst = new ArrayList<Integer>();
        find(n, sum, lst, 0);
    }
    
    static void find(Node n, int sum, ArrayList<Integer> lst, int lev)
    {
        if (n == null) return;
        
        lst.add(n.data);
        
        tryPrint(sum, lst, lev);
        
        @SuppressWarnings("unchecked")
        ArrayList<Integer> c1 = (ArrayList<Integer>)lst.clone();
        @SuppressWarnings("unchecked")
        ArrayList<Integer> c2 = (ArrayList<Integer>)lst.clone();
        
        find(n.left, sum, c1, lev + 1);
        find(n.right, sum, c2, lev + 1);
    }
    
    static void tryPrint(int sum, ArrayList<Integer> lst, int lev)
    {
        int val = 0;
        for (int i = lev; i >= 0; i--)
        {
            val += lst.get(i);
            
            if (val == sum)
            {
                for (int j = i; j <= lev; j++)
                {
                    System.out.print(lst.get(j) + " ");
                }
                System.out.println();
            }
        }
    }
    
    public static void main(String[] args)
    {
        int arr[] = {1, 0, -2, 2, 3, 1, 4, 2, 3, -1, -2, 0, -3, 1, -2};
        
        BinTree t = new BinTree();
        t.build(arr);
        t.print();
        
        SumPath.run(t.root, 3);
    }
}

class Node
{
    int data;
    Node left, right;
    
    Node (int val) { data = val; }
}

class BinTree
{
    public Node root;
    
    public void build(int[] arr)
    {
        int cur = 0;
        
        if (arr.length == 0) return;
        
        root = new Node(arr[cur]);
        LinkedList<Node> lst = new LinkedList<Node>();
        
        lst.add(root);
        cur++;
        
        while(cur < arr.length)
        {
            Node n = lst.remove();

            n.left = new Node(arr[cur]);
            lst.add(n.left);
            cur++;
            
            if (cur < arr.length)
            {
                n.right = new Node(arr[cur]);
                lst.add(n.right);
                cur++;
            }
        }
    }
    
    public void print()
    {
        print2(root);
        System.out.println();
    }
    
    void print2(Node n)
    {
        if (n == null) return;
        
        System.out.print(n.data + " ");
        print2(n.left);
        print2(n.right);
    }
}










