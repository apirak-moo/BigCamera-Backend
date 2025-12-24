package com.bigcamera.backend.product

import java.util.UUID

interface IProductService {
    fun getAllProducts(): List<Product>
    fun findProductById(id: UUID): Product
    fun createProduct(request: ProductRequest): Product
    fun updateProduct(id: UUID, request: ProductRequest)
    fun deleteProduct(id: UUID)
}