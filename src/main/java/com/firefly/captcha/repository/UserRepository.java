package com.firefly.captcha.repository;

import com.firefly.captcha.model.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by rodion on 29.01.2017.
 */
@Component
public interface UserRepository extends CrudRepository<User,Long>{

    List<User> findByLastName(String lastName);

}
