package com.hexaware.ftp82.integration.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class LeaveDetailsRestTest {
	@Test
	public void testemployeeLeaveHistory() throws AssertionError, URISyntaxException {
		LeaveDetails[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/LeaveDetails/history/1000")).getBody().as(LeaveDetails[].class);
					assertEquals(new LeaveDetails(1000), res);
	}

	@Test
	public void testleaveDetailsList() throws AssertionError, URISyntaxException {
		LeaveDetails[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/LeaveDetails/pending/1000")).getBody().as(LeaveDetails[].class);
					assertEquals(new LeaveDetails(1000), res);
	}

	@Test
	public void testapplyLeaveRest() throws AssertionError, URISyntaxException {
		String res = given().accept(ContentType.TEXT).when()
				.post(CommonUtil.getURI("/api/LeaveDetails/applyleave/3001/SL/15-10-2018/18-10-2018/fever")).getBody().asString();
		assertEquals(new LeaveDetails(10,"SL","2018-10-15","2018-10-15",1,"PENDING","fever","2018-10-15", null, 3001), res);
  	}		
  
  	@Test
	public void testpostApproveOrDeny() throws AssertionError, URISyntaxException {
		given().accept(ContentType.TEXT).when()
				.post(CommonUtil.getURI("/api/LeaveDetails/approve/2000/1/Okay/approved")).getBody().asString();
  	}
	  
   	@Test
	public void testLeaveDetailsList404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/LeaveDetails/9999")).then().assertThat().statusCode(404);
	}
}
