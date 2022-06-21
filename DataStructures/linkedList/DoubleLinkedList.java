package DataStructures.linkedList;

public class DoubleLinkedList {
    DNode head;
    DNode deleteNode(DNode head,int x)
    {
    	DNode temp = head;
    	if(x==1){
    	    head = head.next;
    	    return head;
    	}
    	while(x--!=1)
    	   temp = temp.next;
    	
       temp.prev.next = temp.next;
    	return head;
    }

    public DNode reverseDLL(DNode  head)
    {
        DNode next=null,curr=head;
        while(curr!=null){
                next = curr.prev;
                curr.prev = curr.next;
                curr.next = next;
                curr = curr.prev;
        }
        if (next != null) 
            head = next.prev;
        return head;
    }
}
