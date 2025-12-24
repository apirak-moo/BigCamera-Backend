package com.bigcamera.backend.category

import com.bigcamera.backend.mappers.toResponse
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping(value = ["/categories"])
class CategoryController(private val categoryService: CategoryService) {

    @GetMapping
    fun findAll(
        @ModelAttribute search: CategorySearch? = null,
    ): ResponseEntity<List<CategoryResponse>> {
        val categories = categoryService.findAll(search).toResponse()
        return ResponseEntity.ok(categories)
    }

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Int): ResponseEntity<CategoryResponse> {
        val category = categoryService.findById(id).toResponse()
        return ResponseEntity.ok().body(category)
    }

    @PostMapping
    fun create(@Valid @RequestBody request: CategoryRequest): ResponseEntity<CategoryResponse> {
        val created = categoryService.create(request).toResponse()
        val location = URI("/categories/${created.id}")
        return ResponseEntity.created(location).body(created)
    }

    @PutMapping(value = ["/{id}"])
    fun updateById(@PathVariable id: Int, @Valid @RequestBody request: CategoryRequest): ResponseEntity<HttpStatus> {
        categoryService.updateById(id, request)
        return ResponseEntity.ok().build()
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteById(@PathVariable id: Int): ResponseEntity<HttpStatus> {
        categoryService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

}