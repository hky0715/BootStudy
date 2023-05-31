package com.example.board.controller;

import com.example.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basic/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;


}
