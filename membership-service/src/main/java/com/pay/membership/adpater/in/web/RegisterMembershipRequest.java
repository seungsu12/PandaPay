package com.pay.membership.adpater.in.web;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
public class RegisterMembershipRequest {
	private String name;
	private String email;
	private String address;
	private boolean corp;
}
