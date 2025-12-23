package com.bigcamera.backend.product

import com.bigcamera.backend.category.Category
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.math.BigDecimal
import java.util.UUID

@Entity
@Table(name = "products")
class Product (

    @Column(name = "name", length = 100, nullable = false)
    var name: String,

    @Column(name = "description", columnDefinition = "text")
    var description: String? = null,

    @Column(name = "price", precision = 19, scale = 2, nullable = false)
    var price: BigDecimal = BigDecimal.ZERO,

    @JoinColumn(name = "category_id", nullable = false, referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    var category: Category,

    @OneToMany(mappedBy = "product", orphanRemoval = true, cascade = [(CascadeType.ALL)], fetch = FetchType.LAZY)
    var details: MutableList<ProductDetail> = mutableListOf()

) {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    val id: UUID? = null

}