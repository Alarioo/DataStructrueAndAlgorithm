package C02.ArrayQueue;

import java.util.Scanner;

public class CircleQueueTest {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        // 创建一个环形队列
        CircleQueue cq=new CircleQueue();
        //用loop决定外循环
        boolean loop=true;
        while(loop){
            System.out.println("请选择操作");
            System.out.println("c(create): 创建新队列");
            System.out.println("s(show): 显示队列信息");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            Character key=sc.next().charAt(0);  //取第0个字符转成CHAR
            switch (key){
                case 'c':
                    System.out.println("请输入数组最大容量");
                    int Maxsize=sc.nextInt();
                    //sc.nextLine();   如果 上面为Character key=sc.nextLine().charAt(0); 回收回车；
                    cq=new CircleQueue(Maxsize);
                    break;                                 //记得break 否则会击穿
                case 's':
                    try{                                //try catch 报错后程序不会退出
                        cq.show();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 'e':
                    sc.close();
                    loop=false;
                    break;
                case 'a':
                    try{
                        System.out.println("请输入整数");
                        int data=sc.nextInt();
                       // sc.nextLine();
                        cq.add(data);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 'g':
                    try{
                        System.out.printf("取出的数据是%d\n",cq.poll());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try{
                        System.out.printf("队列头的数据是%d\n",cq.head());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
            }
        }

    }

}
class CircleQueue{
    private int maxsize;
    public int front=0;   //指向当前队列第一位
    public int rear=0;       //指向尾部+1位
    private int[] arr;
    //创建构造器
    public  CircleQueue(){
    }
    public CircleQueue(int Maxsize){
        maxsize=Maxsize+1;
        arr=new int[maxsize];     //队列中有一位是空的 便于区分队列空front=rear 和 队列满(rear+1)%maxsize=front
    }
    //判断是否为空
    public boolean isEmpty(){
        /*当front再次追上rear时队列为空
        不存在rear追上front的情况，因为会先满足isFull条件使队列无法增加
         */
        if(rear==front){
            return true;
        }else{
            return false;
        }
    }
    //判断是否满
    public boolean isFull(){
        /*
        当front与rear距离为maxsize时队列为满
        情况1：front<rear 当且仅当front指向0而rear=Maxsize队列慢的情况
        情况2：front>rear front与rear之间有maxsize个数据,
        可写成 1.(rear+1)%maxsize==front
              2.(rear+maxsize-front)%maxsize=maxsize
        */
        if((rear+1)%maxsize==front){
            return true;
        }else{
            return false;
        }
    }
    //增加队列数据
    public  void add(int data) {
        if (isFull()) {
            throw new RuntimeException("队列已满");                 //抛出错误
        }
        arr[rear] = data;
        rear=(rear+1)%maxsize;      // rear+1为0到maxsize中的数，但不会对队列中的maxsize位操作即rear!=maxsize
    }
    //取出队列数据
    public int poll(){
        if(isEmpty()){
            throw new RuntimeException("队列已空");
        }
        int ret=arr[front];
        front=(front+1)%maxsize;
        return  ret;
    }
    //队列数据量
    public int getSum(){
        return (rear+maxsize-front)%maxsize;
    }
    //显示队列信息
    public void show(){
        if(isEmpty()){
            throw new RuntimeException("队列已空");
        }
        int sum=getSum();
        System.out.println("队列中有"+sum+"个数");
        int point=front;
        for (int i = front; i < front + getSum() ; i++) {
            System.out.printf("arr[%d]=%d\n", i % maxsize, arr[i % maxsize]);
        }
        /*        for(int i=0;i<sum;i++){
            System.out.printf("arr[%d]=%d\n", i, arr[point]);
            point=(point+1)%maxsize;
        }*/
    }
    //显示头数据
    public int head(){
        if(isEmpty()){
            throw new RuntimeException("队列已空");
        }
        return arr[front];
    }
}

