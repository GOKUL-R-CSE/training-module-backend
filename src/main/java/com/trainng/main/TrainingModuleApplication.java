package com.trainng.main;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@SpringBootApplication
public class TrainingModuleApplication {

	public static void main(String[] args) throws JRException {
		SpringApplication.run(TrainingModuleApplication.class, args);
		
		
		String filePath = "E:\\worldline-training\\java-usecase\\TrainingModule\\src\\main\\resources\\templates\\employee_report.jrxml";
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("firstName", "GOKUL");
		parameters.put("lastName", "R");
		parameters.put("domain", "Java");
		parameters.put("id", "WL2074");
		
		JasperReport report = JasperCompileManager.compileReport(filePath);
		JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
		JasperExportManager.exportReportToPdfFile(print, "E:\\worldline-training\\java-usecase\\TrainingModule\\src\\main\\resources\\static\\report.pdf");
	}

}
