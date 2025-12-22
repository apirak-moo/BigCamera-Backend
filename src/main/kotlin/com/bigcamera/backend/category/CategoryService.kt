package com.bigcamera.backend.category

import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.stereotype.Service

@Service
class CategoryService(private val categoryRepo: CategoryRepo) : ICategoryService {

    override fun findAll(): List<Category> {
        return categoryRepo.findAll()
    }

    override fun findById(id: Int): Category {
        return categoryRepo.findById(id).orElseThrow {
            ChangeSetPersister.NotFoundException()
        }
    }

    override fun create(request: CategoryRequest): Category {
        return categoryRepo.save(create(request))
    }

    override fun updateById(id: Int, request: CategoryRequest) {
        val category = findById(id)
        category.name = request.name
        categoryRepo.save(category)
    }

    override fun deleteById(id: Int) {
        val category = findById(id)
        categoryRepo.delete(category)
    }

}