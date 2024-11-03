package com.example.delivery_api.controller.display.mdp.dto

import com.example.delivery_api.domain.catalog.menu.MenuStatus
import java.math.BigDecimal

data class MenuDetailPageResponse(
    val menuId: Long,
    val menuName: String,
    val storeId: Long,
    val description: String,
    val menuMainImageUrl: String,
    val price: BigDecimal,
    val menuStatue: MenuStatus,
)