package com.example.pdfgeneration.controller

import com.example.pdfgeneration.model.StudentInvoice
import com.example.pdfgeneration.pdf.StudentInvoicePdf
import com.example.pdfgeneration.pdf.StudentPdfReport
import com.example.pdfgeneration.repository.StudentInvoiceJpaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.InputStreamResource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.http.HttpHeaders



@RestController
class StudentInvoiceController {

    @Autowired
    var studentInvoiceJpaRepository:StudentInvoiceJpaRepository?=null


    var pdf = StudentInvoicePdf()

    var pdfreport = StudentPdfReport()

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
    fun pdfReport(@PathVariable("id") id:String) :ResponseEntity<*>{


     val   invoice = studentInvoiceJpaRepository?.findById_id(id)


        if (invoice != null) {
           var bytes = pdfreport.generatePdf(invoice)
           //var bytes = pdf.pdfGeneration(invoice)
        }
        val headers = HttpHeaders()
        headers.add("Content-Disposition", "inline; filename=studentInvoice.pdf")
        //return "Pdf report"
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(InputStreamResource(pdfreport.generatePdf(invoice!!
        )))
    }

}
