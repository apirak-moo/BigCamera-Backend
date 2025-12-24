package com.bigcamera.backend.mappers

import com.bigcamera.backend.product.Product
import com.bigcamera.backend.product.ProductDetail
import com.bigcamera.backend.product.ProductDetailResponse
import com.bigcamera.backend.product.ProductResponse

fun Product.toProductResponse(): ProductResponse {
    return ProductResponse(
        id = this.id!!,
        name = this.name,
        description = this.description,
        price = this.price,
        details = this.details.toListProductDetailResponse(),
        createAt = this.createdAt,
        updateAt = this.updatedAt,
    )
}

fun List<Product>.toListProductResponse(): List<ProductResponse> {
    return map { it.toProductResponse() }
}

fun ProductDetail.toProductDetailResponse(): ProductDetailResponse {
    return ProductDetailResponse(
        id = this.id!!,
        name = this.name,
        value = this.value,
    )
}

fun List<ProductDetail>.toListProductDetailResponse(): List<ProductDetailResponse> {
    return map { it.toProductDetailResponse() }
}