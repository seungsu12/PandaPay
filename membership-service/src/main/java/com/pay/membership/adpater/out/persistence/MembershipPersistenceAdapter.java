package com.pay.membership.adpater.out.persistence;

import org.springframework.stereotype.Component;

import com.pay.membership.application.port.out.FindMembershipPort;
import com.pay.membership.application.port.out.ModifyMembershipPort;
import com.pay.membership.application.port.out.RegisterMembershipPort;
import com.pay.membership.domain.Membership;
import com.pay.common.WebAdapter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebAdapter
@Component
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {

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

	@Override
	public MembershipJpaEntity findMembership(Membership.MembershipId membershipId) {
		return membershipRepository.findById(Long.parseLong(membershipId.getMembershipId()))
			.orElseThrow(() -> new IllegalArgumentException("membership not found by " + membershipId ));
	}

	@Override
	public MembershipJpaEntity modifyMembership(Membership.MembershipId membershipId,
		Membership.MembershipName membershipName, Membership.MembershipEmail membershipEmail,
		Membership.MembershipAddress membershipAddress, Membership.MembershipIsValid membershipIsValid,
		Membership.MembershipIsCorp membershipIsCorp) {

		MembershipJpaEntity entity = membershipRepository.findById(Long.parseLong(membershipId.getMembershipId()))
			.orElseThrow(() -> new IllegalArgumentException("membership not found by " + membershipId ));

		entity.setEmail(membershipEmail.getMembershipEmail());
		entity.setName(membershipName.getMembershipName());
		entity.setAddress(membershipAddress.getMembershipAddress());
		entity.setCorp(membershipIsCorp.isMembershipCorp());
		entity.setValid(membershipIsValid.isMembershipIsValid());

		return membershipRepository.save(entity);
	}
}
