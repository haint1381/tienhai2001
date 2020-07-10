package dsa_danh_sach.bai_tap.trien_khai_cac_phuong_thuc_linkedList;

public class MyLinkedList<S> {
    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    private Node head;
    private int numNodes;

    public MyLinkedList() {
    }

    public void addFirst(Object element) {
        Node temp = this.head;
        this.head = new Node(element);
        this.head.next = temp;
        numNodes++;
    }

    public void addLast(Object element) {
        Node temp = this.head;
        while ( temp.next != null ) {
            temp = temp.next;
        }
        temp.next = new Node(element);
        numNodes++;
    }

    public void add(int index, Object element) {
        Node temp = this.head;
        Node holder;
        for (int i = 0; i < index && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;
    }

    public Object get(int index) {
        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }
    public int size(){
        return numNodes;
    }
    public Object remove(int index){
        if(index<0||index>numNodes){
            throw new IllegalArgumentException("error index: "+index);
        }
        Node temp= this.head;
        Object data;
        if(index==0){
           data= temp.data;
           this.head= this.head.next;
           numNodes--;
        }else{
            for (int i=0;i<index-1&& temp.next!=null;i++){
                temp=temp.next;
            }
            data =temp.next.data;
            temp.next=temp.next.next;
            numNodes--;
        }
        return data;
    }
    public boolean remove( Object element){
        if(this.head.data.equals(element)){
            remove(0);
            return true;
        }else {
            Node temp=head;
            while ( temp.next!=null ){
                if(temp.next.data.equals(element)){
                    temp.next=temp.next.next;
                    numNodes--;
                    return true;
                }
            }
        }
        return false;
    }
    public MyLinkedList clone(){
        if(numNodes==0){
            throw new NullPointerException("null");
        }
        MyLinkedList clone= new MyLinkedList();
        Node temp=head;
        clone.addFirst((Object)temp.data);
        temp=temp.next;
        while ( temp!=null ){
            clone.addFirst((Object)temp.data);
            temp=temp.next;
        }
        return clone;
    }
    public boolean constrains(Object element){
        Node temp=head;
        while ( temp.next!=null ){
            if(temp.data.equals(element)){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
    public int indexOf(Object element){
        Node temp=head;
        for (int i=0;i<numNodes;i++){
            if(temp.getData().equals(element)){
                return i;
            }
            temp=temp.next;
        }
        return -1;
    }
    public Object getFirst(){
      return  this.head.data;
    }
    public Object getLast(){
        Node temp=head;
        for (int i=0;i<numNodes;i++){
            if(temp.next==null){
                return temp.data;
            }
            temp=temp.next;
        }
        return null;
    }
    public void clear(){
        head=null;
        numNodes=0;
    }
}
