package com.pay.membership.application.port.in;

import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FindMembershipCommand {

	private final String membershipId;
}
