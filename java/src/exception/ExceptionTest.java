package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;

        try{
            fileInputStream = new FileInputStream("a.txt");

        }catch (FileNotFoundException e){
            System.out.println(e);
            return; // return과 상관없이 finally가 수행된다.
        }finally {
            try {
                System.out.println("finally");
                fileInputStream.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println("end");
    }
}
