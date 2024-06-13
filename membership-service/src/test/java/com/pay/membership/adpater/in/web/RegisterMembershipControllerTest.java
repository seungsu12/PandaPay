package com.pay.membership.adpater.in.web;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pay.membership.domain.Membership;

@Transactional
@AutoConfigureMockMvc
@SpringBootTest
class RegisterMembershipControllerTest {


	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void registerMemberShip() throws Exception {

		RegisterMembershipRequest registerMembershipRequest = new RegisterMembershipRequest("name", "email", "address",
			true);

		Membership membership = Membership.generateMember(
			new Membership.MembershipId("1"),
			new Membership.MembershipName("name"),
			new Membership.MembershipEmail("email"),
			new Membership.MembershipAddress("address"),
			new Membership.MembershipIsValid(true),
			new Membership.MembershipIsCorp(true)
		);

		mockMvc.perform(post("/members/register")
			.contentType("application/json")
			.content(objectMapper.writeValueAsString(registerMembershipRequest)))
			.andExpect(status().isOk())
			.andExpect(content().json(objectMapper.writeValueAsString(membership)));
	}
}
