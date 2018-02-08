package restAssureTest;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;
import java.lang.Object;
import static org.hamcrest.Matchers.*;

public class RestAssure_PUT {
	
	@Test
	public void putTest()
	{
		String s="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n" + 
				"<model xmlns=\"http://www.ca.com/moi/0.1\">\r\n" + 
				"  <productName>Hypervisor2</productName>\r\n" + 
				"  <productVersion>1.0</productVersion>\r\n" + 
				"  <productDescription>The hypervisor containing all my VM's</productDescription>\r\n" + 
				"  <status>APPROVED</status>\r\n" + 
				"   <subsystems>\r\n" + 
				"    <subsystem id=\"VM2\">\r\n" + 
				"      <groups>\r\n" + 
				"        <group displayName=\"VM Metrics\" id=\"vmMetrics2\">\r\n" + 
				"          <subGroups>\r\n" + 
				"            <subGroup displayName=\"CPU Utilization\" id=\"vmcpu2\">\r\n" + 
				"             <path>\r\n" + 
				"          		  <segment desc=\"z/OS System\" index=\"0\" name=\"ZosSystem\"/>\r\n" + 
				"          		  <segment desc=\"VM\" index=\"1\" name=\"vm\"/>\r\n" + 
				"         	   </path>\r\n" + 
				"              <metrics>\r\n" + 
				"                <metric name=\"VMCPUUSAGE2\">\r\n" + 
				"                  <description>CPU Consumed by the VM</description>\r\n" + 
				"                  <unit>PCT</unit>\r\n" + 
				"                   <defaultAnalyticsSettings>\r\n" + 
				"                		<analytics enabled=\"true\" type=\"green-highways\"/>\r\n" + 
				"              		</defaultAnalyticsSettings>\r\n" + 
				"                </metric>\r\n" + 
				"              </metrics>\r\n" + 
				"            </subGroup>\r\n" + 
				"            <subGroup displayName=\"Disk Utilization\" id=\"diskutil2\">\r\n" + 
				"             <path>\r\n" + 
				"          		  <segment desc=\"z/OS System\" index=\"0\" name=\"ZosSystem\"/>\r\n" + 
				"          		  <segment desc=\"VM\" index=\"1\" name=\"vm\"/>\r\n" + 
				"         	 </path>\r\n" + 
				"             <metrics>\r\n" + 
				"                <metric name=\"VMAVGDISKUSAGE2\">\r\n" + 
				"                  <description>Disk usage of the VM</description>\r\n" + 
				"                  <unit>AVG</unit>\r\n" + 
				"                   <defaultAnalyticsSettings>\r\n" + 
				"                		<analytics enabled=\"false\" type=\"green-highways\"/>\r\n" + 
				"              	   </defaultAnalyticsSettings>\r\n" + 
				"                </metric>\r\n" + 
				"              </metrics>\r\n" + 
				"            </subGroup>\r\n" + 
				"          </subGroups>\r\n" + 
				"        </group>\r\n" + 
				"       </groups>\r\n" + 
				"      </subsystem>\r\n" + 
				"    </subsystems>\r\n" + 
				"</model>";
	given().
    pathParam("productName","HTTP_Rest").
	pathParam("version","1.0").body(s).
    when().
    put("http://yersa01-i7903:8899/v1/moi/ingest/model/{productName}/{version}").
    then()
    .statusCode(200)
    .body(hasToString("ok"));
	
	
	
	}
}
