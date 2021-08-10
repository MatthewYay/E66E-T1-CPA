import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubjectManagementTest {
	
	//XIAO QUAN
	private Subject sub1;
	private Subject sub2;
	private Subject sub3;
	
	private ArrayList<Subject> subList;
	
	void setUp() throws Exception 
	{
		sub1 = new Subject ("English", "E01", "Language");
		sub2 = new Subject ("Math", "E02", "General");
		sub3 = new Subject ("Chinese", "M01", "Language");
		subList.add(sub1);
		subList.add(sub2);
		subList.add(sub3);
		
		subList = new ArrayList<Subject>();
	}

	public void testAddSubject()
	{
		//Test if The item will be rejected if one item is blank
		String name = "Geography";
		String code = "E03";
		String type = "";
		int x = subList.size();
		SubjectManagement.doAddSubject(subList,name,code,type);
		assertEquals("Test if the object was added to the list",x,subList.size());
		
		//Test if the subject will be added if the subject already exists
		int y = subList.size();
		String name1 = "English";
		String code1 = "E01";
		String type1 = "Language";
		SubjectManagement.doAddSubject(subList, name1, code1, type1);
		assertEquals("Test that the object was not added to the list",y,subList.size());
		
		//Test that a subject with no error is added successfully
		String name3 = "Geography";
		String code3 = "E03";
		String type3 = "Humanities";
		SubjectManagement.doAddSubject(subList, name3, code3, type3);
		assertEquals("Test that the object was added successfully", y+1,subList.size());
	}

	public void testViewSubject()
	{
		//Test that the search method returns expected results
		String keyword = "english";
		String test = SubjectManagement.doViewSubject(subList,keyword);
		String name1 = "English";
		String code1 = "E01";
		String type1 = "Language";
		String output = String.format("%-15s %-15s %-15s", "Name", "Subject Code", "Subject Course");
		output += String.format("%-15s %-15s %-15s", name1, code1, type1);
		assertEquals("Test that the returned output is the same", output, test);
		
		//Test when an invalid keyword is entered, the Error message appears
		String keyword1 = "yes";
		String test1 = SubjectManagement.doViewSubject(subList, keyword1);
		String output1 = "The specified subject was not found!";
		assertEquals("Test that the returned output is the error message", output1, test1);
		
	}
	
	public void testDeleteSubject()
	{
		//Test when deleting a subject, it will inform the user that it was successfully deleted.
		String output = "The Item Was Successfully Deleted";
		String keyword = "E01";
		String test = SubjectManagement.doDeleteSubject(subList, keyword);
		assertEquals("Test that the returned message is correct", output, test);
		
		//Test when deleting a subject, if there is an error it will inform the user.
		String output1 = "The Speficied Subject was not Found";
		String keyword1 = "";
		String test1 = SubjectManagement.doDeleteSubject(subList, keyword1);
		assertEquals("Test the expected output is achieved", output1, test1);
		
	}
}
