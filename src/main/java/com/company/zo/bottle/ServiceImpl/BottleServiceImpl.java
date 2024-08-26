package com.company.zo.bottle.ServiceImpl;
import com.company.zo.bottle.Entity.BottleEntity;
import com.company.zo.bottle.Exception.ResourceNotFound;
import com.company.zo.bottle.Repository.BottleRepository;
import com.company.zo.bottle.Service.BottleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BottleServiceImpl implements BottleService {
    @Autowired
    private BottleRepository bottleRepository;

    @Override
    public BottleEntity createBottleDetails(BottleEntity bottleEntity) {
        return bottleRepository.save(bottleEntity);
    }

    @Override
    public BottleEntity getBottleById(Long bottleId) {
        return bottleRepository.findById(bottleId).orElseThrow(()->new ResourceNotFound("the id is not exists :" + bottleId));
    }

    @Override
    public List<BottleEntity> getAllBottle() {
        return bottleRepository.findAll();
    }
    @Override
    public BottleEntity updateBottleById(Long bottleId, BottleEntity updateBottles) {
        BottleEntity bottleUpdate=bottleRepository.findById(bottleId).orElseThrow(()->new ResourceNotFound("this id doesnot exists :" +bottleId));
        bottleUpdate.setBottleType(updateBottles.getBottleType());
        bottleUpdate.setBottleCost(updateBottles.getBottleCost());
        return bottleRepository.save(bottleUpdate);
    }
    @Override
    public void deleteById(Long bottleId) {
        bottleRepository.deleteById(bottleId);
    }
    @Override
    public void deleteAllBottle(List<Long> bottleId) {
        bottleRepository.findAll();

    }

    @Override
    public List<BottleEntity> createMultipleRecords(List<BottleEntity> bottleEntities) {
        List<BottleEntity> bottleEntities1=new ArrayList<>();
        for (BottleEntity bottleEntity:bottleEntities) {
            BottleEntity bottle=new BottleEntity();
            BeanUtils.copyProperties(bottleEntity,bottle);
            bottleEntities1.add(bottle);
        }
            return bottleRepository.saveAll(bottleEntities1);
    }
}
