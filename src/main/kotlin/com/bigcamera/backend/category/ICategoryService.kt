package com.bigcamera.backend.category

interface ICategoryService {
    fun findAll(): List<Category>
    fun findById(id: Int): Category?
    fun create(category: Category): Category
    fun updateById(category: Category)
    fun deleteById(id: Int)
}