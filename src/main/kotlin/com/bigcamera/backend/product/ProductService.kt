package com.bigcamera.backend.product

import com.bigcamera.backend.category.CategoryRepo
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ProductService(
    private val categoryRepo: CategoryRepo,
    private val productRepo: ProductRepo
) : IProductService {

    override fun getAllProducts(): List<ProductResponse> {
        TODO("Not yet implemented")
    }

    override fun findProductById(id: UUID): ProductResponse {
        TODO("Not yet implemented")
    }

    override fun createProduct(request: ProductRequest): ProductResponse {
        TODO("Not yet implemented")
    }

    override fun updateProduct(id: UUID, request: ProductRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteProduct(id: UUID) {
        TODO("Not yet implemented")
    }

}