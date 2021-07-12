package C08.sortAlgorithm;


import java.util.Arrays;
import java.util.Date;

/**
 * @author alario
 * @Date 2021/7/2 14:37
 */
public class ASortAlgorithm {
    public static void main(String[] args) {
        int size=20;       //排序数组大小
        int[] arr=new int[size];
        //int[] arr={615,1511,1219,417,1260,617,974,1701,487,1687,1976,165,301,631,1514,1064,168,440,484,1956};
        //随机生成数组
        for (int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*size*100);
        }
        int[] order;
        //冒泡排序
/*       order=BubbleSort.sort(arr);
        show(arr,order);
        //选择排序
       order=SelectSort.sort(arr);
        show(arr,order);
        //插入排序
        order=InsertionSort.sort(arr);
        show(arr,order);
        //希尔排序
        order=ShellSort.swapSort(arr);
        show(arr,order);
        order=ShellSort.shiftSort(arr);
        show(arr,order);
        //快速排序
        show(arr);
        QuickSort.sort(arr,0, arr.length-1);
        show(arr);*/
        //归并排序
        show(arr);
        order=MergerSort.sort(arr);
        show(arr,order);
        }
    public static void show(int[] ... arrs){
        System.out.println("输出数组：");
        for (int[] arr:arrs){
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println("");
        }
    }
}
class BubbleSort {
    public static int[] sort(int[] arr){
        long start=System.currentTimeMillis();
        int[] order= Arrays.copyOf(arr,arr.length);
        int m=order.length;
        if(m!=1){
            for(int i=0;i<m-1;i++) {
                boolean flag=false;  //若某次循环没有变更提前退出
                for (int j = m - 1; j > i ; j--) {
                    if(order[j]<order[j-1]){
                        int temp=order[j-1];
                        order[j-1]=order[j];
                        order[j]=temp;
                        flag=true;
                    }
                }
                if(!flag){
                    break;
                }
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("冒泡排序用时"+((end-start)/1000)+"秒");
        return order;
    }
}
class SelectSort{
    public static int[] sort(int[] arr) {
        long start=System.currentTimeMillis();
        int[] order= Arrays.copyOf(arr,arr.length);
        int m=order.length;
        if(m!=1) {
            for(int i=0;i<m;i++) {
                int min=i;
                for (int j = i; j < m; j++) {
                    if(order[j]<order[min]){
                        min=j;
                    }
                    int temp=order[i];
                    order[i]=order[min];
                    order[min]=temp;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("选择排序用时"+((end-start)/1000)+"秒");
        return order;
    }
}
class InsertionSort{
    public static int[] sort(int[] arr){
        long start=System.currentTimeMillis();
        int[] order=Arrays.copyOf(arr,arr.length);
        int m=arr.length;
        if(m!=1){
            for(int i=1;i<m;i++){
                int insertVal=order[i];    //待插入值
                int index=i-1;
                while(index>=0&&order[index]>insertVal){
                    order[index+1]=order[index];
                    index--;
                }
                order[index+1]=insertVal;
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("插入排序用时"+((end-start)/1000)+"秒");
        return order;
    }
/*    public static int[] mysort(int[] arr){
        long start=System.currentTimeMillis();
        int[] order=Arrays.copyOf(arr,arr.length);
        int m=arr.length;
        if(m!=1){
            for(int i=1;i<m;i++){
                int p=-1;    //默认i比第0位小
                for(int j=i-1;j>=0;j--){
                    if (order[j]<order[i]){
                        p=j;   //插入位置p+1
                        break;
                    }
                }
                //p+1到i-1依次往后移一位，p+1处等于i处 ,不好为了移位置又遍历一遍
                int temp=order[i];
                for(int k=i;k>p+1;k--){
                    order[k]=order[k-1];
                }
                order[p+1]=temp;
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("插入排序用时"+((end-start)/1000)+"秒");
        return order;
    }*/
}
class ShellSort{
    public static int[] shiftSort(int[] arr){
        long start=System.currentTimeMillis();
        int[] order=Arrays.copyOf(arr,arr.length);
        int m=arr.length;
        if(m!=1){
            for (int gap=m/2;gap>0;gap=gap/2){
                for(int i=gap;i<m;i++){
                    //从i插入到order[i-n*gap]中     移位插入排序:插入到比小于插入值的数后面或者插入到0位置   找到位置后结束遍历
                    int j=i-gap;
                    int temp=order[i];
                    while( j>=0 && order[j]>temp){
                        order[j+gap]=order[j];
                        j-=gap;
                    }
                    order[j+gap]=temp;
                }
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("希尔排序用时"+((end-start)/1000)+"秒");
        return order;
    }
/*    public static int[] swapSort(int[] arr){
        long start=System.currentTimeMillis();
        int[] order=Arrays.copyOf(arr,arr.length);
        int m=arr.length;
        if(m!=1){
            for(int gap=m/2;gap>0;gap=gap/2){
                for(int i=gap;i<m;i++){
                    //将order[i-n*gap]内最小的排至数组头部，n>=0  相邻对比交换  类似有序序列冒泡 全得遍历一遍
                    for(int j=i-gap;j>=0;j-=gap){
                        if(order[j]>order[j+gap]){
                            int temp = order[j];
                            order[j] =order[j+gap];
                            order[j+gap]=temp;
                        }
                    }
                }
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("希尔排序用时"+((end-start)/1000)+"秒");
        return order;
    }*/
}
class QuickSort{
    public static void sort(int[] arr,int begin,int end){
        if (begin>=end){
            return;
        }
        int left=begin;
        int right=end;
        int key=arr[left]; //取左值为key
        //将数组分成左侧比key小右侧比key大，key值移至最终指针left=right处
        while(left<right){
            while(arr[right]>key&&left<right){
                right--;
            }
            arr[left]=arr[right];
            while(arr[left]<key&&left<right){
                left++;
            }
            arr[right]=arr[left];
        }
        arr[left]=key;
        QuickSort.sort(arr,begin,left-1);
        QuickSort.sort(arr,left+1,end);
    }
}
class MergerSort{
    public static int[] sort(int[] arr){
        long start=System.currentTimeMillis();
        int [] order=Arrays.copyOf(arr,arr.length);
        int m=arr.length;
        if(m!=1){
            int[] temp = new int[m];
            split(order,0,m-1);
        }
        long end=System.currentTimeMillis();
        System.out.println("归并排序用时"+((end-start)/1000)+"秒");
        return order;
    }
    public static void split(int[] order,int left,int right){
        if(left<right){
             int mid = (left+right)/2;
             split(order,left,mid);
             split(order,mid+1,right);
             merger(order,left,right);
        }
    }
    public static void merger(int[] order,int left, int right){
        int i=0;
        int mid = (left+right)/2;
        int[] temp = new int[right-left+1];
        int p1=left;
        int p2=mid+1;
        while(true){
            if(p1>mid){
                while(p2<=right){
                    temp[i]=order[p2];
                    p2++;
                    i++;
                }
                break;
            }else if(p2>right){
                while(p1<mid+1){
                    temp[i]=order[p1];
                    p1++;
                    i++;
                }
                break;
            }else if(order[p1]>=order[p2]){
                temp[i]=order[p2];
                p2++;
                i++;
            } else{
                temp[i]=order[p1];
                p1++;
                i++;
            }
        }
        i--;
        for(int j=right;j>=left;j--){
            order[j]=temp[i];
            i--;
        }
    }
}