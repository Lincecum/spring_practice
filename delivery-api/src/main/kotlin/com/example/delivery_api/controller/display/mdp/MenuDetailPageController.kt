package com.example.delivery_api.controller.display.mdp

import com.example.delivery_api.domain.catalog.menu.MenuStatus
import com.example.delivery_api.exception.MenuNotFoundException
import com.example.delivery_api.service.menu.MenuService
import com.example.delivery_api.controller.display.mdp.dto.MenuDetailPageResponse

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@Tag(name = "MenuDetailPageController", description = "메뉴 상세 페이지 컨트롤러")
@RestController
class MenuDetailPageController (
    private val menuService: MenuService,
){
    @GetMapping("display/menus/{menuId}")
    fun detail(@PathVariable menuId: Long): MenuDetailPageResponse {
        val menuOptional = menuService.findByMenuId(menuId)
        if (menuOptional.isEmpty){
            throw MenuNotFoundException("요청하신 메뉴 정보를 찾을 수 없습니다. ${menuId}")
        }
        val menu = menuOptional.get()
        return MenuDetailPageResponse(
            menuId = menuId,
            menuName = menu.menuName,
            storeId = menu.storeId,
            description = menu.description,
            menuMainImageUrl = menu.menuMainImageUrl,
            price = menu.price,
            menuStatue = MenuStatus.SALE,
        )
    }
}