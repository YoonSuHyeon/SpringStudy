package stream;

import java.util.ArrayList;

public class TravelTest {
    public static void main(String[] args) {
        TravelCustomer customer1 = new TravelCustomer("이순신",40,100);
        TravelCustomer customer2 = new TravelCustomer("김유신",20,100);
        TravelCustomer customer3 = new TravelCustomer("홍길동",13,50);

        ArrayList<TravelCustomer> arrayList = new ArrayList<TravelCustomer>();
        arrayList.add(customer1);
        arrayList.add(customer2);
        arrayList.add(customer3);
        System.out.println("arrayList = " + arrayList);

        arrayList.stream().map(n->n.getName()).forEach(s-> System.out.println(s));
        int total=arrayList.stream().mapToInt(c -> c.getPrice()).sum();
        System.out.println("total = " + total);

        arrayList.stream().filter(c->c.getAge() >= 20).map(c->c.getName()).sorted().forEach(it-> System.out.println(it));

    }
    
}
