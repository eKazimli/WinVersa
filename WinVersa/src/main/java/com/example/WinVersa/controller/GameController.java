package com.example.WinVersa.controller;

import com.example.WinVersa.service.GameService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/v1/games")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GameController {
    GameService gameService;


}
