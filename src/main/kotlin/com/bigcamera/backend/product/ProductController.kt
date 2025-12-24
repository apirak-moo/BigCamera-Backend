package com.bigcamera.backend.product

import com.bigcamera.backend.mappers.toListProductResponse
import com.bigcamera.backend.mappers.toProductResponse
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import java.util.UUID

@RestController
@RequestMapping("/products")
class ProductController(private val productService: ProductService) {

    @GetMapping
    fun findAll(): ResponseEntity<List<ProductResponse>> {
        val products = productService.findAllProducts().toListProductResponse()
        return ResponseEntity.ok(products)
    }

    @GetMapping(path = ["/{id}"])
    fun findProductById(@PathVariable("id") id: UUID): ResponseEntity<ProductResponse> {
        val product = productService.findProductById(id).toProductResponse()
        return ResponseEntity.ok(product)
    }

    @PostMapping
    fun createProduct(@Valid @RequestBody request: ProductRequest): ResponseEntity<ProductResponse> {
        val product = productService.createProduct(request).toProductResponse()
        val location = URI.create("/products/${product.id}")
        return ResponseEntity.created(location).body(product)
    }

    @PutMapping(path = ["/{id}"])
    fun updateProduct(@PathVariable("id") id: UUID, @Valid @RequestBody request: ProductRequest): ResponseEntity<ProductResponse> {
        productService.updateProduct(id, request)
        return ResponseEntity.ok().build()
    }

    @DeleteMapping(path = ["/{id}"])
    fun deleteProductById(@PathVariable("id") id: UUID): ResponseEntity<ProductResponse> {
        productService.deleteProduct(id)
        return ResponseEntity.noContent().build()
    }

}