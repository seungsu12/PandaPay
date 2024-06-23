package com.pay.membership.adpater.in.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pay.membership.domain.Membership;

@Transactional
@AutoConfigureMockMvc
@SpringBootTest
public class ModifyMembershipControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@BeforeEach
	void setUp() throws Exception {
		RegisterMembershipRequest registerMembershipRequest = new RegisterMembershipRequest("name", "email", "address",
			true);

		mockMvc.perform(post("/members/register")
			.contentType("application/json")
			.content(objectMapper.writeValueAsString(registerMembershipRequest)));
	}

	@Test
	void modifyMembership() throws Exception {

		ModifyMembershipRequest modifyMembershipRequest = new ModifyMembershipRequest("1", "lss", "123@gmail.com",
			"address", true, true);

		Membership expected = Membership.generateMember(
			new Membership.MembershipId("1"),
			new Membership.MembershipName("lss"),
			new Membership.MembershipEmail("123@gmail.com"),
			new Membership.MembershipAddress("address"),
			new Membership.MembershipIsValid(true),
			new Membership.MembershipIsCorp(true)
		);

		mockMvc.perform(put("/members/modify")
			.contentType("application/json")
			.content(objectMapper.writeValueAsString(modifyMembershipRequest)))
			.andExpect(content().json(objectMapper.writeValueAsString(expected)));

	}
}
