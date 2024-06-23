package com.pay.membership.application.service;

import org.springframework.transaction.annotation.Transactional;

import com.pay.membership.adpater.out.persistence.MembershipJpaEntity;
import com.pay.membership.adpater.out.persistence.MembershipMapper;
import com.pay.membership.application.port.in.RegisterMembershipCommand;
import com.pay.membership.application.port.in.RegisterMembershipUseCase;
import com.pay.membership.application.port.out.RegisterMembershipPort;
import com.pay.membership.domain.Membership;
import com.pay.common.UseCase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@UseCase
@Slf4j
@Transactional
@RequiredArgsConstructor
public class RegisterMemberShipService implements RegisterMembershipUseCase {

	private final RegisterMembershipPort registerMembershipPort;
	private final MembershipMapper membershipMapper;

	@Override
	public Membership registerMembership(RegisterMembershipCommand command) {

		log.info("isCorp form command : {}", command.isCorp());

		MembershipJpaEntity jpaEntity = registerMembershipPort.createMembership(
			new Membership.MembershipName(command.getName()),
			new Membership.MembershipEmail(command.getEmail()),
			new Membership.MembershipAddress(command.getAddress()),
			new Membership.MembershipIsValid(command.isValid()),
			new Membership.MembershipIsCorp(command.isCorp())
		);
		return membershipMapper.convertToDomain(jpaEntity);
	}
}
