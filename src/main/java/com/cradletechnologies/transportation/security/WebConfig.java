package com.cradletechnologies.transportation.security;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cradletechnologies.transportation.interceptors.VisitorLoggerHandler;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
	private VisitorLoggerHandler visitorLogger;
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
	     registry.addConverter(new MulitpartConverter());
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		Path profileUploadDir = Paths.get("./profile-pictures");
		String profileUploadPath = profileUploadDir.toFile().getAbsolutePath();
		registry.addResourceHandler("/profile-pictures/**").addResourceLocations("file:/"+profileUploadPath+"/");
		
		Path scannedUploadDir = Paths.get("./scanned-documents");
		String scannedUploadPath = scannedUploadDir.toFile().getAbsolutePath();
		registry.addResourceHandler("/scanned-documents/**").addResourceLocations("file:/"+scannedUploadPath+"/");

		Path proofUploadDir = Paths.get("./payment-proofs");
		String proofUploadPath = proofUploadDir.toFile().getAbsolutePath();
		registry.addResourceHandler("/payment-proofs/**").addResourceLocations("file:/"+proofUploadPath+"/");

		Path userUploadDir = Paths.get("./user-logos");
		String userUploadPath = userUploadDir.toFile().getAbsolutePath();
		registry.addResourceHandler("/user-logos/**").addResourceLocations("file:/"+userUploadPath+"/");
				
		Path staffUploadDir = Paths.get("./staff-pictures");
		String staffUploadPath = staffUploadDir.toFile().getAbsolutePath();
		registry.addResourceHandler("/staff-pictures/**").addResourceLocations("file:/"+staffUploadPath+"/");

		Path staffScannedUploadDir = Paths.get("./staff-scanned-documents");
		String staffScannedUploadPath = staffScannedUploadDir.toFile().getAbsolutePath();
		registry.addResourceHandler("/staff-scanned-documents/**").addResourceLocations("file:/"+staffScannedUploadPath+"/");
		
		Path truckUploadDir = Paths.get("./truck-pictures");
		String truckUploadPath = truckUploadDir.toFile().getAbsolutePath();
		registry.addResourceHandler("/truck-pictures/**").addResourceLocations("file:/"+truckUploadPath+"/");
			
		Path expenseUploadDir = Paths.get("./expense-proofs");
		String expenseUploadPath = expenseUploadDir.toFile().getAbsolutePath();
		registry.addResourceHandler("/expense-proofs/**").addResourceLocations("file:/"+expenseUploadPath+"/");
		
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	        String pathPattern1 = "/**.js";
	        String pathPattern2 = "/**.css";
	        String pathPattern3 = "/profile-pictures/**";
	        String pathPattern4 = "/plugins/**";
	        String pathPattern5 = "/dist/**";
	        String pathPattern6 = "/**/index";
	        String pathPattern7 = "/scanned-documents/**";
	        String pathPattern8 = "/payment-proofs/**";
	        String pathPattern9 = "/user-logos/**";
	        String pathPattern10 = "/expense-proofs/**";
		registry.addInterceptor(visitorLogger).excludePathPatterns(pathPattern1, pathPattern2, pathPattern3, pathPattern4, pathPattern5, pathPattern6, pathPattern7, pathPattern8, pathPattern9, pathPattern10);
	}
	
	 
}
