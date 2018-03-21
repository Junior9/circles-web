package com.eg.circles.circles_web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eg.circles.circles_web.model.Employeer;

@Repository
public interface EmployeerRepository extends CrudRepository<Employeer, String> {

}
