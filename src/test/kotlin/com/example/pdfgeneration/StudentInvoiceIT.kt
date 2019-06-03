package com.example.pdfgeneration

import com.example.pdfgeneration.controller.StudentInvoiceController
import com.example.pdfgeneration.model.StudentInvoice
import com.example.pdfgeneration.model.Students
import com.example.pdfgeneration.repository.StudentInvoiceJpaRepository
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest
class StudentInvoiceIT {

   @Autowired
    internal var studentInvoiceController:StudentInvoiceController?=null


    @Autowired
    internal var studentInvoiceJpaRepository:StudentInvoiceJpaRepository?=null


    @Test
    fun create(){

       /* val list = listOf<Students>(
               Students("111001","Sy5461","Ramu","89000","70%"),
                Students("111002","Sy5462","Raju","99000","65%")
        )

        val studentInvoice = StudentInvoice()
        studentInvoice.id = UUID.randomUUID().toString()
        studentInvoice.batchId= "1112233"
        studentInvoice.batchName="Mahatma"
        studentInvoice.centerId= "998877"
        studentInvoice.centerName="Sathya"
        studentInvoice.courseId="888777"
        studentInvoice.courseName="Java"
        studentInvoice.listOfStudents = list

        studentInvoiceJpaRepository?.save(studentInvoice)*/

        var id1 = UUID.randomUUID().toString()
        var id2 = UUID.randomUUID().toString()
        val list = listOf<Students>(
                Students(id1,"Sy5461","Ramu","89000","70%"),
                Students(id2,"Sy5462","Raju","99000","65%")
        )

        val studentInvoice = StudentInvoice()
        studentInvoice.id = UUID.randomUUID().toString()
        studentInvoice.batchId= "1112234"
        studentInvoice.batchName="Jawahar"
        studentInvoice.centerId= "990071"
        studentInvoice.centerName="Naresh"
        studentInvoice.courseId="888779"
        studentInvoice.courseName="Anugular"
        studentInvoice.listOfStudents = list

        studentInvoiceJpaRepository?.save(studentInvoice)

       var string= studentInvoiceController?.create(studentInvoice)

        //Assert.assertEquals(true, studentInvoice!=null)

    }


    @Test
    fun findById(){
        val id ="15f17044-857b-4b0f-a981-fe7fc2e74f31"
       val invoice = studentInvoiceController?.getById(id)

        print(invoice)
        Assert.assertEquals(true, invoice!=null)
    }

    @Test
    fun generatePdf(){
        val id ="15f17044-857b-4b0f-a981-fe7fc2e74f31"

       var string = studentInvoiceController?.pdfReport(id)

    }


}
