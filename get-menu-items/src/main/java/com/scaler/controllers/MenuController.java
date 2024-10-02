package com.scaler.controllers;

import com.scaler.dtos.*;
import com.scaler.models.MenuItem;
import com.scaler.services.MenuService;

import java.util.List;
import java.util.Optional;

public class MenuController {

    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }


    public GetMenuItemsResponseDto getMenuItems(GetMenuItemsRequestDto requestDto){
    GetMenuItemsResponseDto dto = new GetMenuItemsResponseDto();
    try {
        List<MenuItem> menuItem = menuService.getMenuItems(requestDto.getDietaryRequirement());
        dto.setMenuItems(menuItem);
        dto.setResponseStatus(ResponseStatus.SUCCESS);
    } catch (Exception e) {
        dto.setResponseStatus(ResponseStatus.FAILURE);
    }
        return dto;
    }
}
