package com.example.fastcampusmysql.domain.member;

import com.example.fastcampusmysql.domain.member.entity.Member;
import com.example.fastcampusmysql.util.MemberFixtureFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class MemberTest {
    @DisplayName("회원은 닉네임을 변경할 수 있음 ")
    @Test
    public void testChangeName(){
        var member = MemberFixtureFactory.create();
        var toChangeName = "ex1";
        member.changeNickname(toChangeName);
        Assertions.assertEquals(toChangeName, member.getNickname());
//        LongStream.range(0,10)
//                .mapToObj(MemberFixtureFactory::create)
//                .forEach(member -> {
//                    System.out.println(member.getNickname());
//                });
                // objectMother pattern
    }
    @DisplayName("회원의 닉네임 10글자 초과 불가")
    @Test
    public void testNicknameMaxLength() {
        var member = MemberFixtureFactory.create();
        var toChangeName = "ex1ex2ex344";
        Assertions.assertThrows(IllegalArgumentException.class, ()-> member.changeNickname(toChangeName));
    }
}
