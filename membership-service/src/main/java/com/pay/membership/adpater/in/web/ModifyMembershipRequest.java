package com.pay.membership.adpater.in.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ModifyMembershipRequest {

	private String membershipId;
	private String name;
	private String email;
	private String address;
	private boolean corp;
	private boolean valid;

}
