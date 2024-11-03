package com.example.delivery_api.domain.store

enum class StoreStatus(description: String) {
    INIT("신규매장 준비중"),
    READY("오픈 준비중"),
    SALE("판매 중"),
    CLOSE("영업 종료"),
}