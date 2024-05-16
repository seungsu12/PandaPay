package com.pay.membership.adpater.out.persistence;

import org.springframework.stereotype.Component;

import com.pay.membership.domain.Membership;

@Component
public class MembershipMapper {

	public Membership convertToDomain(MembershipJpaEntity membershipJpaEntity) {
		return Membership.generateMember(
			new Membership.MembershipId(membershipJpaEntity.getId().toString()),
			new Membership.MembershipName(membershipJpaEntity.getName()),
			new Membership.MembershipEmail(membershipJpaEntity.getEmail()),
			new Membership.MembershipAddress(membershipJpaEntity.getAddress()),
			new Membership.MembershipIsValid(membershipJpaEntity.isValid()),
			new Membership.MembershipIsCorp(membershipJpaEntity.isCorp())
		);
	}
}
