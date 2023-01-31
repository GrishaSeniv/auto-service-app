package com.example.autoserviceapp.controller;

import com.example.autoserviceapp.dto.request.GoodsRequestDto;
import com.example.autoserviceapp.dto.response.GoodsResponseDto;
import com.example.autoserviceapp.model.Goods;
import com.example.autoserviceapp.service.GoodsService;
import com.example.autoserviceapp.service.mapper.GoodsMapperDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    private final GoodsService service;
    private final GoodsMapperDto mapperDto;

    public GoodsController(GoodsService service, GoodsMapperDto mapperDto) {
        this.service = service;
        this.mapperDto = mapperDto;
    }

    @PostMapping
    @ApiOperation(value = "Save goods to db")
    public GoodsResponseDto save(GoodsRequestDto goodsRequestDto) {
        Goods goods = service.save(mapperDto.toModel(goodsRequestDto));
        return mapperDto.toDto(goods);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update good in db")
    public GoodsResponseDto update(GoodsRequestDto goodsRequestDto,
                                   @PathVariable
                                   @ApiParam(value = "Write the goods id you want to update")
                                           Long id) {
        Goods goods = mapperDto.toModel(goodsRequestDto);
        goods.setId(id);
        return mapperDto.toDto(service.update(goods));
    }
}
