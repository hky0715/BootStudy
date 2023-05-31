package com.example.restaurantList.wishlist.repository;

import com.example.restaurantList.wishlist.entity.WishlistEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WishlistRepositoryTest {

    @Autowired
    private WishlistRepository wishlistRepository;

    private WishlistEntity create() {
        var wishlist = new WishlistEntity();
        wishlist.setTitle("title");
        wishlist.setCategory("category");
        wishlist.setAddress("addresss");
        wishlist.setRoadAddress("road address");
        wishlist.setHomePageLink("homepage");
        wishlist.setImageLink("");
        wishlist.setVisit(false);
        wishlist.setVisitCount(0);
        wishlist.setLastVisitDate(null);

        return wishlist;
    }

    @Test
    public void save() {
        var wishlistEntity = create();
        var expected = wishlistRepository.save(wishlistEntity);

        Assertions.assertNotNull(expected);
        Assertions.assertEquals(1, expected.getIndex());

    }

    @Test
    public void update() {
        var wishlistEntity = create();
        var expected = wishlistRepository.save(wishlistEntity);

        expected.setTitle("update test");

        var saveEntity = wishlistRepository.save(expected);

        Assertions.assertEquals("update test", expected.getTitle());
        Assertions.assertEquals(1, wishlistRepository.listAll().size());

    }
    @Test
    public void findById() {

        var wishlistEntity = create();
        wishlistRepository.save(wishlistEntity);

        var expected = wishlistRepository.findById(1);

        Assertions.assertEquals(true, expected.isPresent());
        Assertions.assertEquals(1,expected.get().getIndex());

    }
    @Test
    public void deleteById() {

        var wishlistEntity = create();
        wishlistRepository.save(wishlistEntity);

        wishlistRepository.deleteById(1);

        int count = wishlistRepository.listAll().size();
        Assertions.assertEquals(0, count);
    }
    @Test
    public void listAll() {

        var wishlistEntity1 = create();
        wishlistRepository.save(wishlistEntity1);

        var wishlistEntity2 = create();
        wishlistRepository.save(wishlistEntity2);

        int count = wishlistRepository.listAll().size();
        Assertions.assertEquals(2, count);

    }
}