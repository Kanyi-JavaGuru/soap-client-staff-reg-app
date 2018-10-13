package com.cellulant.endpoints;

import javax.xml.bind.JAXBElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.cellulant.model.FetchDepartments;
import com.cellulant.model.FetchDepartmentsResponse;
import com.cellulant.model.ObjectFactory;

public class DepartmentsGateway extends WebServiceGatewaySupport{
	private static final Logger log = LoggerFactory.getLogger(DepartmentsGateway.class);


	/**
	 * Sends a FetchDepartments request to the web service and receives 
	 * a FetchDepartmentsResponse
	 * @return FetchDepartmentsResponse
	 */
	@SuppressWarnings("unchecked")
	public FetchDepartmentsResponse getDepartments() {
		JAXBElement<FetchDepartmentsResponse> jaxbElement = null;
		final FetchDepartments request = new FetchDepartments();
		try {
			jaxbElement = (JAXBElement<FetchDepartmentsResponse>) getWebServiceTemplate()
												.marshalSendAndReceive(new ObjectFactory()
												.createFetchDepartments(request));

		} catch (Exception e) {
			log.info("Error occured: "+e.getMessage());
		}
		return jaxbElement.getValue();
	}
}
