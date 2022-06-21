package DataStructures.linkedList;

public class CircularLinkedList {
    Node head=null;

    void printList()
    {
         Node temp = head;
         while(temp.next!=head){
             System.out.print(temp.data+" ");
             temp = temp.next;
         }
         System.out.print(temp.data);
    }

    void splitList()
    {
        Node fast=head,slow = head;
        Node head1=null, head2=null;
        
        while(slow!=null && fast!=null &&
                fast.next!=null && fast.next!=head &&
                    fast.next.next!=head){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        while(fast.next!=head)
            fast = fast.next;
        
        fast.next = slow.next;
        
        head1 = head;
        
        head2 = slow.next;
        
        slow.next = head1;
        
    }

    public static Node sortedInsert(Node head,int data)
    {
        Node newNode = new Node(data);
        Node temp = head,prev=null;

        if(head.data>data){
            newNode.next = head;
            while(temp.next!=head)
                temp = temp.next;
            temp.next = newNode;
            head = newNode;
            return head;
        }

        while(temp!=null && temp.next!=head && temp.data<data){
            prev = temp;
            temp = temp.next;
        }
        if(temp.next == head){
            temp.next = newNode;
            newNode.next = head;
        }else{
            prev.next = newNode;
            newNode.next = temp;
        }
        return head;
    }

    boolean isCircular(Node head)
    {
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            if(head == temp)
                return true;
        }
        return false;
    }

    public Node reverse(Node head)
    {
        Node prev=null,next=null,curr=head;
        do{
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }while(curr!=head);
        
        head.next = prev;
        head = prev;
        return prev;
    }
    
    public Node deleteNode(Node head,int d)
    {
        Node prev = null, temp = head;
        if(head.data == d){
            while(temp.next !=head){
                temp = temp.next;
            }
            head = head.next;
            temp.next = head;
            return head;
        }
        while(temp.next !=head){
            if(temp.data == d)
                break;
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
        return head;
    }
}
