package com.bigcamera.backend.product

import com.bigcamera.backend.category.CategoryRepo
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val categoryRepo: CategoryRepo,
    private val productRepo: ProductRepo
) {



}