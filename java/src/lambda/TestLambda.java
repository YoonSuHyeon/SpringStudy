package lambda;
interface PrintString{
    void showSTring(String string);
}

public class TestLambda {
    public static void main(String[] args) {
        PrintString lambdaStr = s -> System.out.println(s);
        lambdaStr.showSTring("Test");

        showMyString(lambdaStr);

        PrintString printString = returnString();
        printString.showSTring("Test3");
    }

    public static void showMyString(PrintString p){
        p.showSTring("Test2");
    }
    public static PrintString returnString(){
        return s -> System.out.println(s + "!!!");
    }
}
