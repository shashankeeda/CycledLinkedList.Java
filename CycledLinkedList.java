import java.util.HashMap;

//This is the class CycleLinkedList<E> which has a data member of Node head and a size variable
public class CycledLinkedList<E> {
    Node<E> head;
    int size;
//This is the constructor that is used to create the head node and increment the size
    public CycledLinkedList(E node) {
        Node<E> x = new Node(node);
        head = x;
        size++;
    }
//This is the add fucntion which is used to add a node to the end of the linkedlist and increment the size
    public void add(E Node){
        Node<E> curr=head;
        while(curr.next!=null)
            curr=curr.next;
        Node<E> x=new Node(Node);
        curr.next=x;
        size++;
    }
//This is the main function that is used that returns the index of the start of a cycle in a linkedlist
    public int detectLoop(Node<E> temp) {
        HashMap<Node, Integer> hs = new HashMap<Node, Integer>();
        int i = 0;
        while (temp != null) {

            if (hs.containsKey(temp)) {
                return hs.get(temp);
            }
            hs.put(temp, i);

            temp = temp.next;
            i++;
        }
        return -1;
    }
//This function creates a looped linked for us at the index you choose to put it at
    public void loop(int loopindex){
        int i=0;
        Node<E> t=head;
        if(loopindex<=size && loopindex>=0) {
            while (i < loopindex) {
                t = t.next;
                i++;
            }
            Node<E> curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = t;
        }
        else{
            System.out.println("Invalid index");
        }
    }
    //THis function prints out the linkedlist for us, not the looped linked list
    public void print(){
        Node<E> curr=head;
        while(curr!=null){
            if(curr.next!=null)
                System.out.print(curr.value+"->");
            else
                System.out.print(curr.value);
            curr=curr.next;
        }
        System.out.println();
    }
    //This is the class used to create the nodes
    private class Node<E> {
        E value;
        Node<E> next;
        public Node(E val) {
            value = val;
            next = null;
        }
    }
    public static void main(String[] args){
        //The constructor and add functions are just adding nodes
        CycledLinkedList<Integer> linkedList=new CycledLinkedList<Integer>(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.print();
        //The loop function is looping at the index you specify
        linkedList.loop(5);
        //The detectLoop function will find the index it loops at if there is any.
        if(linkedList.detectLoop(linkedList.head)!=-1)
            System.out.println("Cycle starts at index "+linkedList.detectLoop(linkedList.head));
        else
            System.out.println(linkedList.detectLoop(linkedList.head));
    }
}

