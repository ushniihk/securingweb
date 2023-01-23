package com.example.securingweb;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<Users, Long> {
}
