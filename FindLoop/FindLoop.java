//Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
//DEFINITION
//Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an earlier node, 
//so as to make a loop in the linked list.
//EXAMPLE
//Input: A -> B -> C -> D -> E -> C [the same C as earlier]
//Output: C

import java.util.Hashtable;

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
     
     void buildLoopList()
     {
         Node list = this;
         
         Node n = new Node(1);
         list.next = n;
         list = list.next;
         
         n = new Node(2);
         list.next = n;
         list = list.next;
         
         // start loop here
         Node loopBegin = list;
         
         n = new Node(3);
         list.next = n;
         list = list.next;
         
         n = new Node(4);
         list.next = n;
         list = list.next;
         
         n = new Node(5);
         list.next = n;
         list = list.next;
         
         // loops
         list.next = loopBegin;
     }
     
     Node findLoopBegin()
     {
         Node n = this;
         Hashtable<Node, Boolean> table = new Hashtable<Node, Boolean>();
         
         while (n != null)
         {
             if (table.containsKey(n))
             {
                 return n;
             }
             else
             {
                 table.put(n, true);
                 n = n.next;
             }
         }
         return null;
     }
     
     Node findLoopBegin2()
     {
         Node n1 = this;
         Node n2 = this;
         
         while (n2 != null && n2.next != null)
         {
             n1 = n1.next;
             n2 = n2.next.next;
             if (n1 == n2)
             {
                 break;
             }
         }
         
         if (n2 == null || n2.next == null)
         {
             return null;
         }
         
         n1 = this;
         while (n1 != n2)
         {
             n1 = n1.next;
             n2 = n2.next;
         }
         return n2;
     }
}

public class FindLoop
{
     public static void main(String[] arg)
     {
         Node list = new Node(0);
         list.buildLoopList();
         //list.printList();

         Node list2 = new Node(0);
         list2.appendToTail(1);
         list2.appendToTail(2);
         list2.appendToTail(3);
         list2.appendToTail(4);
         list2.appendToTail(5);
         list2.printList();

         Node res = list.findLoopBegin2();
         if (res != null)
         {
             System.out.println("Loop begins: " + res.data);
         }
         else
         {
             System.out.println("No loops found.");
         }
     }
}