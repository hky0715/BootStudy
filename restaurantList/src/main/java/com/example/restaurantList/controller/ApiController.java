package com.example.restaurantList.controller;

import com.example.restaurantList.wishlist.dto.WishlistDto;
import com.example.restaurantList.wishlist.service.WishlistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
public class ApiController {

    private final WishlistService wishlistService;

    @GetMapping("/search")
    public WishlistDto search(@RequestParam String query) {
        return wishlistService.search(query);
    }

    @PostMapping("")
    public WishlistDto add(@RequestBody WishlistDto wishlistDto) {
      log.info("{}", wishlistDto);

      return WishlistService.add(wishlistDto);
    }
}
