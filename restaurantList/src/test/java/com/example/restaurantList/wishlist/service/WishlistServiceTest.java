package com.example.restaurantList.wishlist.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WishlistServiceTest {

    @Autowired
    private WishlistService wishlistService;

    @Test
    public void searchTest() {
        var result = wishlistService.search("갈비찜");

        System.out.println(result);
        Assertions.assertNotNull(result);
    }
}