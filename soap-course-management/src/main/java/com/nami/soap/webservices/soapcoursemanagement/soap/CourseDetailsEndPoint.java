package com.nami.soap.webservices.soapcoursemanagement.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.nami.courses.CourseDetails;
import com.nami.courses.DeleteCourseDetailsRequest;
import com.nami.courses.DeleteCourseDetailsResponse;
import com.nami.courses.GetAllCourseDetailsRequest;
import com.nami.courses.GetAllCourseDetailsResponse;
import com.nami.courses.GetCourseDetailsRequest;
import com.nami.courses.GetCourseDetailsResponse;
import com.nami.soap.webservices.soapcoursemanagement.soap.Exception.CouseNotFoundException;
import com.nami.soap.webservices.soapcoursemanagement.soap.bean.Course;
import com.nami.soap.webservices.soapcoursemanagement.soap.service.CourseDetailsService;
import com.nami.soap.webservices.soapcoursemanagement.soap.service.CourseDetailsService.Status;
//http://nami.com/courses -namespace
//GetCourseDetailsRequest -name
@Endpoint
public class CourseDetailsEndPoint {
	@Autowired
	CourseDetailsService service;
	
	@PayloadRoot(namespace="http://nami.com/courses",localPart="GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse 
	processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request){
		Course course = service.findById(request.getId());
		if (course == null){
			throw new CouseNotFoundException("Invalid Id " + request.getId());
		}
		System.out.println(course);
		return mapCourseDetails(course);
	}
	
	@PayloadRoot(namespace="http://nami.com/courses",localPart="GetAllCourseDetailsRequest")
	@ResponsePayload
	public GetAllCourseDetailsResponse 
	processAllCourseDetailsRequest(@RequestPayload GetAllCourseDetailsRequest request){
		List<Course> courses = service.findAll();
		
		return mapAllCourseDetails(courses);
	}
	

	@PayloadRoot(namespace="http://nami.com/courses",localPart="DeleteCourseDetailsRequest")
	@ResponsePayload
	public DeleteCourseDetailsResponse 
	processDeleteCourseDetailsRequest(@RequestPayload DeleteCourseDetailsRequest request){
		Status status = service.deleteById(request.getId());
		DeleteCourseDetailsResponse response = new DeleteCourseDetailsResponse();
		response.setStatus(mapStatus(status));
        
		
		return response;
	}
	public com.nami.courses.Status mapStatus(Status status){
		if (status == Status.FAILURE)
			return com.nami.courses.Status.FAILURE;
		
		return com.nami.courses.Status.SUCCESS;
		
	}
	private GetCourseDetailsResponse mapCourseDetails(Course course) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		response.setCourseDetails(mapCourse(course));
		
		return response;
	}
	private GetAllCourseDetailsResponse mapAllCourseDetails(List<Course> courses) {
		GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
		for(Course course:courses){
			CourseDetails mapCourse =  mapCourse(course);
			response.getCourseDetails().add(mapCourse);
		}
		return response;
	}
	private CourseDetails mapCourse(Course course) {
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(course.getId());
		courseDetails.setName(course.getName());
		courseDetails.setDescription(course.getDescription());
		return courseDetails;
	}
	
	
}
