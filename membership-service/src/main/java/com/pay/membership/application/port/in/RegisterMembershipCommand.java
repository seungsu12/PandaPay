package com.pay.membership.application.port.in;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RegisterMembershipCommand {


	@NotNull
	private final String name;
	@NotNull
	private final String email;
	@NotEmpty
	private final String address;
	private final boolean isValid;
	private final boolean isCorp;

	@Builder
	public RegisterMembershipCommand(String name, String email, String address, boolean isValid, boolean isCorp) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.isValid = isValid;
		this.isCorp = isCorp;
	}
}
