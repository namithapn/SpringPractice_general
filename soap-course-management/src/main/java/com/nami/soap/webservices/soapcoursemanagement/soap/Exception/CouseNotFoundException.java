package com.nami.soap.webservices.soapcoursemanagement.soap.Exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode=FaultCode.CUSTOM, customFaultCode="{http://nami.com/courses}001_Course_not_found")
public class CouseNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4488229533592516297L;

	public CouseNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
   





}
