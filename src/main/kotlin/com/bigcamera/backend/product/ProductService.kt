package com.bigcamera.backend.product

import com.bigcamera.backend.category.CategoryService
import com.bigcamera.backend.exceptions.NotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class ProductService(
    private val categoryService: CategoryService,
    private val productRepo: ProductRepo,
) : IProductService {

    override fun findAllProducts(): List<Product> {
        return productRepo.findAll()
    }

    override fun findProductById(id: UUID): Product {
        return productRepo.findById(id).orElseThrow {
            NotFoundException("Product not found.")
        }
    }

    @Transactional
    override fun createProduct(request: ProductRequest): Product {
        val category = categoryService.findById(request.categoryId)
        val product = Product(
            name = request.name,
            description = request.description,
            price = request.price,
            category = category,
        )
        request.details?.forEach {
            product.details.add(
                ProductDetail(
                    name = it.name,
                    value = it.value,
                    product = product
                )
            )
        }
        return productRepo.save(product)
    }

    @Transactional
    override fun updateProduct(id: UUID, request: ProductRequest) {
        val product = findProductById(id)
        product.name = request.name
        product.description = request.description
        product.price = request.price
        val category = categoryService.findById(request.categoryId)
        product.category = category
        product.details.clear()
        request.details?.forEach {
            product.details.add(
                ProductDetail(
                    name = it.name,
                    value = it.value,
                    product = product
                )
            )
        }
        productRepo.save(product)
    }

    @Transactional
    override fun deleteProduct(id: UUID) {
        val product = findProductById(id)
        productRepo.delete(product)
    }

}