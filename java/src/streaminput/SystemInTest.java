package streaminput;

import java.io.IOException;

public class SystemInTest {
    public static void main(String[] args) {
        System.out.println("입력:");
        try {
            int i =System.in.read(); //-1 끝일때
            System.out.println(i);
            System.out.println((char)i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
