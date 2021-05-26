package C04.BidirLinkedList;

public class BidirLinkedList {
    Node2 head=new Node2(0,"",null,null);
    Node2 tear;
    Node2 temp;
    //尾部增加
    public void addtear(Node2 node){
/*        if(head.next==null){
            head.next=node;
            return;
        }*/
        temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
        node.pre=temp;
        tear=node;
    }
    //顺序增加
    public void addorder(Node2 node){
        temp=head;
        while(true){
            if(temp.next==null){
                temp.next=node;
                node.pre=temp;
                tear=node;
                break;
            }else if(node.getNo()<temp.next.getNo()){
                node.pre=temp;
                node.next=temp.next;
                temp.next=node;
                node.next.pre=node; //第一次写错temp.next.pre
                break;
            }
            temp=temp.next;
        }
    }
    //修改节点
    public void update(Node2 node){
        temp=head;
        while(temp!=null){
            if(temp.getNo()== node.getNo()){
                temp.setName(node.getName());
                System.out.println("修改成功---------------");
                return;
            }
            temp=temp.next;
        }
        System.out.println("无该编号节点--------------");
    }
    //删除节点
    public void delete(int no){
        if(head.next==null){
            System.out.println("链表空-----------------");
            return;
        }
        temp=head.next;
        while(temp!=null){
            if(temp.getNo()== no){
                if(temp.next==null){
                    temp.pre.next=null;
                    tear=temp.pre;
                    return;
                }
                temp.pre.next=temp.next;
                temp.next.pre=temp.pre;
                System.out.println("删除成功------------------");
                return;
            }
            temp=temp.next;
        }
        System.out.println("无该编号节点--------------");
    }
    //遍历
    public void show(){
        if(head.next==null){
            System.out.println("链表空--------------");
            return;
        }
        System.out.println("正向遍历---------------");
        temp=head.next;
        while(temp!=null){
            System.out.println(temp);
            temp=temp.next;
        }
    }
    //反向遍历
    public  void reverseShow(){
        if(head.next==null){
            System.out.println("链表空---------------");
            return;
        }
        System.out.println("反向遍历--------------");
        temp=tear;
        while(temp!=head){
            System.out.println(temp);
            temp=temp.pre;
        }
    }
}
