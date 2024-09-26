package rest;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCaseRunner;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.support.SoapUIException;

public class TestRunner2 {
	@Test
	public static void test() throws XmlException, IOException, SoapUIException {

//		String filePath = System.getProperty("user.dir")+"/soapUIXMLs/LibraryAPI.xml";
		String filePath = System.getProperty("user.dir")+"/soapUIXMLs/reqres.xml";
		WsdlProject wsdlProj = new WsdlProject(filePath);

		for (int j = 0; j < wsdlProj.getTestSuiteCount(); j++) {
			WsdlTestSuite testSuite = wsdlProj.getTestSuiteAt(j);
			for (int i = 0; i < testSuite.getTestCaseCount(); i++) {
				WsdlTestCase testCase = testSuite.getTestCaseAt(i);
				WsdlTestCaseRunner testRunner = testCase.run(new PropertiesMap(), false);
				Assert.assertEquals(Status.FINISHED, testRunner.getStatus());
			}
		}
	}
}
