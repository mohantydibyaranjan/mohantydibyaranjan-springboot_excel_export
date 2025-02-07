package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.service.EmpReportServiceIMPL;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class EmpController {
	@Autowired
	private EmpReportServiceIMPL empReportServiceImpl;
	@GetMapping("/excel")
	public void generateExcelReport(HttpServletResponse response) {
		response.setContentType("application/octet-stream");
		
		String headerKey="Content-Disposition";
		String headerValue="attachment ; filename=Employee.xls";
		
		response.setHeader(headerKey, headerValue);
		empReportServiceImpl.generateExcel(response);
		
		
	}
	

}
