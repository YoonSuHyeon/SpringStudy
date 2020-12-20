package hellojpa.test;


import javax.persistence.*;
import java.util.Date;


@Entity //JPA가 관리한다.
//@Table(name ="MBR")
public class MemberTest {
    @Id
    private Long id;
    @Column(name = "name")
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob //큰 contents를 넣고 싶을때는
    private String description;

    MemberTest(){

    }
}
