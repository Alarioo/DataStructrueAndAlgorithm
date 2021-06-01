package C05.josephu;

public class joseoguDemo {
    public static void main(String[] args) {
        CircleList cl=new CircleList();
        cl.constructCircle(5);
        cl.show();
        cl.getOut(1,2);

    }
}
class CircleList{
    public child first;
    private int size;
    //生成环队列
    public void constructCircle(int num){
        size=num;
        if (num<1){
            System.out.println(">0");
            return;
        }
        first=new child(1);
        first.next=first;
        child pointer=first;
        if (num>1){
            for(int i=2;i<=num;i++){
                pointer.next=new child(i);
                pointer=pointer.next;
                pointer.next=first;
            }
        }
        System.out.println("初始化:"+num+"---------");
    }
    //遍历
    public void show(){
        child pointer=first;
        if(pointer==null){
            System.out.println("null-----------");
        }
        System.out.println("遍历---------------");
        while (true){
            System.out.println("第"+pointer.num+"个");
            pointer=pointer.next;
            if(pointer==first){
                break;
            }
        }
    }
    //计算出圈顺序
    public void getOut(int startNo,int m){
    if(first==null||startNo<1||startNo>size){
            System.out.println("error");
        }
        System.out.println("起始："+startNo+"数："+m+"---------");
        child del=first;
        child pointer=first;
        for(int i=1;i<startNo;i++){
            del=del.next;
        }
        /*将pointer.next=del */
        while(true){
            if(pointer.next==del){
                break;
            }
            pointer=pointer.next;
        }
        while(size>1){
            for(int i=0;i<m-1;i++){
                pointer=pointer.next;
                del=del.next;
            }
            System.out.println("第"+del.num+"个出圈");
            pointer.next=del.next;
            del=pointer.next;
            size--;    // while(pointer==del)
        }//若将pointer改成first 队列内节点没有指针指向会被JVM回收
        System.out.println("第"+del.num+"个留在圈中");
    }
}
class child {
    int num;
    child next;

    public child(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public child getNext() {
        return next;
    }

    public void setNext(child next) {
        this.next = next;
    }
}