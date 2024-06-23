package com.pay.membership.adpater.in.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pay.membership.application.port.in.ModifyMembershipCommand;
import com.pay.membership.application.port.in.ModifyMembershipUseCase;
import com.pay.membership.domain.Membership;
import com.pay.common.WebAdapter;

import lombok.RequiredArgsConstructor;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class ModifyMembershipController {

	private final ModifyMembershipUseCase modifyMembershipUseCase;

	@PutMapping("/members/modify")
	public ResponseEntity<Membership> findMemberShipByMemberId(@RequestBody ModifyMembershipRequest request) {

		ModifyMembershipCommand command = ModifyMembershipCommand.builder()
			.membershipId(request.getMembershipId())
			.name(request.getName())
			.address(request.getAddress())
			.isCorp(request.isCorp())
			.email(request.getEmail())
			.isValid(request.isValid())
			.build();

		return ResponseEntity.ok(modifyMembershipUseCase.modifyMemberShipByMemberId(command));
	}
}
