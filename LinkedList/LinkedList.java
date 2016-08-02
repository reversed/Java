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
}

public class LinkedList
{
     public static void main(String[] arg)
     {
         Node list = new Node(0);
         list.appendToTail(1);
         list.appendToTail(2);
         list.appendToTail(3);
         list.appendToTail(4);
         list.appendToTail(5);
         list.printList();
         
         list = list.deleteNode(0);
         list = list.deleteNode(3);
         list.printList();
     }
}