package com.automedtionedge.jayshree.Consumer.service.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automedtionedge.jayshree.Consumer.service.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByPassword(String password);

	boolean existsByPassword(String password);

}
