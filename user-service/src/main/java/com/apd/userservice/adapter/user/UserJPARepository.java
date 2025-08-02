package com.apd.userservice.adapter.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface UserJPARepository extends JpaRepository<UserEntity, UUID> {
}
