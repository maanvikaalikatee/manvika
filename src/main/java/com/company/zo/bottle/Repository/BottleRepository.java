package com.company.zo.bottle.Repository;

import com.company.zo.bottle.Entity.BottleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BottleRepository extends JpaRepository<BottleEntity,Long> {

}
