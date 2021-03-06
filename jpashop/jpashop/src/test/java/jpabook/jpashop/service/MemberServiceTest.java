package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
    public void 회원가입() throws Exception {
//        //given
//        Member member = new Member();
//        member.setName("kim");
//
//        //when
//        Long join = memberService.join(member);
//
//        //then
//        em.flush();
//        Assertions.assertEquals(member,memberRepository.findOne(join));

        Member member = new Member();
        member.setName("sungwon");

        Long join = memberService.join(member);
        Assertions.assertEquals(member, memberService.findOne(join));
    }

    @Test
    public void 중복_회원_예외외() throws Exception {

//        Member member1 = new Member();
//        member1.setName("kim1");
//
//        Member member2 = new Member();
//        member2.setName("kim1");
//
//        memberService.join(member1);
//        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
//            memberService.join(member2);
//        });
//
//        Assertions.assertEquals("이미 존재하는 회원입니다.",illegalArgumentException.getMessage());

        Member member = new Member();
        member.setName("test1");

        Member member2 = new Member();
        member2.setName("test2");

        memberService.join(member);

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
                    memberService.join(member2);
                }
        );

        Assertions.assertEquals("이미 존재하는 회원입니다.", illegalArgumentException.getMessage());


    }

}