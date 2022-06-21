package DataStructures.linkedList;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Stack;



public class LinkedList {
    Node head = null;

    Node insertAtBeginning(int x)
    {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
        return head;
    }
    Node insertAtEnd(int x)
    {
        Node newNode = new Node(x);
        Node temp = head;
        if(head==null){
            head = newNode;
            return head;
        }

        while(temp.next!=null)
            temp = temp.next;
        temp.next = newNode;
        return head;
        
    }

    Node deleteNode(int x)
    {
    	Node temp = head,prev=null;
    	int i = 1;
    	if(x==1){
    	    head = head.next;
    	   return head;
    	}
    	while(i<=x){
    	    if(i==x)
    	        break;
    	    i++;
    	   prev = temp;
    	   temp = temp.next;
    	}
    	prev.next = temp.next;
    	return head;
    }

    int getLenght(){
        int count = 0;
        Node temp = head;

        while(temp.next!=null){
            temp= temp.next;
            count++;
        }
        return  count;
    }

    public boolean search(int x)
    {
        Node current = head;    //Initialize current
        while (current != null)
        {
            if (current.data == x)
                return true;    //data found
            current = current.next;
        }
        return false;    //data not found
    }

    public static int getNth(Node node, int ind)
    {
        int i=1;
            while(node!=null){
                if(i==ind)
                    return node.data;
                i++;
                node = node.next;
            }
            return -1;
    }

    int getNthFromLast(Node head, int n)
    {
        Node temp = head;
        int len = 0;
        while(temp!=null){
            temp = temp.next;
            len++;
        }
        if(len<n)
            return -1;
        for(int i =0;i<len-n;i++)
            head = head.next;
        return head.data;
    }

    int getMiddle(Node head)
    {
        Node temp = head,temp1 = head;
        while(temp1!=null && temp1.next!=null){
            temp = temp.next;
            temp1=temp1.next.next;
        }
        return temp.data;
    }

    Node detectLoop(){
        Node slow=head,fast=head;
        while(slow!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast =fast.next.next;
            if(slow==fast)
                return slow;
        }
        return null;
    }

    int countNodesinLoop(Node head)
    {
        Node node = detectLoop();
        int count = 0;
        if(node == null)
            return count;
        count = 1;
        Node slow= node.next;
        while(slow!=node){
            slow = slow.next;
            count++;
        }
        return count;
    }

    boolean isPalindrome() 
    {
        Stack<Integer> st =new Stack<Integer>();
        Node temp = head;
        int n =0;
        while(temp!=null)
        {
            n++;
            temp=temp.next;
        }
        
        int i =0;
        temp = head;
        while(i<n/2)
        {
            st.push(temp.data);
            temp=temp.next;
            i++;
        }
        if(n%2==1)
            temp=temp.next;
        while(temp!=null)
        {
            if(st.pop()!=temp.data)
                return false;
            temp=temp.next;
        }
        return true;
    } 
    Node removeDuplicatesSorted()
    {
	    Node prev=head,curr=null;
	    if(head==null)
	        return head;
	   curr = head.next;
	    while(curr!=null){
	        if(prev.data==curr.data){
	            prev.next = curr.next;
	            curr=curr.next;
	        }else{
	            prev = prev.next;
	            curr= curr.next;
	        }
	    }
	    return head;
    }

    public Node removeDuplicatesUnSorted() 
    {
        LinkedHashSet<Integer> hs = new LinkedHashSet<Integer>();
        Node temp = head;
        while(temp!= null){
            hs.add(temp.data);
            temp = temp.next;
        }
        temp = head;
        Node prev=null;
        Iterator<Integer> it = hs.iterator();
        while(it.hasNext()){
            temp.data = it.next();
            prev = temp;
            temp = temp.next;
            
        }
        prev.next = null;
        return head;
    }

