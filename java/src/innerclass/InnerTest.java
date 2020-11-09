package innerclass;

class OutClass {
    private int num = 10;
    private static int sNum = 20;
    private InClass inClass;

    public OutClass() {
        inClass = new InClass();
    }

    class InClass {
        int iNum = 100;

        // static int sInnum = 200; OutClass 가 static 이게되면 상관없지만 현재는 오류
        void inTest() {
            System.out.println(num);
            System.out.println(sNum);
        }

    }
    public void usingInner(){
        inClass.inTest();
    }

    static class InStaticClass{
        int inNum = 100;
        static int sInnum = 200;
        void inTest(){
            System.out.println(inNum);
            System.out.println(sInnum);
            System.out.println(sNum);
        }
        static void sTest(){
            System.out.println(sInnum);
            System.out.println(sNum);
        }
    }
}


public class InnerTest {
    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        outClass.usingInner();
         OutClass.InClass myInclass = outClass.new InClass();
        myInclass.inTest();


        System.out.println();
        OutClass.InStaticClass inStaticClass = new OutClass.InStaticClass();
        inStaticClass.inTest();
        OutClass.InStaticClass.sTest();
    }
}
