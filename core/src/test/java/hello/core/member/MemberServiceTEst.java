package hello.core.member;

import hello.core.Appconfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTEst {

    MemberService memberService;
    @BeforeEach
    public void beforeEach(){
        Appconfig appconfig = new Appconfig();
        memberService = appconfig.memberService();
    }
    @Test
    void join(){
        //given
        Member member = new Member(1l, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1l);
        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
