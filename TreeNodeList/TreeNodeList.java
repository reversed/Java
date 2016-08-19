// Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth 
// (eg, if you have a tree with depth D, you’ll have D linked lists).
import java.util.Hashtable;
import java.util.LinkedList;

public class TreeNodeList
{
    static Hashtable<Integer, LinkedList<Integer>> ltable = new Hashtable<Integer, LinkedList<Integer>>();
    
    public static void build(Node n)
    {
        LinkedList<Node> q1 = new LinkedList<Node>();
        LinkedList<Integer> q2 = new LinkedList<Integer>();

        Node cur;
        int dep;
        LinkedList<Integer> lst;

        q1.addFirst(n);
        q2.addFirst(0);
        
        while (!q1.isEmpty())
        {
            cur = q1.removeFirst();
            dep = q2.removeFirst();
            
            if (ltable.get(dep) == null)
            {
                lst = new LinkedList<Integer>();
                lst.add(cur.data);
                ltable.put(dep, lst);
            }
            else
            {
                lst = ltable.get(dep);
                lst.add(cur.data);
            }

            if (cur.left != null)
            {
                q1.addFirst(cur.left);
                q2.addFirst(dep + 1);
            }
            if (cur.right != null)
            {
                q1.addFirst(cur.right);
                q2.addFirst(dep + 1);
            }
        }
    }
    
    public static void print()
    {
        System.out.println("Print each level of the tree: ");
        for (int i = 0; i < ltable.size(); i++)
        {
            LinkedList<Integer> lst;
            if (ltable.get(i) != null)
            {
                lst = ltable.get(i);
                
                for (int j = 0; j < lst.size(); j++)
                {
                    System.out.print(lst.get(j) + " ");
                }
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        
        MinHeight.build(arr);
        MinHeight.print();
        
        TreeNodeList.build(MinHeight.root);
        TreeNodeList.print();
    }
}
