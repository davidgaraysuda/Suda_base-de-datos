package com.example.proyectdg.controller

import com.example.proyectdg.model.Client
import com.example.proyectdg.service.ClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/client")

class ClientController {
    @Autowired
    lateinit var clientService: ClientService

    @PostMapping
    fun save (@RequestBody @Valid client:Client):Client{
        return clientService.save(client)
    }

    @GetMapping
    fun list ():List<Client>{
        return clientService.list()
    }

    @PutMapping
    fun update (@RequestBody @Valid client:Client):ResponseEntity<Client>{
        return ResponseEntity(clientService.update(client), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName (@RequestBody @Valid client:Client): ResponseEntity<Client>{
        return ResponseEntity(clientService.updateName(client), HttpStatus.OK)
    }
}