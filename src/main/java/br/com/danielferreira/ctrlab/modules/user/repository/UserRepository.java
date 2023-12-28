package br.com.danielferreira.ctrlab.modules.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.danielferreira.ctrlab.modules.user.domain.User;

public interface UserRepository extends JpaRepository<User, String> {

}
