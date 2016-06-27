package com.example.services;

import com.example.Entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by illladell on 6/27/16.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
}
