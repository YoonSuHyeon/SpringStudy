package streamothers;

public class CoffeeTest {
    public static void main(String[] args) {
        Coffee americano = new KenyaAmericano();
        americano.brewing();

        Coffee latte = new Latte(americano);
        latte.brewing();

        Coffee mocha = new Mocha(new Latte(new KenyaAmericano()));
        mocha.brewing();
    }
}
