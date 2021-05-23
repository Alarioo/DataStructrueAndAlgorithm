package C02.ArrayQueue;

import java.util.*;

public class JavaQueue {
    public static void main(String[] args) {
        //因为使用 offer、poll 和 peek 三个方法可以通过返回值判断操作成功与否，
        Queue<Integer> ls=new LinkedList<>();
        for (int i=0;i<3;i++){
            ls.offer(i);
        }
        System.out.println("顶部："+ls.peek());
        int size=ls.size();
        for (int i=0;i<size;i++){
            System.out.print(ls.poll()+" ");;
        }
        System.out.println("默认小顶堆");
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.offer(3);
        pq.offer(1);
        pq.offer(2);
        System.out.println(pq.poll());
        System.out.println("new COMPARATOR");
        PriorityQueue<Integer> pq2=new PriorityQueue<>((o1,o2)->o2-o1);  //lamda表达式
/*        PriorityQueue<Integer> pq2=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });*/
        pq2.offer(3);
        pq2.offer(1);
        pq2.offer(2);
        System.out.println(pq2.poll());
    }
}
