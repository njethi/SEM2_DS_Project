import java.util.*;
class DoublyLinkedList
{
    class Node
    {
        int data;
        Node next;
        Node prev;
        Node(int data)
        {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

   

    Node first = null;

    void insertAtLast(int data)
    {
        Node n = new Node(data);
        if(first==null)
        {
            first = n;
        }
        else
        {
            Node temp = first;
            while(temp.next!=null)
            {
                temp = temp.next;
            }
            temp.next = n;
            n.prev = temp;
        }
    }



    void insertAtFirst(int data)
    {
        Node n = new Node(data);
        if(first==null)
        {
            first = n;
        }
        else
        {
            n.next = first;
            first.prev = n;
            first = first.prev;
        }
    }

    void display()
    {
        if(first==null)
        {
            System.out.println("Empty");
        }
        else
        {
            Node temp = first;
            System.out.println("Display From First");
            do
            {
                System.out.println(temp.data);
                temp = temp.next;
            }while(temp!=null);
        }
    }

    void deleteAtFirst()
    {
        if(first==null)
        {
            System.out.println("Empty");
        }
        else if(first.next==null)
        {
            first=null;
        }
        else
        {
            first = first.next;
            first.prev.next = null;
            first.prev = null;
        }
    }

    Node deleteNode(Node head_ref, Node del)
    {
        if (head_ref == null || del == null)
        {
            return null;
        }
            
        if (head_ref == del)
        {
            deleteAtFirst();
        }
            
        if (del.next != null)
        {
             del.next.prev = del.prev;
        }
    
        if (del.prev != null)
        {
            del.prev.next = del.next;
        }
    
        return head_ref;
    }
 
    void  deletesmallerNodes(int K)
    {
        Node ptr = first;
        Node next;
    
        while (ptr != null)
        {
            next = ptr.next;
            if (ptr.data < K)
            {
		        deleteNode(first, ptr);
            }
            ptr = next;
        }
    }
}
class Project{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList dl = new DoublyLinkedList();
        int ch;
        int n;
        int pn;
        do
        {
            System.out.println("Enter Your Choice");
            System.out.println("1.InsertAtLast 2.Display 3.Exit 4.InsertAtFirst 5.DeleteAllNumbersBeforeParticularNumber");
            ch = sc.nextInt();
            switch(ch)
            {
                case 1:
                System.out.println("Enter Number");
                n = sc.nextInt();
                dl.insertAtLast(n);
                break;

                case 2:
                dl.display();
                break;

                case 3:
                break;

                case 4:
                System.out.println("Enter Number");
                n = sc.nextInt();
                dl.insertAtFirst(n);
                break;

                case 5:
                System.out.println("Enter Value");
                pn = sc.nextInt();
                dl.deletesmallerNodes(pn);
                break;

                default:
                System.out.println("Enter Valid Choice");
                break;
            }
        }while(ch!=3);
    }    
}
