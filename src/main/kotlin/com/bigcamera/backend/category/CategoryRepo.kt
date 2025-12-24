package com.bigcamera.backend.category

import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepo : JpaRepository<Category, Int>, JpaSpecificationExecutor<Category> {
    override fun findAll(spec: Specification<Category>) : List<Category>
}