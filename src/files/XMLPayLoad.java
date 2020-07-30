package files;

public class XMLPayLoad {
	
	public static String getPostRequestXMLData() {
		String postReqBody="<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n" + 
				"<root>\r\n" + 
				"    <location>\r\n" + 
				"        <lat>-38.383494</lat>\r\n" + 
				"        <lng>33.427362</lng>\r\n" + 
				"    </location>\r\n" + 
				"    <accuracy>50</accuracy>\r\n" + 
				"    <name>The Mens store</name>\r\n" + 
				"    <phone_number>(+91) 983 893 3937</phone_number>\r\n" + 
				"    <address>Anna Salai, Chennai</address>\r\n" + 
				"    <types>shoe park</types>\r\n" + 
				"    <types>kadai</types>\r\n" + 
				"    <website>http://google.com</website>\r\n" + 
				"    <language>tamil-IN</language>\r\n" + 
				"</root>";
		return postReqBody;
		
	}

}
