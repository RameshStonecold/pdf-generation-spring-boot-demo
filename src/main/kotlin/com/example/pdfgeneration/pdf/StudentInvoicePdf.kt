package com.example.pdfgeneration.pdf

import com.example.pdfgeneration.model.StudentInvoice
import com.itextpdf.text.*
import java.io.ByteArrayInputStream
import org.bouncycastle.util.Strings.toByteArray
import com.itextpdf.text.pdf.PdfPCell
import jdk.nashorn.internal.objects.NativeArray.forEach
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter
import org.springframework.stereotype.Component
import java.io.ByteArrayOutputStream
import java.io.FileOutputStream
import java.util.stream.Stream

class StudentInvoicePdf {


    fun pdfGeneration(studentInvoice: StudentInvoice):ByteArrayInputStream{

        val document = Document()
        val out = ByteArrayOutputStream()

        //FileOutputStream("/home/ramesh/HelloWorld.pdf")
        try {

            PdfWriter.getInstance(document, out)
            document.open()

            // Add Text to PDF file ->
            var font1 = FontFactory.getFont(FontFactory.COURIER_BOLD)
          //  val font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK)
            val headingPara = Paragraph("Student Invoice", font1)
            headingPara.alignment = Element.ALIGN_CENTER
            document.add(headingPara)
            document.add(Chunk.NEWLINE)


            var font2 = FontFactory.getFont(FontFactory.TIMES_ROMAN)

            val invoiceId = Paragraph("Student Invoice Id"+" : "+studentInvoice.id, font2)
            invoiceId.alignment = Element.ALIGN_CENTER
            document.add(invoiceId)
            document.add(Chunk.NEWLINE)

            val batchId = Paragraph("Batch Id"+" : "+studentInvoice.batchId, font2)
            batchId.alignment = Element.ALIGN_CENTER
            document.add(batchId)
            document.add(Chunk.NEWLINE)

            val batchName = Paragraph("Batch Name"+" : "+studentInvoice.batchName, font2)
            batchName.alignment = Element.ALIGN_CENTER
            document.add(batchName)
            document.add(Chunk.NEWLINE)

            val courseId = Paragraph("Course Id"+" : "+studentInvoice.courseId, font2)
            courseId.alignment = Element.ALIGN_CENTER
            document.add(courseId)
            document.add(Chunk.NEWLINE)

            val courseName = Paragraph("Course Name"+" : "+studentInvoice.courseName, font2)
            courseName.alignment = Element.ALIGN_CENTER
            document.add(courseName)
            document.add(Chunk.NEWLINE)

            val centerId = Paragraph("Center Id"+" : "+studentInvoice.centerId, font2)
            centerId.alignment = Element.ALIGN_CENTER
            document.add(centerId)
            document.add(Chunk.NEWLINE)

            val centerName = Paragraph("Center Name"+" : "+studentInvoice.centerName, font2)
            centerName.alignment = Element.ALIGN_CENTER
            document.add(centerName)
            document.add(Chunk.NEWLINE)


            val table = PdfPTable(5)
            // Add PDF Table Header ->
            Stream.of("ID","Identity No", "Name", "Amount", "Attendence")
                    .forEach { headerTitle ->
                        val header = PdfPCell()
                        val headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD)
                        header.backgroundColor = BaseColor.LIGHT_GRAY
                        header.horizontalAlignment = Element.ALIGN_CENTER
                        header.borderWidth = 2f
                        header.phrase = Phrase(headerTitle, headFont)
                        table.addCell(header)
                    }
          var studentList=  studentInvoice.listOfStudents
            if(studentList!=null) {
                for (student in studentList) {
                    val idCell = PdfPCell(Phrase(student.id.toString()))
                    idCell.setPaddingLeft(4f)
                    idCell.setVerticalAlignment(Element.ALIGN_MIDDLE)
                    idCell.setHorizontalAlignment(Element.ALIGN_CENTER)
                    table.addCell(idCell)

                    val identityNoCell = PdfPCell(Phrase(student.identityNo))
                    identityNoCell.setPaddingLeft(4f)
                    identityNoCell.setVerticalAlignment(Element.ALIGN_MIDDLE)
                    identityNoCell.setHorizontalAlignment(Element.ALIGN_LEFT)
                    table.addCell(identityNoCell)

                    val nameCell = PdfPCell(Phrase(student.name))
                    nameCell.setVerticalAlignment(Element.ALIGN_MIDDLE)
                    nameCell.setHorizontalAlignment(Element.ALIGN_RIGHT)
                    nameCell.setPaddingRight(4f)
                    table.addCell(nameCell)

                    val amountCell = PdfPCell(Phrase(student.amount))
                    amountCell.setVerticalAlignment(Element.ALIGN_MIDDLE)
                    amountCell.setHorizontalAlignment(Element.ALIGN_RIGHT)
                    amountCell.setPaddingRight(4f)
                    table.addCell(amountCell)

                    val attendenceCell = PdfPCell(Phrase(student.attendence))
                    attendenceCell.setVerticalAlignment(Element.ALIGN_MIDDLE)
                    attendenceCell.setHorizontalAlignment(Element.ALIGN_RIGHT)
                    attendenceCell.setPaddingRight(4f)
                    table.addCell(attendenceCell)

                }
            }
            document.add(table)

            document.close()
        } catch (e: DocumentException) {
           // logger.error(e.toString())
        }


        return ByteArrayInputStream(out.toByteArray())

    }

}
