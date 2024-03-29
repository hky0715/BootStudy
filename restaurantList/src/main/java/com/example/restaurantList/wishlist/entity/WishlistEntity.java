package com.example.restaurantList.wishlist.entity;

import com.example.restaurantList.db.MemoryDbEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WishlistEntity extends MemoryDbEntity {

    private String title;                   // 음식명, 장소명
    private String category;                // 음식 카테고리
    private String address;                 // 주소
    private String roadAddress;             // 도로명주소
    private String homePageLink;            // 홈페이지주소
    private String imageLink;               // 음식, 가게 이미지 주소
    private boolean isVisit;                // 방문여부
    private int visitCount;                 // 방문횟수 카운트
    private LocalDateTime lastVisitDate;    // 방문일자


}
