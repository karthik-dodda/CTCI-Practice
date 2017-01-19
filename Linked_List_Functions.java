import java.util.*;
public class Linked_List_Function {
    
    public void implement(){
        Node n = new Node(11);
        n.appendToEnd(2);
        n.appendToEnd(3);
        n.appendToEnd(1);
        n.appendToEnd(31);
        n.appendToEnd(21);
        n.appendToEnd(22);
        displayNode(n);
        Node m = RemoveDups(n);
        displayNode(m);
        m = RemoveDups(n);
        displayNode(m);
        System.out.println(kLast(n,2));
        System.out.println(kLast(n,3));
        System.out.println(kLast1(n,2));
        System.out.println(kLast1(n,3));
        Node p =n;
        deleteMiddle(n.next.next.next);
        displayNode(n);
        displayNode(partitionByValue(p, 11));
        
        System.out.println(isPalindrome(p));
        System.out.println(isPalindrome1(p));
        
        Node k = new Node(1);
        k.appendToEnd(2);
        k.appendToEnd(3);
        k.appendToEnd(2);
        k.appendToEnd(1);
        System.out.println(isPalindrome(k));
        System.out.println(isPalindrome1(k));
    }
    
    
    public boolean isPalindrome1(Node n){
        Node slow = n;
        Node fast = n;
        Stack<Integer> st = new Stack<Integer>();
        
        while(fast!=null && fast.next!=null){
            st.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast!=null){
            slow=slow.next;
        }
        
        while(slow!=null){
            if(slow.data!=st.pop()){
                return false;
            }
            slow=slow.next;
        }
        
        return true;
    }
    
    public boolean isPalindrome(Node n){
        Node t = n;
        int count = 0;
        while(t!=null){
            t=t.next;
            count++;
        }
        
        t=n;
        int current=0;
        int total = count;
        while(current < count/2){
            int i = total-current;
            Node s = t;
            Node prev=null;
            while(i>0){
                prev=s;
                //System.out.print(i);
                s=s.next;
                i--;
            }
            s=prev;
            if(t.data!=s.data){
                return false;
            }
            
            current++;
            total--;
            t=t.next;
        }
        
        return true;
    }

    public Node partitionByValue(Node n, int v){
        Node head = n;
        Node tail = n;
        
        while(n!=null){
            Node next = n.next;
            if(n.data<v){
                n.next = head;
                head = n;
            }
            else{
                tail.next = n;
                tail = n;
            }
            n=next;
        }
        tail.next = null;
        return head;
    }

    public void deleteMiddle(Node n){
        n.data = n.next.data;
        n.next = n.next.next;
    }

    public int kLast1(Node n, int k){
        Node t1 = n;
        Node t2 = n;
        
        for(int i = 0; i<k;i++)
        {
            if(t1.next==null) return 0;
            t1=t1.next;
        }
        
        while(t1!=null){
            t1=t1.next;
            t2=t2.next;
        }
        
        return t2.data;
    }

    public int kLast(Node n, int k){
        int count = 0;
        Node t = n;
        while(t!=null){
            count++;
            t = t.next;
        }
        
        count = count-k>0?count-k:0;
        
        t=n;
        while(count>0){
            t = t.next;  
            count--;
        }
        
        return t.data;
    }

    public Node RemoveDups(Node n){
        ArrayList<Integer> arl= new ArrayList<Integer>();
        Node t = n;
        Node prev = null;
        while(t!=null){
            if(arl.contains(t.data)){
                prev.next = t.next;
                t.next = null;
                t = prev.next;
            }
            else {
                arl.add(t.data);
                prev = t;
                t = t.next;
            }
        }
        
        return n;
    }
    
    public Node RemoveDups1(Node n){
        Node t = n;
        while(t!=null){
            Node run=t;
            while(run.next!=null){
                if(run.next.data == t.data){
                    run.next = run.next.next;
                }
                else{
                    run = run.next;
                }
            }
            t= t.next;
        }
        return n;
    }

    public void displayNode(Node n){
        Node t = n;
        while(t!=null){
            System.out.print(t.data + " -> ");
            t= t.next;
        }
        System.out.print("null");
        System.out.println();
    }
    
    public static void main(String args[]) {
    	Linked_List_Function m = new Linked_List_Function();
        m.implement();
    }
    
    public class Node{
        int data;
        Node next;
        
        public Node(int d){data =d;}
        public void appendToEnd(int d){
            Node end = new Node(d);
            Node n = this;
            while(n.next!=null)n=n.next;
            n.next = end;
        }
    }
}
