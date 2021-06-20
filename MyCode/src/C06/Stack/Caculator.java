package C06.Stack;

import java.util.Stack;

/*
        for(T E:Stack) 栈从底部开始遍历

 */
public class Caculator{
    public static void main(String[] args) {
        String infix="1+3*((17+3)/10)-5";
        System.out.println(1+3*((17+3)/10)-5);
        Stack<String> infixStack = stringToStack(infix);
        System.out.println(infixStack);
        Stack<String> suffixStack= infixToSuffix(infixStack);
        System.out.println(suffixStack);
        int res=Caculate(suffixStack);
        System.out.println(res);
        Stack<Integer> ss=new Stack<>();
        ss.add(1);
        ss.add(2);
        System.out.println(ss.pop()+ss.pop());
    }
    public static Stack<String> stringToStack(String str){
        Stack<String> s=new Stack<>();
        int i=0;
        while(i<str.length()){
            if(str.charAt(i)<48 || str.charAt(i)>57){   //  符号
                s.add(""+str.charAt(i));
                i++;
            }else{              //数字
                String num="";
                while(i<str.length()    &&      (   str.charAt(i)>47 && str.charAt(i)<58    )         ){
                    num=num+str.charAt(i);
                    i++;
                }
                s.add(num);
            }
        }
        return s;
    }
    public static Stack<String> infixToSuffix(Stack<String> infix){
        Stack<String> s1=new Stack<>();
        Stack<String> s2=new Stack<>();
        for(String s:infix){
            //正则表达式   匹配数字
            if(s.matches("\\d+")) {
               s1.add(s);
            }else if(s.equals("(")) {
                s2.add(s);
            }else if(s.equals("*")||s.equals("/")){
                if(Priority(s2.peek())<2){
                    s1.add(s2.pop());
                }
                s2.add(s);
            }else if(s.equals("+")||s.equals("-")){
                while(s2.size()>0&&(Priority(s2.peek())<3)){
                    s1.add(s2.pop());
                }
                s2.add(s);
            }else if(s.equals(")")){
                while(!s2.peek().equals("(") ){     //String类型用equal比较
                    s1.add(s2.pop());
                }
                s2.pop();
            }
        }
        while(s2.size()>0){
            s1.add(s2.pop());
        }
        return s1;
    }
    public static int Priority(String o1){
        int i=0;
        switch(o1) {
            case "*" :
                i=1;
                break;
            case "/" :
                i=1;
                break;
            case "+" :
                i=2;
                break;
            case "-" :
                i=2;
                break;
            case "(" :
                i=3;
                break;
        }
        return i;
    }
    public static int Caculate(Stack<String> suffix){
        Stack<Integer> nums=new Stack<>();
        int res=0;
        for(String s:suffix) {            //从栈底开始遍历
            if (s.matches("\\d+")) {
                nums.add(Integer.parseInt(s));
            } else if (s.equals("+")) {
                int temp = nums.pop();
                nums.add(nums.pop() + temp);
            } else if (s.equals("-")) {
                int temp = nums.pop();
                nums.add(nums.pop() - temp);
            } else if (s.equals("*")) {
                int temp = nums.pop();
                nums.add(nums.pop() * temp);
            } else if (s.equals("/")) {
                int temp = nums.pop();
                nums.add(nums.pop() / temp);
            }
        /*  }else{
                int num1=nums.pop();
                int num2=nums.pop();
                if (s.equals("+")) {
                nums.add(num1 + num2);
            } else if (s.equals("-")) {
                    nums.add(num1 - num2);
            } else if (s.equals("*")) {
                    nums.add(num1 * num2);
            } else if (s.equals("/")) {
                    nums.add(num1 / num2);
            }*/
        }
        return res=nums.pop();
    }
}