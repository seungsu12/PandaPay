package com.pay.membership.adpater.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<MembershipJpaEntity,Long> {
}
