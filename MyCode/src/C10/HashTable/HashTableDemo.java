package C10.HashTable;

import java.util.Scanner;

/**
 * @author alario
 */
public class HashTableDemo {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        Table t =new Table(5);
        while(true){
            System.out.println("add    增加");
            System.out.println("search 查找");
            System.out.println("del    删除");
            System.out.println("show   遍历");
            String  input = sc.next();
            switch (input){
                case "add":
                    System.out.println("输入id");
                    int id=sc.nextInt();
                    System.out.println("输入姓名");
                    String name=sc.next();
                    t.add(id,name);
                    break;
                case "search":
                    System.out.println("输入查找id");
                    id=sc.nextInt();
                    t.search(id);
                    break;
                case "del":
                    System.out.println("输入删除id");
                    id=sc.nextInt();
                    t.delete(id);
                    break;
                case "show":
                    t.show();
                    break;
                case "exit":
                    sc.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
class Person{
    public int id;
    public String name;
    public Person next;

    public Person(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
class Table {
    private PerLinkedList[] table;
    private int size;
    //构造并初始化
    public Table(int size) {
        this.size=size;
        table=new PerLinkedList[size];
        //初始化
        for(int i=0;i<size;i++){
            table[i]=new PerLinkedList(new Person(-1,"head"));
        }
    }

    //散列函数
    public int hashFun(int id){
        return id%size;
    }

    //增加
    public void add(int id,String name){
        int n= hashFun(id);
        Person p=new Person(id,name);
        table[n].listAdd(p);
    }

    //查找
    public void search(int key){
        int n= hashFun(key);
        table[n].listSearch(key);
    }
    //删除
    public void delete(int key){
        int n= hashFun(key);
        table[n].listDelete(key);
    }
    //遍历
    public void show(){
        for(int i=0;i<size;i++){
            System.out.print("链表"+(i+1)+":");
            table[i].listShow();
            System.out.println("");
        }
    }
}
class PerLinkedList{
    private  Person head;

    public PerLinkedList(Person head) {
        this.head = head;
    }

    //增加
    public void listAdd(Person p){
        if(head==null){
            head.next=p;
            return;
        }
        Person temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=p;
        System.out.println("增加成功");
    }
    //查找
    public Person listSearch(int key){
        if(head==null){
            System.out.println("链表为空");
            return null;
        }
        Person temp =head;
        while(temp.next!=null) {
            if(temp.next.id==key){
                System.out.println("id"+key+"信息："+temp.next);
                return temp.next;
            }
        }
        System.out.println("没有找到id:"+key);
        return null;
    }
    //删除
    public void listDelete(int key){
        if(head==null){
            System.out.println("链表为空");
            return;
        }
        Person temp=head;
        Person del=head.next;
        while(del!=null){
            if(del.id==key){
                temp.next=del.next;
                System.out.println("成功删除id:"+key);
                return;
            }
            temp=del;
            del=del.next;
        }
        System.out.println("没有找到id:"+key);
    }
    //遍历
    public void listShow(){
        if(head==null){
            System.out.println("链表为空");
            return;
        }
        Person temp=head;
        while(temp.next!=null){
            System.out.print(temp.next+" ");
            temp=temp.next;
        }
    }
}
