package WebProject.WebProject.exportExcel;

import WebProject.WebProject.entity.Product;
import WebProject.WebProject.entity.User;
import WebProject.WebProject.service.ProductService;
import WebProject.WebProject.service.UserService;
import org.apache.poi.hpsf.PropertySet;
import org.apache.poi.hpsf.PropertySetFactory;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ooxml.POIXMLProperties;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class ExportExcelNguoiDung {
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;


    public ByteArrayInputStream generateExcelKhachHang(List<User> khNguoiDungList) throws IOException {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Người dùng");

            // Tạo header
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("UserName");
            header.createCell(2).setCellValue("Password");
            header.createCell(3).setCellValue("FullName");
            header.createCell(4).setCellValue("Address");
            header.createCell(5).setCellValue("Email");
            header.createCell(6).setCellValue("Phone Number");

            // Đổ dữ liệu
            int rowNum = 1;
            for (User user : khNguoiDungList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(user.getId());
                row.createCell(1).setCellValue(user.getUserName());
                row.createCell(2).setCellValue(user.getPassword());
                row.createCell(3).setCellValue(user.getFullName());
                row.createCell(4).setCellValue(user.getAddress());
                row.createCell(5).setCellValue(user.getEmail());
                row.createCell(6).setCellValue(user.getPhone_Number());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }




    public ByteArrayInputStream generateExcelProduct(List<Product> productList) throws IOException {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Product");

            // Tạo header
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Code");
            header.createCell(2).setCellValue("Product Name");
            header.createCell(3).setCellValue("Color");
            header.createCell(4).setCellValue("Category");
            header.createCell(5).setCellValue("Description");
            header.createCell(6).setCellValue("Create Date");
            header.createCell(7).setCellValue("Price");
            header.createCell(8).setCellValue("Quantity");
            header.createCell(9).setCellValue("Image");

            // Đổ dữ liệu

            int rowNum = 1;
            for (Product x : productList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(x.getId());
                row.createCell(1).setCellValue(x.getProduct_Code());
                row.createCell(2).setCellValue(x.getProduct_Name());
                row.createCell(3).setCellValue(x.getColor().getColor_name());
                row.createCell(4).setCellValue(x.getCategory().getCategory_Name());
                row.createCell(5).setCellValue(x.getDescription());
                row.createCell(6).setCellValue(x.getCreated_At().toString());
                row.createCell(7).setCellValue(x.getPrice());
                row.createCell(8).setCellValue(x.getQuantity());
                row.createCell(9).setCellValue(x.getImage());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

}
