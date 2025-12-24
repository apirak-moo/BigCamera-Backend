package com.bigcamera.backend.product

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.UUID

interface IProductService {
    fun findAllProducts(search: ProductSearch, pageable: Pageable): Page<Product>
    fun findProductById(id: UUID): Product
    fun createProduct(request: ProductRequest): Product
    fun updateProduct(id: UUID, request: ProductRequest)
    fun deleteProduct(id: UUID)
}