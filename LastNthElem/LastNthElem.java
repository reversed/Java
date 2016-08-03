class Node
{
     Node next = null;
     int data;
     
     public Node(int d) { data = d; }
     
     void appendToTail(int d)
     {
         Node end = new Node(d);
         Node n = this;
         while (n.next != null)
         {
             n = n.next;
         }
         n.next = end;
     }
     
     Node deleteNode(int d)
     {
         Node n = this;
         
         // first node
         if (n.data == d)
         {
             return n.next;
         }
         
         while (n.next != null)
         {
             if (n.next.data == d)
             {
                 n.next = n.next.next;
                 return this;
             }
             n = n.next;
         }
         return this;
     }
     
     void printList()
     {
         Node head = this;
         
         System.out.print("List: ");
         while (head != null)
         {
             System.out.print(head.data + " ");
             head = head.next;
         }
         System.out.println("");
     }

    Node FindLastNth(Node n, int nth, int tmp[])
    {
        if (nth < 1) return null;
        
        if (n == null) return null;
        
        Node ret = FindLastNth(n.next, nth, tmp);
        
        tmp[0]++;
        if (nth == tmp[0])
        {
            return n;
        }
        return ret;
    }
    
    Node FindLastNth2(Node n, int nth)
    {
        if (n == null || nth < 1) return null;
        
        Node left = n;
        Node right = n;
        
        while (nth > 1)
        {
            if (right.next != null)
            {
                right = right.next;
                nth--;
            }
            else
            {
                return null;
            }
        }
        
        while (right.next != null)
        {
            left = left.next;
            right = right.next;
        }
        return left;
    }
}



public class LastNthElem
{
     public static void main(String[] arg)
     {
         Node list = new Node(0);
         list.appendToTail(1);
         list.appendToTail(2);
         list.appendToTail(3);
         list.appendToTail(4);
         list.appendToTail(5);
         list.appendToTail(6);
         list.appendToTail(7);
         list.appendToTail(8);
         list.appendToTail(9);
         list.printList();
         
         //int[] tmp = {0};
         int nth = 7;
         //Node res = list.FindLastNth(list, nth, tmp);
         Node res = list.FindLastNth2(list, nth);
         if (res != null)
         {
             System.out.println("Find Last "+ nth + "th: " + res.data);
         }
         else
         {
             System.out.println("Find Last "+ nth + "th: " + "No found.");
         }
     }
}