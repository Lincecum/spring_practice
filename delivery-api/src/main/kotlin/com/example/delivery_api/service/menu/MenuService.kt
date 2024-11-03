package com.example.delivery_api.service.menu

import com.example.delivery_api.repository.menu.Menu
import com.example.delivery_api.repository.menu.MenuRepository
import java.util.*
import org.springframework.stereotype.Service

@Service
class MenuService(
    private val menuRepository: MenuRepository
) {
    fun findByStoreId(storeId: Long): List<Menu>{
        return menuRepository.findAllByStoreId(storeId)
    }

    fun findByMenuId(menuId: Long): Optional<Menu> {
        return menuRepository.findById(menuId)
    }
}