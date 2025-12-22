package com.bigcamera.backend.category

interface ICategoryService {
    fun findAll(): List<Category>
    fun findById(id: Int): Category
    fun create(request: CategoryRequest): Category
    fun updateById(id: Int, request: CategoryRequest)
    fun deleteById(id: Int)
}