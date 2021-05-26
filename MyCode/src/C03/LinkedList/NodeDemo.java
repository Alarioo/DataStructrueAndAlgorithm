package C03.LinkedList;

public class NodeDemo {
    public static void main(String[] args) {
        LinkedList llm=new LinkedList();
        llm.addorder(new Node(1,"a",null));
        llm.addorder(new Node(3,"c",null));
        llm.addorder(new Node(2,"b",null));
        llm.show();
        llm.update(new Node(2,"bb",null));
        llm.show();
        llm.delete(3);
        llm.show();
    }
}
