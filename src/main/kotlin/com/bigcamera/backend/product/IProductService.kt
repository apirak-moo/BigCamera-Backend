package com.bigcamera.backend.product

import java.util.UUID

interface IProductService {
    fun getAllProducts(): List<ProductResponse>
    fun findProductById(id: UUID): ProductResponse
    fun createProduct(request: ProductRequest): ProductResponse
    fun updateProduct(id: UUID, request: ProductRequest)
    fun deleteProduct(id: UUID)
}