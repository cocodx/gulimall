package com.lg.gulimall.member;

import com.lg.gulimall.member.entity.MemberEntity;
import com.lg.gulimall.member.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author amazfit
 * @date 2022-06-24 上午12:02
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallMemberApplicationTests {

    @Autowired
    MemberService memberService;

    @Test
    public void contextLoads(){
        MemberEntity member = new MemberEntity();
        member.setJob("国外大厂");
        memberService.save(member);
    }
}
