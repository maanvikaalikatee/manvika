package com.company.zo.bottle.Controller;
import com.company.zo.bottle.Entity.BottleEntity;
import com.company.zo.bottle.Service.BottleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/bottle")
public class BottleController {

    private BottleService bottleService;

    @PostMapping
    public ResponseEntity<BottleEntity> createBottle(@Valid @RequestBody BottleEntity bottleEntity) {
        BottleEntity bottle = bottleService.createBottleDetails(bottleEntity);
        return new ResponseEntity<>(bottle, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<BottleEntity> getBottleById(@PathVariable("id") Long bottleId){
        BottleEntity savedBottle=bottleService.getBottleById(bottleId);
        return ResponseEntity.ok(savedBottle);
    }

    @GetMapping
    public ResponseEntity<List<BottleEntity>> getAllBottle(){
        List<BottleEntity> getbottle=bottleService.getAllBottle();
        return ResponseEntity.ok(getbottle);
    }

    @PutMapping("{id}")
    public ResponseEntity<BottleEntity> updateBottleById(@PathVariable("id") Long bottleId,@RequestBody BottleEntity updateBottles){
        BottleEntity bottleUpdate=bottleService.updateBottleById(bottleId,updateBottles);
        return ResponseEntity.ok(bottleUpdate);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long bottleId){
        bottleService.deleteById(bottleId);
        return ResponseEntity.ok("Deleted successfully");
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteSpecificOne(@RequestParam List<Long> bottleId){
        bottleService.deleteAllBottle(bottleId);
        return ResponseEntity.ok("delete successfully all the details");
    }

    @PostMapping("/records")
    public ResponseEntity<List<BottleEntity>> createMultipleRecords(@RequestBody  List<BottleEntity> bottleEntities){
        List<BottleEntity> bottleRecords=bottleService.createMultipleRecords(bottleEntities);
        return ResponseEntity.ok(bottleRecords);
    }
}
