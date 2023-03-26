package com.miu.bmsapi.service;

import com.miu.bmsapi.domain.Badge;
import com.miu.bmsapi.domain.Member;
import com.miu.bmsapi.enums.OperationResult;
import com.miu.bmsapi.repository.MemberRepository;
import com.miu.bmsapi.service.BadgeService;
import com.miu.bmsapi.service.MemberService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;
    private BadgeService badgeService;

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member update(int id, Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member getById(int id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    @Override
    public OperationResult delete(int id) {
        memberRepository.delete(getById(id));
        return OperationResult.SUCCEED;
    }

    @Override
    public OperationResult assignBadge(Integer memberId, Integer badgeId) {
        Member member = getById(memberId);
        Badge badge = badgeService.getById(badgeId);
        if (member == null || badge == null) {
            return OperationResult.FAILED;
        }
        badgeService.inactiveAllBadgesOfThisMember(memberId);
        badge.setMember(member);
        badge.setActive(true);
        badgeService.save(badge);
        return OperationResult.SUCCEED;
    }
}
