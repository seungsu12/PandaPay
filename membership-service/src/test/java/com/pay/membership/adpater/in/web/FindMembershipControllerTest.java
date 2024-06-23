package com.pay.membership.adpater.in.web;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FindMembershipControllerTest {

	@Test
	@DisplayName("Id를 기준으로 멤버를 반환한다.")
	void findMemberShipByMemberId() {

		// given
		FindMembershipController findMembershipController = new FindMembershipController(null);

		// when
		// then
		assertThrows(NullPointerException.class, () -> findMembershipController.findMemberShipByMemberId(null));
	}
}
