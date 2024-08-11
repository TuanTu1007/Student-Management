package Web;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Model.tablePointSubjectClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/exportPdf")
public class ExportPdfServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(ExportPdfServlet.class.getName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set content type to PDF
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=StudentReport.pdf");

        // Create a new document
        Document document = new Document();
        OutputStream out = response.getOutputStream();
        try {
            // Create a PDF writer that writes to the output stream
            PdfWriter.getInstance(document, out);

            // Open the document
            document.open();

            // Add content to the document
            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
            Paragraph title = new Paragraph("BẢNG ĐIỂM HỌC SINH", font);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Create table for student info
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            // Adding headers
            addTableHeader(table, "Mã học sinh", "Giới tính", "Địa chỉ", "Lớp");

            // Adding student info
            addTableRow(table,
                (String) request.getSession().getAttribute("hs.maHS"),
                (String) request.getSession().getAttribute("hs.gioiTinh"),
                (String) request.getSession().getAttribute("hs.diaChi"),
                (String) request.getSession().getAttribute("l.tenLop"));

            // Adding more student details
            addTableHeader(table, "Họ và tên", "Ngày sinh", "Email", "Tình trạng");
            addTableRow(table,
                (String) request.getSession().getAttribute("hs.tenHS"),
                (String) request.getSession().getAttribute("hs.namSinh"),
                (String) request.getSession().getAttribute("hs.email"),
                "Đang học");

            document.add(table);

            // Create table for student grades
            PdfPTable gradeTable = new PdfPTable(7);
            gradeTable.setWidthPercentage(100);
            gradeTable.setSpacingBefore(10f);
            gradeTable.setSpacingAfter(10f);

            // Adding headers
            addTableHeader(gradeTable, "STT", "Tên môn", "Miệng", "15'", "1T", "HK", "TB môn");

            // Add student grades
            List<tablePointSubjectClass> grades = (List<tablePointSubjectClass>) request.getSession().getAttribute("p");
            int i = 1;
            if (grades != null) {
                for (tablePointSubjectClass grade : grades) {
                    addTableRow(gradeTable,
                        String.valueOf(i++),
                        grade.getTenHS(),
                        String.valueOf(grade.getMieng()),
                        String.valueOf(grade.getMuoiLamPhut()),
                        String.valueOf(grade.getMotTiet()),
                        String.valueOf(grade.getHocKy()),
                        String.valueOf(grade.getTbMon()));
                }
            } else {
                LOGGER.log(Level.WARNING, "Grades list is null");
            }

            // Adding average grade row
            addTableRow(gradeTable, "", "Trung bình học kỳ", "", "", "", "",
                String.valueOf(request.getSession().getAttribute("pAVG.diemTBHK")));

            document.add(gradeTable);

            // Close the document
            document.close();
        } catch (DocumentException e) {
            LOGGER.log(Level.SEVERE, "DocumentException occurred: {0}", e.getMessage());
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error generating PDF");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception occurred: {0}", e.getMessage());
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error generating PDF");
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    LOGGER.log(Level.WARNING, "IOException occurred while closing OutputStream: {0}", e.getMessage());
                }
            }
        }
    }

    private void addTableHeader(PdfPTable table, String... headers) {
        for (String header : headers) {
            PdfPCell headerCell = new PdfPCell();
            headerCell.setPhrase(new Phrase(header));
            table.addCell(headerCell);
        }
    }

    private void addTableRow(PdfPTable table, String... cells) {
        for (String cell : cells) {
            table.addCell(new Phrase(cell));
        }
    }
}
