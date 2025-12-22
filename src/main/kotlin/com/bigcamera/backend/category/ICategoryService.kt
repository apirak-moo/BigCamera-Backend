package com.bigcamera.backend.category

interface ICategoryService {
    fun findAll(): List<Category>
    fun findById(id: Int): Category?
    fun create(request: CategoryRequest): Category
    fun updateById(request: CategoryRequest)
    fun deleteById(id: Int)
}