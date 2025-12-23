package com.bigcamera.backend.mappers

import com.bigcamera.backend.product.Product
import com.bigcamera.backend.product.ProductDetail
import com.bigcamera.backend.product.ProductDetailResponse
import com.bigcamera.backend.product.ProductResponse

fun Product.toProductResponse(product: Product): ProductResponse {
    return ProductResponse(
        id = product.id!!,
        name = product.name,
        description = product.description,
        price = product.price,
    )
}

fun Product.toList(productDetails: List<ProductDetail>): List<ProductDetailResponse> {
    return productDetails.map { toProductDetailResponse(it) }
}

fun Product.toProductDetailResponse(detail: ProductDetail): ProductDetailResponse {
    return ProductDetailResponse(
        id = detail.id!!,
        name = detail.name,
        value = detail.value,
    )
}

fun Product.toListProductDetailResponse(details: List<ProductDetail>): List<ProductDetailResponse> {
    return details.map { toProductDetailResponse(it) }
}