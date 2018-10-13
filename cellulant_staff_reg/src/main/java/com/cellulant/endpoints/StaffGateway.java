package com.cellulant.endpoints;

import javax.xml.bind.JAXBElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.cellulant.model.FetchStaff;
import com.cellulant.model.FetchStaffResponse;
import com.cellulant.model.ObjectFactory;

public class StaffGateway extends WebServiceGatewaySupport{
	private static final Logger log = LoggerFactory.getLogger(StaffGateway.class);

	/**
	 * Sends a FetchStaff request to the web service and receives 
	 * a FetchStaffResponse
	 * @return FetchStaffResponse
	 */
	@SuppressWarnings("unchecked")
	public FetchStaffResponse getStaff(int departmentId) {
		JAXBElement<FetchStaffResponse> jaxbElement = null;
		final FetchStaff request = new FetchStaff();
		try {
			request.setDepartmentID(departmentId);
			jaxbElement = (JAXBElement<FetchStaffResponse>) getWebServiceTemplate()
												.marshalSendAndReceive(new ObjectFactory()
												.createFetchStaff(request));

		} catch (Exception e) {
			log.info("Error occured: "+e.getMessage());
		}
		return jaxbElement.getValue();

	}
}
