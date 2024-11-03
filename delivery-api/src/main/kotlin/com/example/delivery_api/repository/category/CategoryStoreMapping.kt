package com.example.delivery_api.repository.category

import jakarta.persistence.*

@Entity
@Table(name = "category_store_mappings", schema = "food_delivery")
class CategoryStoreMapping(
    @Id
    @Column(name = "category_store_mapping_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val categoryStoreMappingId: Long,

    @Column(name = "category_id", nullable = false)
    val categoryId: Long,

    @Column(name = "store_id", nullable = false)
    val storeId: Long,
)