package com.bigcamera.backend.product

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ProductDetailRepo : JpaRepository<ProductDetail, UUID> {

}