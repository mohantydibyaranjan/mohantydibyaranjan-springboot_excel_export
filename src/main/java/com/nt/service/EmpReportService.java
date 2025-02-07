package com.nt.service;

import jakarta.servlet.http.HttpServletResponse;

public interface EmpReportService {
	//when user sends a request the excel file is direct downloaded to broswer
	public void generateExcel(HttpServletResponse response);

}
