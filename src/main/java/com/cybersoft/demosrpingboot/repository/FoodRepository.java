package com.cybersoft.demosrpingboot.repository;

import com.cybersoft.demosrpingboot.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, String> {
}
