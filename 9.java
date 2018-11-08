//思路就是比较第一个，比较第二个，比较第三个
//最初我用的是h*h>x作为判断条件，但这样的话h*h的结果可能会越界

public class Main {
    
    public static void main(String[] args) {
        System.out.print(isPalindrome(1000021));
    }
    
    public static boolean isPalindrome(int x) {
        if(x<0) return false;
        int h = 1;
        /*
         if x = 0, h = 0
         if x = 35, h = 10
         if x = 500, h = 100
         if x = 1000, h = 1000
         */
        while(x/h >= 10) {
            h*=10;
        }
        int k = 1;
        System.out.println(h);
        /*
         then we should compare the first number with the last number
         second number with second last number and so on
         if n = 987789, the while loop should stop when h = 1000 start from h = 100000
         n = 12321, h = 10000 to 1000
         */
        while(h > Math.sqrt(x)){
            System.out.println(h);
            int a = (x/h)%10;//get the first number
            int b = (x/k)%10;//get the last number
            if(a!=b) return false;
            h = h/10;
            k = k*10;
            
        }
        return true;
    }
}

