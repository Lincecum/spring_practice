package com.example.delivery_api.service.store


import com.example.delivery_api.domain.store.CategoryStore
import com.example.delivery_api.repository.store.Store
import com.example.delivery_api.repository.store.StoreRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class StoreService(
    private val storeRepository: StoreRepository
) {
    fun findByStoreId(storeId: Long): Optional<Store> {
        return storeRepository.findById(storeId)
    }

    fun findByCategoryId(categoryId: Long): List<CategoryStore> {
        return storeRepository.findAllByCategoryId(categoryId)
    }

    fun findByCategoryIdAndReviewGrade(categoryId: Long, reviewGradeFilterValue: Int): List<CategoryStore> {
        return storeRepository.findAllByCategoryIdAndReviewGrade(categoryId, reviewGradeFilterValue)
    }
}