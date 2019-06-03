package com.example.pdfgeneration

import com.itextpdf.text.Document
import com.itextpdf.text.DocumentException
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.PdfWriter
import org.junit.Test
import java.io.FileNotFoundException
import java.io.FileOutputStream



class PdfTest {

    @Test
    fun pdfGen(){
        val document = Document()
        try {
            val writer = PdfWriter.getInstance(document, FileOutputStream("HelloWorld.pdf"))
            document.open()
            document.add(Paragraph("A Hello World PDF document."))
            document.close()
            writer.close()
        } catch (e: DocumentException) {
            e.printStackTrace()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }

    }
}
