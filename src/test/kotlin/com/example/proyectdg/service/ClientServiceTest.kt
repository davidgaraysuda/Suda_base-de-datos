package com.example.proyectdg.service

import com.example.proyectdg.model.Client
import com.example.proyectdg.repository.ClientRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest

class ClientServiceTest {
    @InjectMocks
    lateinit var clientService: ClientService
    @Mock
    lateinit var clientRepository: ClientRepository

    val clientMock = Client().apply {
        id=1
        nui="0301707030"
        fullname="Juan"
        address= "Ceunca"
    }

    @Test
    fun saveClientWhenIsCorrect(){
        Mockito.`when`(clientRepository.save(Mockito.any(Client::class.java))).thenReturn(clientMock)
        val response = clientService.save(clientMock)
        Assertions.assertEquals(response.id, clientMock.id)
    }

    @SpringBootTest
    class ClientServiceTest {

        @InjectMocks
        lateinit var clientService: ClientService

        @Mock
        lateinit var clientRepository: ClientRepository

        val clientMock = Client().apply {
            id=1
            nui="0301707030"
            fullname="Juan"
            address= "Ceunca"
        }

        @Test
        fun saveClientCorrect(){
            Mockito.`when`(clientRepository.save(Mockito.any(Client::class.java))).thenReturn(clientMock)
            val response = clientService.save(clientMock)
            Assertions.assertEquals(response.id, clientMock.id)
        }

        @Test
        fun saveClientWhenFullnameIsBlank(){
            Assertions.assertThrows(Exception::class.java) {
                clientMock.apply { fullname=" "}
                Mockito.`when`(clientRepository.save(Mockito.any(Client::class.java))).thenReturn(clientMock)
                clientService.save(clientMock)
            }

        }
    }
}