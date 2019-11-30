package com.jj.repository;

import com.jj.pojo.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items,Integer> {
}
