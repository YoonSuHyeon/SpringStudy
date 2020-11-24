package thread;
/*class MyThread extends Thread{

    public void run(){

        for (int i = 0; i < 200; i++) {
            System.out.println(i+"/t");
        }

        try{
            sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}*/
class MyThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println(i+"/t");
        }

        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}


public class ThreadTest {

    public static void main(String[] args) {
       /* MyThread th1 = new MyThread();
        MyThread th2 = new MyThread();

        th1.start();
        th2.start();*/

        MyThread myThread = new MyThread();
        Thread th1 = new Thread(myThread);
        th1.start();

        MyThread myThread2 = new MyThread();
        Thread th2 = new Thread(myThread2);
        th2.start();


        Thread thread = Thread.currentThread();
        System.out.println("thread = " + thread);


        System.out.println("end");
    }
}
