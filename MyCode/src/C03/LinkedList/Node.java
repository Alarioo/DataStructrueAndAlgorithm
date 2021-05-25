package C03.LinkedList;

public class Node {
    private int no;
    private String name;
    public Node next;
    public Node(){
    };
    public Node(int no,String name,Node next){
        this.no=no;
        this.name=name;
        this.next=next;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNodeno(){
        return no;
    }
    //重写toString
    @Override
    public String toString() {
        return "Node{" + "no=" + no + ", name=" + name  +'}';
    }
}
