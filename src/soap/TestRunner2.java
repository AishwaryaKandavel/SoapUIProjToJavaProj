package soap;

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
	public void test() throws XmlException, IOException, SoapUIException {
		String filePath = System.getProperty("user.dir")+"/soapUIXMLs/Employee.xml";
		WsdlProject wsdlProj = new WsdlProject(filePath);
		WsdlTestSuite testSuite = wsdlProj.getTestSuiteByName("Testing");
		WsdlTestCase testCase = testSuite.getTestCaseByName("GetEmployee");
		WsdlTestCaseRunner tcr = testCase.run(new PropertiesMap(), false);
		Assert.assertEquals(Status.FINISHED, tcr.getStatus());
	}
	
}
