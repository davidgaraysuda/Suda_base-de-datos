package com.example.proyectdg.service

import com.example.proyectdg.model.Product
import com.example.proyectdg.repository.ProductRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest

class ProductServiceTest {

    @InjectMocks
    lateinit var productService: ProductService

    @Mock
    lateinit var productRepository: ProductRepository

    val productMock = Product().apply {
        id=1
        description="0301707030"
        brand="Juan"
        stock= 90
        price=900.00
    }

    @Test
    fun saveProductCorrect(){
        Mockito.`when`(productRepository.save(Mockito.any(Product::class.java))).thenReturn(productMock)
        val response = productService.save(productMock)
        Assertions.assertEquals(response.id, productMock.id)
    }

    @Test
    fun saveProductWhenDescriptionIsBlank(){
        Assertions.assertThrows(Exception::class.java) {
            productMock.apply { description=" "}
            Mockito.`when`(productRepository.save(Mockito.any(Product::class.java))).thenReturn(productMock)
            productService.save(productMock)
        }

    }

    @Test
    fun saveProductWhenStockIsZero(){
        Assertions.assertThrows(Exception::class.java) {
            productMock.apply { stock=0}
            Mockito.`when`(productRepository.save(Mockito.any(Product::class.java))).thenReturn(productMock)
            productService.save(productMock)
        }

    }
}
