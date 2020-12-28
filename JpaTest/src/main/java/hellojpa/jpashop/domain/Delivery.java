package hellojpa.jpashop.domain;

import javax.persistence.*;

@Entity
public class Delivery extends BaseEntity {
    @Id @GeneratedValue
    private Long id;
    private String city;
    private String street;
    private String ziipcode;
    private DeliveryStatus status;

    @OneToOne(mappedBy ="delivery")
    private Order order;

}
