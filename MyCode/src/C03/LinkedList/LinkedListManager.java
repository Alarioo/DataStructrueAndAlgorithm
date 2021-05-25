package C03.LinkedList;

public class LinkedListManager {
    private Node head =new Node(0,"",null);//创建头节点
    private Node temp;//创建辅助节点

    //尾部增加节点
    public void addtear(Node node){
        temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
    }

    //顺序增加节点
    public void addorder(Node node){
        temp=head;
        boolean loop=true;
        while(loop) {
            if (node.getNodeno() == temp.getNodeno()) {
                System.out.println("已存在同编号节点："+temp);
                loop=false;
            }

            if(temp.next==null||node.getNodeno()<temp.next.getNodeno()){
                node.next=temp.next;
                temp.next=node;
                loop=false;
            }
            /*    如果之前存在无序插入
                if (node.getNodeno() > temp.getNodeno()) {
                if (temp.next==null||node.getNodeno() < temp.next.getNodeno()) {
                    node.next=temp.next;
                    temp.next=node;
                    loop=false;
                }
            }*/
            temp = temp.next;
        }
    }

    //修改节点
    public void update(Node node){
        temp=head;
        while(temp.next!=null){
            if(node.getNodeno()==temp.getNodeno() ){
                temp.setName(node.getName());
                System.out.println("修改成功");
                return;
            }
            temp=temp.next;
        }
        System.out.println("链表不存在该编号节点");
    }

    //删除节点
    public void delete(int no){
        temp=head;
        while (temp.next!=null){
            if(temp.next.getNodeno()==no){
                temp.next=temp.next.next;
                System.out.println("删除成功");
                return;
            }
            temp=temp.next;
        }
        System.out.println("链表不存在该编号节点");
    }


    //输出链表信息
    public void show(){
        //判断是否空
        if(head.next==null){
            System.out.println("链表空");
            return;
        }
        //遍历输出
        temp=head.next;
        while(true){
            if(temp==null){
                break;
            }
            System.out.println(temp);
            temp=temp.next;
        }
    }

}
