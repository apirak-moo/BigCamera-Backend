package com.bigcamera.backend.category

import com.bigcamera.backend.product.Product
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "categories")
class Category (

    @Column(name = "name", length = 30, nullable = false)
    var name: String,

) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Int? = null

    @OneToMany(mappedBy = "category", orphanRemoval = true, cascade = [(CascadeType.ALL)])
    val products: MutableList<Product> = mutableListOf()

}