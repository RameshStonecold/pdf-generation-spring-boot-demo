package com.example.pdfgeneration.repository

import com.example.pdfgeneration.model.StudentInvoice
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query

interface StudentInvoiceJpaRepository : MongoRepository<StudentInvoice, String> {

    @Query(value = "{'id':?0}")
    fun findById_id(id:String):StudentInvoice
}
