package com.pay.membership.adpater.in.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pay.membership.application.port.in.RegisterMembershipCommand;
import com.pay.membership.application.port.in.RegisterMembershipUseCase;
import com.pay.membership.common.WebAdapter;
import com.pay.membership.domain.Membership;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@WebAdapter
@Slf4j
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

	private final RegisterMembershipUseCase registerMembershipUseCase;

	@PostMapping("/members/register")
	public Membership registerMemberShip(@RequestBody RegisterMembershipRequest request){

		RegisterMembershipCommand command = RegisterMembershipCommand.builder()
			.name(request.getName())
			.address(request.getAddress())
			.isValid(true)
			.isCorp(request.isCorp())
			.email(request.getEmail())
			.build();

		return registerMembershipUseCase.registerMembership(command);
	}
}
