package com.example.proyectdg.model

import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
@Table(name="detail")

class Detail  {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @NotNull
    var quantity: Long? = null
    @Column(name="product_id")
    @NotNull
    var productId: Long?=null
    @Column(name="invoice_id")
    @NotNull
    var invoiceId: Long?=null
}