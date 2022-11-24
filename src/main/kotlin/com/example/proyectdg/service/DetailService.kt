package com.example.proyectdg.service


import com.example.proyectdg.model.Detail
import com.example.proyectdg.repository.InvoiceRepository
import com.example.proyectdg.repository.DetailRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseCookie
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class DetailService {
    @Autowired
    lateinit var detailRepository: DetailRepository

    @Autowired
    lateinit var invoiceRepository: InvoiceRepository

    fun save (detail: Detail):Detail{
        try {
            invoiceRepository.findById(detail.invoiceId)
                    ?: throw Exception("Cliente no existe")
            return detailRepository.save(detail)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
    fun list ():List<Detail>{
        return detailRepository.findAll()
    }


    fun update(client:Detail):Detail{
        try{
            detailRepository.findById(client.id)
                    ?: throw Exception ("El Id no existe")
            return detailRepository.save(client)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }

    fun updateName(detail:Detail): Detail {
        try{
            val response = detailRepository.findById(detail.id)
                    ?: throw Exception("ID no existe")
            response.apply {
                quantity=detail.quantity
            }
            return detailRepository.save(response)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}