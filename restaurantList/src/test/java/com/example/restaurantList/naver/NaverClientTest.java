package com.example.restaurantList.naver;

import com.example.restaurantList.naver.dto.SearchLocalReq;
import com.example.restaurantList.naver.dto.SearchImageReq;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class NaverClientTest {

    @Autowired
    private NaverClient naverClient;


    @Test
    public void searchLocalTest() {
        var search = new SearchLocalReq();
        search.setQuery("갈비집");

        var result = naverClient.searchLocal(search);

        Assertions.assertNotNull(result.getItems().stream().findFirst().get().getCategory());
        System.out.println(result);

    }

    @Test
    public void searchImageTest() {
        var search = new SearchImageReq();
        search.setQuery("갈비집");

        var result = naverClient.searchImage(search);
        System.out.println(result);

    }
}