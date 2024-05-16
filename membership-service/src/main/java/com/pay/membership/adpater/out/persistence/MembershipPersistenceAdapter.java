package com.pay.membership.adpater.out.persistence;

import com.pay.membership.application.port.out.RegisterMembershipPort;
import com.pay.membership.common.WebAdapter;
import com.pay.membership.domain.Membership;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort {

	private final MembershipRepository membershipRepository;

	@Override
	public MembershipJpaEntity createMembership( Membership.MembershipName membershipName,
		Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress,
		Membership.MembershipIsValid membershipIsValid, Membership.MembershipIsCorp membershipIsCorp) {

		log.info("membership corp : {}", membershipIsCorp.isMembershipCorp());

		return membershipRepository.save(MembershipJpaEntity.builder()
			.email(membershipEmail.getMembershipEmail())
			.name(membershipName.getMembershipName())
			.address(membershipAddress.getMembershipAddress())
			.isCorp(membershipIsCorp.isMembershipCorp())
			.isValid(membershipIsValid.isMembershipIsValid())
			.build());
	}
}
