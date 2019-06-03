package com.example.pdfgeneration.controller

import com.example.pdfgeneration.model.StudentInvoice
import com.example.pdfgeneration.pdf.StudentInvoicePdf
import com.example.pdfgeneration.repository.StudentInvoiceJpaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class StudentInvoiceController {

    @Autowired
    var studentInvoiceJpaRepository:StudentInvoiceJpaRepository?=null


    var pdf = StudentInvoicePdf()

    @PostMapping("/createStudentInvoice")
    fun create(@RequestBody studentInvoice: StudentInvoice): String? {

        studentInvoiceJpaRepository?.save(studentInvoice)

        return studentInvoice.id
    }

    @GetMapping("getById/{id}")
    fun getById(@PathVariable("id") id:String): StudentInvoice? {

        return studentInvoiceJpaRepository?.findById_id(id)

    }

    @GetMapping("generatePDFreport/{id}")
    fun pdfReport(@PathVariable("id") id:String) :String{


     val   invoice = studentInvoiceJpaRepository?.findById_id(id)

        if (invoice != null) {
            pdf.pdfGeneration(invoice)
        }

        return "Pdf report"
    }

}
