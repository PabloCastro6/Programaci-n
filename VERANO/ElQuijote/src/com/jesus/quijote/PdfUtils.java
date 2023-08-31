package com.jesus.quijote;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.DeviceGray;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import java.io.File;

/**
 * Clase con las utilidades para crear el PDF con la informacion.
 *
 * @autor Jesus Angel Gajate Luna.
 */
public class PdfUtils {

	/**
	 * Metodo para crear el PDF con la tabla.
	 *
	 * @autor Jesus Angel Gajate Luna.
	 */
    protected void crearPdf(String dest) throws Exception {
        FicheroUtils fichero = new FicheroUtils();
        int hayPalabras = fichero.hayPalabras();
        String[] palabras = fichero.crearArrayPalabras();
        int[] repeticion = fichero.contarRepeticiones(palabras);

        if (hayPalabras > 0) {
            PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
            Document doc = new Document(pdfDoc, PageSize.A4.rotate());

            float[] columnWidths = { 1f, 3f};
            Table table = new Table(UnitValue.createPercentArray(columnWidths));

            PdfFont f = PdfFontFactory.createFont(StandardFonts.HELVETICA);
            Cell cell = new Cell(1, 3).add(new Paragraph(Constantes.TEXTO_CABECERA_DE_TABLA)).setFont(f).setFontSize(13)
                    .setFontColor(DeviceGray.WHITE).setBackgroundColor(DeviceGray.BLACK)
                    .setTextAlignment(TextAlignment.CENTER);

            table.addHeaderCell(cell);

            Cell[] headerFooter = new Cell[] {
                    new Cell().setBackgroundColor(new DeviceGray(0.75f)).setTextAlignment(TextAlignment.CENTER)
                            .add(new Paragraph(Constantes.TEXTO_CABECERA_TABLA_PALABRAS)),
                    new Cell().setBackgroundColor(new DeviceGray(0.75f)).setTextAlignment(TextAlignment.CENTER)
                            .add(new Paragraph(Constantes.TEXTO_CABECERA_TABLA_NUMERO_APARICIONES)) };

            for (Cell hfCell : headerFooter) {
                table.addHeaderCell(hfCell);
            }

            for (int x = 0; x < hayPalabras; x++) {
                table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER).add(new Paragraph(palabras[x])));
                table.addCell(new Cell().setTextAlignment(TextAlignment.CENTER)
                        .add(new Paragraph(String.valueOf(repeticion[x]))));
            }

            doc.add(table);

            doc.close();
        }
    }
}
