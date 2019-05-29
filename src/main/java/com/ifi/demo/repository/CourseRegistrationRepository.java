package com.ifi.demo.repository;

import com.ifi.demo.entity.CourseRegistration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRegistrationRepository extends CrudRepository<CourseRegistration, Integer> {
}
