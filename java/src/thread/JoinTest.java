package thread;

public class JoinTest extends Thread {
    int start;
    int end;
    int total;

    public JoinTest(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        int i;
        for (i = start; i <= end; i++) {
            total += i;
        }
    }

    public static void main(String[] args) {
        JoinTest joinTest = new JoinTest(1, 50);
        JoinTest joinTest1 = new JoinTest(51, 100);
        joinTest.start();
        joinTest1.start();

        try {
            joinTest.join();
            joinTest1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        int total = joinTest.total + joinTest1.total;
        System.out.println("joinTest = " + joinTest.total);
        System.out.println("joinTest1 = " + joinTest1.total);

        System.out.println("total = " + total);

    }
}