    // common elements between linkedlist
    public static Node findIntersection(Node head1, Node head2)
    {
       Node res = null,temp=res;
       
       while(head1!=null && head2!=null){
           if(head1.data == head2.data){
                Node newNode = new Node(head1.data);
                if(res==null){
                    res = newNode;
                    temp = res;
                }
                else{
                    temp.next = newNode;
                    temp = temp.next;
                }
                head1 = head1.next;
                head2 = head2.next;
           }else if (head1.data>head2.data){
               head2 = head2.next;
           }else
                head1 = head1.next;
       }
       return res;
    }

    // intersection point of two linked lists.
    int intersectPoint(Node head1, Node head2)
	{
        Stack<Node> s1= new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        
        while(head1!=null){
            s1.push(head1);
            head1 = head1.next;
        }
        while(head2!=null){
            s2.push(head2);
            head2 = head2.next;
        }
        int res=-1;
        while(!s1.isEmpty() && !s2.isEmpty()){
            if(s1.peek()!=s2.peek()){
                return res;
            }
            res = s1.peek().data;
            s1.pop();
            s2.pop();
        }
        return res;
	}


    Node divide(int N, Node head){
        Node even=null,odd=null,start=null,oddStart=null;
        if(head==null)
            return head;
        while(head!=null){
            if(head.data%2==0)
                if(even==null){
                    even=new Node(head.data);
                    start = even;
                }
                else{
                    even.next = new Node(head.data);
                    even = even.next;
                }
            else
                if(odd==null){
                    odd = new Node(head.data);
                    oddStart = odd;
                }
                else{
                    odd.next = new Node(head.data);
                    odd = odd.next;
                }
            head = head.next;
        }
        if(even!=null)
        even.next = oddStart;
        else
        start = oddStart;
        return start;
    }

    Node reverseList()
    {
        Node prev=null,next=null,curr=head;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    static Node addTwoLists(Node first, Node second){
        
        Stack<Node> st1 = new Stack<Node>();
        Stack<Node> st2 = new Stack<Node>();
        int carry = 0;
        while(first!=null){
            st1.push(first);
            first = first.next;
        }
        
        while(second!=null){
            st2.push(second);
            second = second.next;
        }
        
        Node head=null,newNode=null;
        int res=0;
        
        
        while(!st1.isEmpty() && !st2.isEmpty()){
           Node a = st1.pop();
           Node b = st2.pop();
             
            res = a.data+b.data+carry;
              
            if(res>=10){
              carry = res/10;
              res = res%10;
            }else
              carry = 0;
            
            newNode = new Node(res);
            if(head==null){
                head = newNode;
            }else{
                newNode.next = head;
                head = newNode;
            }
            
        }
        
        res = 0;
        while(!st1.isEmpty()){
            Node a = st1.pop();
            res =  a.data;
            if(carry!=0){
              res = res+carry;
              if(res>=10){
                  carry = res/10;
                  res = res%10;
              }else
                  carry = 0;
           }
            newNode = new Node(res);
            newNode.next = head;
            head = newNode;
            
        }
        res = 0;
      while(!st2.isEmpty()){
            Node a = st2.pop();
            res =  a.data;
            if(carry!=0){
              res = res+carry;
              if(res>=10){
                  carry = res/10;
                  res = res%10;
              }else
                  carry = 0;
           }
            newNode = new Node(res);
            newNode.next = head;
            head = newNode;
            
        }
        if(carry!=0){
                          newNode = new Node(carry);
            newNode.next = head;
            head = newNode;
        }
      return head;
  }

  // add one to the linked list.
  public static Node addOne(Node head) 
  {
       Node carry = new Node(0);
       carry = one(head,carry);
       if(carry.data!=0){
          carry.next = head;
          head = carry;
       }
      return head;
  }
  
  private static Node one(Node head,Node carry){
       if(head==null)
          return carry;
      carry = one(head.next,carry);
      
      if(head.next ==null)
          head.data+=1;
      
      if(carry.data==1)
          head.data = head.data+1;
      if(head.data>9){
          carry.data = 1;
          head.data = head.data%10;
      }else
          carry.data = 0;
      return carry;
  }
}
