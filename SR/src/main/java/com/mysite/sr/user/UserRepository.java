package com.mysite.sr.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserList, Integer> {

	Optional<UserList> findByusername(String username);
}
