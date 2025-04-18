

package com.example.Demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Demo.entities.Users;
import java.util.List;


@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    // Add custom query methods if needed
	public Users  findByEmail(String email);

	public Users getUserByfirstName(String email);
}
