package com.example.restaurantList.wishlist.service;

import com.example.restaurantList.naver.NaverClient;
import com.example.restaurantList.naver.dto.SearchImageReq;
import com.example.restaurantList.naver.dto.SearchLocalReq;
import com.example.restaurantList.wishlist.dto.WishlistDto;
import com.example.restaurantList.wishlist.entity.WishlistEntity;
import com.example.restaurantList.wishlist.repository.WishlistRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WishlistService {

    private final NaverClient naverClient;
    private static final WishlistRepository wishlistRepository;


    public WishlistDto search(String query) {
        // 지역 검색
        var searchLocalReq = new SearchLocalReq();
        searchLocalReq.setQuery(query);

        var searchLocalRes = naverClient.searchLocal(searchLocalReq);

        if (searchLocalRes.getTotal() > 0) {
            var localItem = searchLocalRes.getItems().stream().findFirst().get();

            var imageQuery = localItem.getTitle().replaceAll("<[^>]*>", "");
            var searchImageReq = new SearchImageReq();
            searchImageReq.setQuery(imageQuery);

            var searchImageRes = naverClient.searchImage(searchImageReq);
            if (searchImageRes.getTotal() > 0) {
                var imageItem = searchImageRes.getItems().stream().findFirst().get();

                // 결과물 리턴... 어떤것을????
                var result = new WishlistDto();
                result.setTitle(localItem.getTitle());
                result.setCategory(localItem.getCategory());
                result.setAddress(localItem.getAddress());
                result.setRoadAddress(localItem.getRoadAddress());
                result.setHomePageLink(localItem.getLink());
                result.setImageLink(imageItem.getLink());

                return result;
            }
        }

        return new WishlistDto();

        // 이미지 검색
        // 결과물 리턴
    }

    public WishlistDto add(WishlistDto wishlistDto) {
        var entity = dtoToEntity(wishlistDto);
        var saveEntity = wishlistRepository.save(entity);

        return entityToDto(saveEntity);
    }

    private WishlistEntity dtoToEntity(WishlistDto wishlistDto) {
        var entity = new WishlistEntity();
        entity.setTitle(wishlistDto.getTitle());
        entity.setCategory(wishlistDto.getCategory());
        entity.setIndex(wishlistDto.getIndex());
        entity.setAddress(wishlistDto.getAddress());
        entity.setRoadAddress(wishlistDto.getRoadAddress());
        entity.setHomePageLink(wishlistDto.getHomePageLink());
        entity.setImageLink(wishlistDto.getImageLink());
        entity.setVisit(wishlistDto.isVisit());
        entity.setVisitCount(wishlistDto.getVisitCount());
        entity.setLastVisitDate(wishlistDto.getLastVisitDate());

        return entity;
    }

    private static WishlistDto entityToDto(WishlistEntity wishlistEntity) {
        var dto = new WishlistDto();
        dto.setTitle(wishlistEntity.getTitle());
        dto.setCategory(wishlistEntity.getCategory());
        dto.setIndex(wishlistEntity.getIndex());
        dto.setAddress(wishlistEntity.getAddress());
        dto.setRoadAddress(wishlistEntity.getRoadAddress());
        dto.setHomePageLink(wishlistEntity.getHomePageLink());
        dto.setImageLink(wishlistEntity.getImageLink());
        dto.setVisit(wishlistEntity.isVisit());
        dto.setVisitCount(wishlistEntity.getVisitCount());
        dto.setLastVisitDate(wishlistEntity.getLastVisitDate());

        return dto;


    }

}
