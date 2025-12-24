package com.bigcamera.backend.product

import org.springframework.data.jpa.domain.Specification
import java.math.BigDecimal
import java.util.UUID

object ProductSpecification {

    fun nameConstraints(name: String?): Specification<Product> {
        return Specification { root, _, cb ->
            if(name.isNullOrBlank()) {
                cb.conjunction()
            }
            else {
                cb.like(cb.lower(root.get("name")), "%${name.lowercase()}%")
            }
        }
    }

    fun priceBetween(min: BigDecimal?, max: BigDecimal?): Specification<Product> {
        return Specification { root, _, cb ->
            when {
                min != null && max != null ->
                    cb.between(root.get("price"), min, max)
                min != null ->
                    cb.greaterThanOrEqualTo(root.get("price"), min)
                max != null ->
                    cb.lessThanOrEqualTo(root.get("price"), max)
                else ->
                    cb.conjunction()
            }
        }
    }

    fun categoryId(id: Int?): Specification<Product> {
        return Specification { root, _, cb ->
            if(id == null) {
                cb.conjunction()
            }
            else{
                cb.equal(root.get<Product>("category").get<UUID>("id"), id)
            }
        }
    }

}