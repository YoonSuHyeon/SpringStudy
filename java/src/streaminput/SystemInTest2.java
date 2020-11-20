package streaminput;

import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInTest2 {
    public static void main(String[] args) {
        System.out.println("입력 후 '끝' 이라고 쓰세요 :");




        while(true){
            try {
                int i ;
                InputStreamReader isr = new InputStreamReader(System.in);
                if ((i=isr.read()) != '끝'){
                    System.out.println((char)i);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
