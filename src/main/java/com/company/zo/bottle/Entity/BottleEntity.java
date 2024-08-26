package com.company.zo.bottle.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "BottleDB")
public class BottleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bottleId;
    @Column(name="bottle_Type")
    private String bottleType;
    @Column(name = "bottle_Cost")
    @NotNull
    private Long bottleCost;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$", message = "Email must be in the format of @gmail.com")
    private String email;

    public BottleEntity() {
    }

    public BottleEntity(Long bottleId, String bottleType, Long bottleCost) {
        this.bottleId = bottleId;
        this.bottleType = bottleType;
        this.bottleCost = bottleCost;
    }

    public Long getBottleId() {
        return bottleId;
    }

    public void setBottleId(Long bottleId) {
        this.bottleId = bottleId;
    }

    public String getBottleType() {
        return bottleType;
    }

    public void setBottleType(String bottleType) {
        this.bottleType = bottleType;
    }

    public Long getBottleCost() {
        return bottleCost;
    }

    public void setBottleCost(Long bottleCost) {
        this.bottleCost = bottleCost;
    }
}
