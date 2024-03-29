package com.example.pdfgeneration.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate

@Document
class StudentInvoice {
    @Id
    var id :String?=null
    var invoiceNo:String?=null
    var createdDate:LocalDate=LocalDate.now()
    var batchId:String?=null
    var batchName:String?=null
    var courseId:String?=null
    var courseName:String?= null
    var centerId:String?=null
    var centerName:String?=null
    var listOfStudents:List<Students>?=null
}
