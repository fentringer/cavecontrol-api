package com.uaua.cavecontrol.controller;

import com.uaua.cavecontrol.model.dto.ButtonDTO;
import com.uaua.cavecontrol.service.ButtonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/button")
public class ButtonController {

    private final ButtonService buttonService;

    public ButtonController(ButtonService buttonService) {
        this.buttonService = buttonService;
    }

    @PutMapping("/toggle")
    public ResponseEntity<ButtonDTO> toggleButton() {
        ButtonDTO updatedButton = buttonService.toggleButtonState();
        return ResponseEntity.ok(updatedButton);
    }

    @GetMapping("/state")
    public ResponseEntity<ButtonDTO> getButtonState() {
        ButtonDTO buttonState = buttonService.getButtonState();
        return ResponseEntity.ok(buttonState);
    }
}
