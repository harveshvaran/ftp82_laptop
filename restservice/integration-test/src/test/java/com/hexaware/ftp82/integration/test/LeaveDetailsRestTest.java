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
				.get(CommonUtil.getURI("/api/LeaveDetails/history/3000")).getBody().as(LeaveDetails[].class);
					assertEquals(1, res.length);
					LeaveDetails l1 = res[0];
					assertEquals(1, l1.getLeaveId());
	}

	@Test
	public void testleaveDetailsList() throws AssertionError, URISyntaxException {
		LeaveDetails[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/LeaveDetails/pending/2000")).getBody().as(LeaveDetails[].class);
					assertEquals(11, res.length);
					LeaveDetails ld1 = res[0];
					assertEquals("PENDING", ld1.getLeaveStatus());
					//assertEquals(new LeaveDetails(1000), res);
	}

	@Test
	public void testapplyLeaveRest() throws AssertionError, URISyntaxException {
		String res = given().accept(ContentType.TEXT).when()
				.post(CommonUtil.getURI("/api/LeaveDetails/applyleave/3000/EL/2018-10-11/2018-10-16/sick")).getBody().asString();
		assertEquals("inserted sucessfully", res);
  	}		
  
    @Test
	public void testpostApproveOrDeny() throws AssertionError, URISyntaxException {
		String res = given().accept(ContentType.TEXT).when()
				.post(CommonUtil.getURI("/api/LeaveDetails/approve/3001/6/Ok/approved")).getBody().asString();
				assertEquals("Leave Approved", res);
  	}
	  
  	@Test
	public void testLeaveDetailsList404() throws AssertionError, URISyntaxException {
		given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/LeaveDetails/9999")).then().assertThat().statusCode(404);
	}
	@Test
	public void testupdateLeaveRest() throws AssertionError, URISyntaxException {
		String res = given().accept(ContentType.TEXT).when()
				.put(CommonUtil.getURI("/api/LeaveDetails/updateleave/3000/EL/2018-10-11/2018-10-16/goingtonative/14")).getBody().asString();
				assertEquals("updated sucessfully", res);
  	}
	@Test
	public void testdeleteLeaveRest() throws AssertionError, URISyntaxException {
		String res = given().accept(ContentType.TEXT).when()
				.delete(CommonUtil.getURI("/api/LeaveDetails/delete/14/3000")).getBody().asString();
				assertEquals("leave request deleted", res);
  	}
}
