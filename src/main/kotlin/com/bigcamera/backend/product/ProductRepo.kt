package com.bigcamera.backend.product

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ProductRepo : JpaRepository<Product, UUID> {

}