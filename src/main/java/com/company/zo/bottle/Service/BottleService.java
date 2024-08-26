package com.company.zo.bottle.Service;
import com.company.zo.bottle.Entity.BottleEntity;
import java.util.List;
public interface BottleService {
    BottleEntity createBottleDetails(BottleEntity bottleEntity);
    BottleEntity getBottleById(Long bottleId);
    List<BottleEntity> getAllBottle();
    BottleEntity updateBottleById(Long bottleId,BottleEntity updateBottles);
    void deleteById(Long bottleId);
    void deleteAllBottle(List<Long> bottleId);
    List<BottleEntity> createMultipleRecords(List<BottleEntity> bottleEntities);

}
