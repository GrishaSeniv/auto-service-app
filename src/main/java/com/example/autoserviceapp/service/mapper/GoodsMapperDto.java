package com.example.autoserviceapp.service.mapper;

import com.example.autoserviceapp.dto.request.GoodsRequestDto;
import com.example.autoserviceapp.dto.response.GoodsResponseDto;
import com.example.autoserviceapp.model.Goods;
import org.springframework.stereotype.Component;

@Component
public class GoodsMapperDto {
    public Goods toModel(GoodsRequestDto goodsRequestDto) {
        Goods goods = new Goods();
        goods.setName(goodsRequestDto.getName());
        goods.setPrice(goodsRequestDto.getPrice());
        return goods;
    }

    public GoodsResponseDto toDto(Goods goods) {
        GoodsResponseDto goodsResponseDto = new GoodsResponseDto();
        goodsResponseDto.setId(goods.getId());
        goodsResponseDto.setName(goods.getName());
        goodsResponseDto.setPrice(goods.getPrice());
        return goodsResponseDto;
    }
}
