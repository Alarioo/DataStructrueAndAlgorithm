package C07.Recursion;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(factoria(3));
        Test(4);
    }
    public static int factoria(int n){
        if (n==1){
            return 1;
        }else{
            return n*factoria(n-1);
        }
    }
    public static void Test(int n){
        if (n>2){
            Test(n-1);
        }

        System.out.println(n);
    }
}
