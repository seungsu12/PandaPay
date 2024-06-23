package com.pay.membership.application.service;

import org.springframework.stereotype.Service;

import com.pay.membership.adpater.out.persistence.MembershipJpaEntity;
import com.pay.membership.adpater.out.persistence.MembershipMapper;
import com.pay.membership.application.port.in.ModifyMembershipCommand;
import com.pay.membership.application.port.in.ModifyMembershipUseCase;
import com.pay.membership.application.port.out.ModifyMembershipPort;
import com.pay.membership.domain.Membership;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ModifyMemberShipService implements ModifyMembershipUseCase {

	private final ModifyMembershipPort modifyMembershipPort;
	private final MembershipMapper membershipMapper;;
	@Override
	public Membership modifyMemberShipByMemberId(ModifyMembershipCommand command) {

		MembershipJpaEntity jpaEntity = modifyMembershipPort.modifyMembership(
			new Membership.MembershipId(command.getMembershipId()),
			new Membership.MembershipName(command.getName()),
			new Membership.MembershipEmail(command.getEmail()),
			new Membership.MembershipAddress(command.getAddress()),
			new Membership.MembershipIsValid(command.isValid()),
			new Membership.MembershipIsCorp(command.isCorp())
		);

		return membershipMapper.convertToDomain(jpaEntity);
	}
}
