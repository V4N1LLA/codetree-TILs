public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        int a = 5;
        int b = 6;
        int c = 7;
        int tempC = c;
        int tempB = b;

        b = a;
        c = tempB;
        a = tempC;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);



        
    }
}