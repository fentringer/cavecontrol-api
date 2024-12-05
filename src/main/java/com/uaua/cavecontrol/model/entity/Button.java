package com.uaua.cavecontrol.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Button {

    @Id
    private Long id = 1L; // Um único botão, então sempre ID será 1

    private Boolean isActive = false; // O botão começa como inativo

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
