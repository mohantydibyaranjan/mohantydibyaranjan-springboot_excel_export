package com.nt.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Emp;
import com.nt.repository.EmpRepository;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
@Service
public class EmpReportServiceIMPL  implements EmpReportService {
	@Autowired
	private EmpRepository empRepo;
	
	@Override
	public void generateExcel(HttpServletResponse response) {
	    List<Emp> allEmps = empRepo.findAll();

	    HSSFWorkbook workbook = new HSSFWorkbook();
	    HSSFSheet sheet = workbook.createSheet("Emp Info");
	    HSSFRow row = sheet.createRow(0);

	    // Set column headers
	    row.createCell(0).setCellValue("empNo");
	    row.createCell(1).setCellValue("eName");
	    row.createCell(2).setCellValue("job");
	    row.createCell(3).setCellValue("mgr");
	    row.createCell(4).setCellValue("hireDate");
	    row.createCell(5).setCellValue("sal");
	    row.createCell(6).setCellValue("comm");
	    row.createCell(7).setCellValue("deptNO");
	    row.createCell(8).setCellValue("cmm");
	    row.createCell(9).setCellValue("dept_no");
	    row.createCell(10).setCellValue("e_name");
	    row.createCell(11).setCellValue("hire_date");
	    row.createCell(12).setCellValue("salary");

	    int dataIndexRow = 1;
	    for (Emp e : allEmps) {
	        HSSFRow dataRow = sheet.createRow(dataIndexRow);

	        dataRow.createCell(0).setCellValue(e.getEmpNo() != null ? e.getEmpNo() : 0);
	        dataRow.createCell(1).setCellValue(e.getEName() != null ? e.getEName() : "");
	        dataRow.createCell(2).setCellValue(e.getJob() != null ? e.getJob() : "");
	        dataRow.createCell(3).setCellValue(e.getMgr() != null ? e.getMgr() : 0);
	        dataRow.createCell(4).setCellValue(e.getHireDate() != null ? e.getHireDate().toString() : "");
	        dataRow.createCell(5).setCellValue(e.getSal() != null ? e.getSal() : 0.0);
	        dataRow.createCell(6).setCellValue(e.getComm() != null ? e.getComm() : 0.0);  // Null check for comm
	        dataRow.createCell(7).setCellValue(e.getDeptNO() != null ? e.getDeptNO() : 0);
	        dataRow.createCell(8).setCellValue(e.getCmm() != null ? e.getCmm() : 0);
	        dataRow.createCell(9).setCellValue(e.getDept_no() != null ? e.getDept_no() : 0);
	        dataRow.createCell(10).setCellValue(e.getE_name() != null ? e.getE_name() : "");
	        dataRow.createCell(11).setCellValue(e.getHire_date() != null ? e.getHire_date().toString() : "");
	        dataRow.createCell(12).setCellValue(e.getSalary() != null ? e.getSalary() : 0.0);

	        dataIndexRow++;
	    }

	    try {
	        ServletOutputStream outputStream = response.getOutputStream();
	        workbook.write(outputStream);
	        workbook.close();
	        outputStream.close();
	    } catch (IOException e1) {
	        e1.printStackTrace();
	    }
	}

	   
	}


