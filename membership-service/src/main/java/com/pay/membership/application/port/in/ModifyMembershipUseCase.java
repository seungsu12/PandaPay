package com.pay.membership.application.port.in;

import com.pay.common.UseCase;
import com.pay.membership.domain.Membership;

@UseCase
public interface ModifyMembershipUseCase {

	Membership modifyMemberShipByMemberId(ModifyMembershipCommand request);
}
