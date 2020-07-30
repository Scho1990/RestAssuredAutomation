import files.PayLoad;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParser {
	
//	1. Print No of courses returned by API
//
//	2.Print Purchase Amount
//
//	3. Print Title of the first course
//
//	4. Print All course titles and their respective Prices
//
//	5. Print no of copies sold by RPA Course
//
//	6. Verify if Sum of all Course prices matches with Purchase Amount

    public static void main(String arg[]) {
    	JsonPath js=new JsonPath(PayLoad.CoursePrice());
    	//1. Print No of courses returned by API
    	int courseCount=js.getInt("courses.size()");
    	System.out.println("No of courses: "+courseCount);
    	
//    	2.Print Purchase Amount
    	
    	System.out.println(js.getString("dashboard.purchaseAmount"));
    	
//    	3. Print Title of the first course
    	
    	System.out.println(js.getString("courses[0].title"));
    	
//    	4. Print All course titles and their respective Prices
    	
    	for(int i=0;i<courseCount;i++) {
    		
    		System.out.println(js.getString("courses["+i+"].title"));
    		System.out.println(js.getString("courses["+i+"].price"));
    		
    	}
    	
//    	5. Print no of copies sold by RPA Course
    	
		for (int i = 0; i < courseCount; i++) {
			if (js.getString("courses[" + i + "].title").equals("RPA")) {
				System.out.println(js.getString("courses[" + i + "].copies"));
				break;
			}
    		
    		
    	}
		System.out.println("Verify if Sum of all Course prices matches with Purchase Amount");
		int sum=0;
		for (int i = 0; i < courseCount; i++) {
			
			int copies = js.getInt("courses[" + i + "].copies");
			int price = js.getInt("courses[" + i + "].price");
			System.out.println(copies*price);
			
			int totalCopiesAndPrice=copies*price;
			sum=sum+totalCopiesAndPrice;
			
    }
		System.out.println(sum);
		int purchaseAmount =js.getInt("dashboard.purchaseAmount");
		if(sum==purchaseAmount) {
			System.out.println("Passed");
		}

	
    }
	

}
