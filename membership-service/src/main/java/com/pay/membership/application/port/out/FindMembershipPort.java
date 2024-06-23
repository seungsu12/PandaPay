package com.pay.membership.application.port.out;

import com.pay.membership.adpater.out.persistence.MembershipJpaEntity;
import com.pay.membership.domain.Membership.MembershipId;

public interface FindMembershipPort {


	MembershipJpaEntity findMembership(MembershipId membershipId);

}
