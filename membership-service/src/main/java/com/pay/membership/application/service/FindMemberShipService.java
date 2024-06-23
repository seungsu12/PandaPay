package com.pay.membership.application.service;

import org.springframework.stereotype.Service;

import com.pay.membership.adpater.out.persistence.MembershipJpaEntity;
import com.pay.membership.adpater.out.persistence.MembershipMapper;
import com.pay.membership.application.port.in.FindMembershipCommand;
import com.pay.membership.application.port.in.FindMembershipUseCase;
import com.pay.membership.application.port.out.FindMembershipPort;
import com.pay.membership.domain.Membership;
import com.pay.common.UseCase;

import lombok.RequiredArgsConstructor;

@UseCase
@Service
@RequiredArgsConstructor
public class FindMemberShipService implements FindMembershipUseCase {

	private final FindMembershipPort findMembershipPort;
	private final MembershipMapper membershipMapper;

	@Override
	public Membership findMembership(FindMembershipCommand findMembershipCommand) {
		String membershipId = findMembershipCommand.getMembershipId();
		MembershipJpaEntity membership = findMembershipPort.findMembership(new Membership.MembershipId(membershipId));

		return membershipMapper.convertToDomain(membership);
	}
}
