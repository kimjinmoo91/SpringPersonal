package com.sparta.week04.utils.models;

import lombok.Getter;
import org.json.JSONObject;

@Getter
//private는 자유롭게 꺼내쓸 수 없기 대문에 Getter.
public class ItemDto {
    private String title;
    private String link;
    private String image;
    private int lprice;

    public ItemDto(JSONObject itemJson) {
        this.title = itemJson.getString("title");
        this.link = itemJson.getString("link");
        this.image = itemJson.getString("image");
        this.lprice = itemJson.getInt("lprice");
    }
}