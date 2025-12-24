package com.bigcamera.backend.category

import org.springframework.data.jpa.domain.Specification

object CategorySpecification {

    fun nameContains(name: String?) : Specification<Category>? {
        if(name.isNullOrEmpty())
            return null
        return Specification { root, _, cb ->
            cb.like(cb.lower(root.get("name")), "%${name.lowercase()}%")
        }
    }

}