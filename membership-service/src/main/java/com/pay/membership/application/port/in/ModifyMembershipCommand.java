package com.pay.membership.application.port.in;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ModifyMembershipCommand {

	@NotNull
	private final String membershipId;
	@NotNull
	private final String name;
	@NotNull
	private final String email;
	@NotEmpty
	private final String address;
	private final boolean isValid;
	private final boolean isCorp;


}
