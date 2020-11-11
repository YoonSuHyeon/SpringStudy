package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryWithResources {
    public static void main(String[] args) {

        try(FileInputStream fileInputStream = new FileInputStream("a.txt")){


        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        AutoCloseObj obj = new AutoCloseObj();

        try( obj ){
            throw  new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
