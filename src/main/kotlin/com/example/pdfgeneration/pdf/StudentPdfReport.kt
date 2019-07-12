package com.example.pdfgeneration.pdf

import com.example.pdfgeneration.model.StudentInvoice
import com.itextpdf.text.*
import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.util.stream.Stream
import com.itextpdf.text.Phrase
import com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table





class StudentPdfReport {


   fun generatePdf(studentInvoice: StudentInvoice) : ByteArrayInputStream {

       val document = Document()
       val out = ByteArrayOutputStream()

       try{
           PdfWriter.getInstance(document, out)
           document.open()

           var font1 = FontFactory.getFont(FontFactory.COURIER_BOLD)
           val headingPara = Paragraph("Invoice Deatails", font1)
           headingPara.alignment = Element.ALIGN_LEFT
           document.add(headingPara)
           document.add(Chunk.NEWLINE)

           val invoiceDate = Paragraph(""+studentInvoice.createdDate, font1)
           invoiceDate.alignment = Element.ALIGN_RIGHT
           document.add(invoiceDate)
           document.add(Chunk.NEWLINE)


           val table = PdfPTable(3)
           table.widthPercentage = 60f
           table.setWidths(intArrayOf(3, 3, 3,3))

           val headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD)

           var hcell: PdfPCell
           hcell = PdfPCell(Phrase("Invoice No", headFont))
           hcell.verticalAlignment=Element.ALIGN_LEFT
           hcell.paddingLeft=3f
           //hcell.horizontalAlignment = Element.ALIGN_CENTER
           table.addCell(hcell)

           hcell = PdfPCell(Phrase("Batch Name", headFont))
           hcell.verticalAlignment=Element.ALIGN_LEFT
          // hcell.horizontalAlignment = Element.ALIGN_CENTER
           table.addCell(hcell)

           hcell = PdfPCell(Phrase("Course Name", headFont))
           hcell.verticalAlignment=Element.ALIGN_LEFT
          // hcell.horizontalAlignment = Element.ALIGN_CENTER
           table.addCell(hcell)

           hcell = PdfPCell(Phrase("Center Name", headFont))
           hcell.verticalAlignment=Element.ALIGN_LEFT
         //  hcell.horizontalAlignment = Element.ALIGN_CENTER
           table.addCell(hcell)




        /*   val table1 = PdfPTable(5)
           // Add PDF Table Header ->
           Stream.of("Invoice No","Batch Name", "Course Name", "Center Name")
                   .forEach { headerTitle ->
                       val header = PdfPCell()
                       val headFont = FontFactory.getFont(FontFactory.TIMES_ROMAN)
                       header.backgroundColor = BaseColor.WHITE
                       header.horizontalAlignment = Element.ALIGN_CENTER
                       header.borderWidth = 1f
                       header.phrase = Phrase(headerTitle, headFont)
                       table1.addCell(header)
                   }
           document.add(Chunk.NEWLINE)

                   val idCell = PdfPCell(Phrase(studentInvoice.invoiceNo.toString()))
                   idCell.setPaddingLeft(4f)
                   idCell.setVerticalAlignment(Element.ALIGN_MIDDLE)
                   idCell.setHorizontalAlignment(Element.ALIGN_CENTER)
                   table1.addCell(idCell)

                   val batchNameCell = PdfPCell(Phrase(studentInvoice.batchName))
                   batchNameCell.setPaddingLeft(4f)
                   batchNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE)
                   batchNameCell.setHorizontalAlignment(Element.ALIGN_LEFT)
                   table1.addCell(batchNameCell)

                   val courseNameCell = PdfPCell(Phrase(studentInvoice.courseName))
                   courseNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE)
                   courseNameCell.setHorizontalAlignment(Element.ALIGN_RIGHT)
                   courseNameCell.setPaddingRight(4f)
                   table1.addCell(courseNameCell)

                   val centerNameCell = PdfPCell(Phrase(studentInvoice.centerName))
                   centerNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE)
                   centerNameCell.setHorizontalAlignment(Element.ALIGN_RIGHT)
                   centerNameCell.setPaddingRight(4f)
                   table1.addCell(centerNameCell)*/

           document.add(table)
         //  document.add(table1)
           document.add(Chunk.NEWLINE)





           document.close()
       }catch (e:DocumentException){
       }
      return ByteArrayInputStream(out.toByteArray())
   }
}
