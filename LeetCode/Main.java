import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt(), b = scn.nextInt(), c = scn.nextInt();
        if ((a * a + b * b == c * c) || (a * a + c * c == b * b) || (c * c + b * b == a * a))
            System.out.println(true);
        else
            System.out.println("false");
    }
}