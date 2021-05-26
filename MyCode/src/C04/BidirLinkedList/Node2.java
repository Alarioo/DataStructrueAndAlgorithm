package C04.BidirLinkedList;

public class Node2 {
    private int no;
    private String name;
    public  Node2 pre;
    public  Node2 next;

    public Node2(int no, String name, Node2 pre, Node2 next) {
        this.no = no;
        this.name = name;
        this.pre = pre;
        this.next = next;
    }

    public int getNo() {
        return no;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node2{" + "no=" + no + ", name='" + name  + '}';
    }
}
