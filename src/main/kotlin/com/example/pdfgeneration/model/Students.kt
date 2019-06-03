package com.example.pdfgeneration.model

import org.springframework.data.mongodb.core.mapping.Document

@Document
class Students {

    var id:String?=null
    var identityNo:String?=null
    var name:String?=null
    var amount:String?=null
    var attendence:String?=null

    constructor(id:String, identityNo:String,name:String, amount:String, attendence:String) {
        this.id = id
        this.identityNo=identityNo
        this.name=name
        this.amount=amount
        this.attendence=attendence
    }
}
