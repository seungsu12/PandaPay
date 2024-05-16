package com.pay.membership.adpater.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@ToString
@Table(name = "membership")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MembershipJpaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "membership_id")
	private Long id;

	private String name;

	private String email;

	private String address;

	private boolean isValid;

	private boolean isCorp;

	@Builder
	public MembershipJpaEntity(String name, String email, String address, boolean isValid, boolean isCorp) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.isValid = isValid;
		this.isCorp = isCorp;
	}
}
