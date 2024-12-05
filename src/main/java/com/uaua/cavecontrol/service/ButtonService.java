package com.uaua.cavecontrol.service;

import com.uaua.cavecontrol.exception.EntityNotFoundException;
import com.uaua.cavecontrol.model.dto.ButtonDTO;
import com.uaua.cavecontrol.model.entity.Button;
import com.uaua.cavecontrol.model.mapper.ButtonMapper;
import com.uaua.cavecontrol.repository.ButtonRepository;
import org.springframework.stereotype.Service;

@Service
public class ButtonService {

    private final ButtonRepository repository;
    private final ButtonMapper buttonMapper;

    public ButtonService(ButtonRepository repository, ButtonMapper buttonMapper) {
        this.repository = repository;
        this.buttonMapper = buttonMapper;
    }

    public ButtonDTO toggleButtonState() {

        Button button = getButton();

        button.setIsActive(!button.getIsActive());

        button = repository.save(button);

        return buttonMapper.toDTO(button);
    }

    public ButtonDTO getButtonState() {
        return buttonMapper.toDTO(getButton());
    }

    private Button getButton() {
        Button button = repository.findById(1L).orElseThrow(()->new EntityNotFoundException("Button not found"));
        return button;
    }
}
