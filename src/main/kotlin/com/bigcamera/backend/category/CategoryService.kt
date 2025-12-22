package com.bigcamera.backend.category

import com.bigcamera.backend.exceptions.NotFoundException
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CategoryService(private val categoryRepo: CategoryRepo) : ICategoryService {

    override fun findAll(): List<Category> {
        return categoryRepo.findAll()
    }

    override fun findById(id: Int): Category {
        return categoryRepo.findById(id).orElseThrow {
            NotFoundException("Category Not Found")
        }
    }

    @Transactional
    override fun create(request: CategoryRequest): Category {
        return categoryRepo.save(Category(name = request.name))
    }

    @Transactional
    override fun updateById(id: Int, request: CategoryRequest) {
        val category = findById(id)
        category.name = request.name
        categoryRepo.save(category)
    }

    @Transactional
    override fun deleteById(id: Int) {
        val category = findById(id)
        categoryRepo.delete(category)
    }

}