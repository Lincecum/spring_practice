package com.example.fastcampusmysql.domain.member.service;

import com.example.fastcampusmysql.domain.member.dto.RegisterMemberCommand;
import com.example.fastcampusmysql.domain.member.entity.Member;
import com.example.fastcampusmysql.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberWriteService {
    final private MemberRepository memberRepository;
    public void create(RegisterMemberCommand command) {

        /*
- 회원정보를 등록한다.
- 닉네임은 10자를 넘길 수 없다
 */

        var member = Member.builder()
                .nickname(command.nickname())
                .birthDay(command.birthday())
                .email(command.email())
                .build();
        memberRepository.save(member);
    }

}