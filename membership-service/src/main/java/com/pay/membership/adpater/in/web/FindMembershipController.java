package com.pay.membership.adpater.in.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pay.membership.application.port.in.FindMembershipCommand;
import com.pay.membership.application.port.in.FindMembershipUseCase;
import com.pay.membership.domain.Membership;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FindMembershipController {

	private final FindMembershipUseCase findMembershipUseCase;

	@GetMapping("/membership/{memberId}")
	public ResponseEntity<Membership> findMemberShipByMemberId(@PathVariable String memberId){

		FindMembershipCommand findMembershipCommand = new FindMembershipCommand(memberId);

		return ResponseEntity.ok(findMembershipUseCase.findMembership(findMembershipCommand));
	}
}
