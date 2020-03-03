package com.gofly.in.GoFlyApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gofly.in.GoFlyApp.Entity.GoFlyAdminEntity;

@Repository
public interface GoFlyAdminRepository extends CrudRepository<GoFlyAdminEntity, String>
{

}
