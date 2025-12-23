package com.bigcamera.backend.category

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepo : JpaRepository<Category, Int> {

}