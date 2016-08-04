//You have two numbers represented by a linked list, where each node contains a single digit. 
//The digits are stored in reverse order, such that the 1’s digit is at the head of the list. 
//Write a function that adds the two numbers and returns the sum as a linked list.
//EXAMPLE
//Input: (3 -> 1 -> 5), (5 -> 9 -> 2)
//Output: 8 -> 0 -> 8

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
     
     public static Node AddTwoList(Node list1, Node list2, int carry)
     {
         if (list1 == null && list2 == null && carry == 0)
         {
             return null;
         }

         Node list3 = new Node(0);

         list3.data = ((list1 == null ? 0 : list1.data) + (list2 == null? 0 : list2.data) + carry) % 10;
         carry = ((list1 == null ? 0 : list1.data) + (list2 == null? 0 : list2.data) + carry) / 10;
         
         list3.next = AddTwoList(list1 == null ? null : list1.next,
                                 list2 == null ? null : list2.next, 
                                 carry);
         return list3;
     }
     
     public static Node AddTwoList2(Node list1, Node list2, int carry)
     {
         if (list1 == null && list2 == null)
         {
             return null;
         }

         Node cur = new Node(0);
         Node list3 = cur;

         cur.data = ((list1 == null ? 0 : list1.data) + (list2 == null? 0 : list2.data) + carry) % 10;
         carry = ((list1 == null ? 0 : list1.data) + (list2 == null? 0 : list2.data) + carry) / 10;
         if (list1 != null) list1 = list1.next;
         if (list2 != null) list2 = list2.next;

         while (list1 != null || list2 != null || carry != 0)
         {
             cur.next = new Node(0);
             cur = cur.next;
             cur.data = ((list1 == null ? 0 : list1.data) + (list2 == null? 0 : list2.data) + carry) % 10;
             carry = ((list1 == null ? 0 : list1.data) + (list2 == null? 0 : list2.data) + carry) / 10;
             
             if (list1 != null) list1 = list1.next;
             if (list2 != null) list2 = list2.next;
         }
         return list3;
     }
}

public class SumNodes
{
     public static void main(String[] arg)
     {
         Node list1 = new Node(0);
         list1.appendToTail(1);
         list1.appendToTail(2);
         list1.appendToTail(3);
         list1.appendToTail(4);
         list1.appendToTail(5);
         list1.printList();

         Node list2 = new Node(0);
         list2.appendToTail(1);
         list2.appendToTail(2);
         list2.appendToTail(3);
         list2.appendToTail(4);
         list2.appendToTail(5);
         list2.appendToTail(9);
         list2.appendToTail(9);
         list2.appendToTail(3);
         list2.printList();
         
         Node list3 = Node.AddTwoList2(list1, list2, 0);
         list3.printList();
     }
}