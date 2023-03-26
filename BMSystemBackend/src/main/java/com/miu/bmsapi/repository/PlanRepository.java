package com.miu.bmsapi.repository;

import com.miu.bmsapi.domain.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<PlanEntity,Integer> {

}
