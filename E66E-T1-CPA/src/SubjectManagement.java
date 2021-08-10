import java.util.ArrayList;

public class SubjectManagement {

	public void start()
	{
		ArrayList<Subject> SubList = new ArrayList<Subject>();
		int option = 0;
		while (option != 4)
				{
					menu();
					option = Helper.readInt("Enter An Option > ");
					if (option == 1)
					{
						String name = Helper.readString("Subject Name > ");
						String code = Helper.readString("Subject Code > ");
						String type = Helper.readString("Subject Type > ");
						doAddSubject(SubList, name , code, type);
					}
					else if (option == 2)
					{
						String keyword = Helper.readString("Enter Subject Name");
						doViewSubject(SubList, keyword);
					}
					else if (option == 3)
					{
						String code = Helper.readString("Enter Subject Code to Delete > ");
						doDeleteSubject(SubList,code);
					}
					else if (option == 4)
					{
						System.out.println("Thank you!");
					}
				}
	}
	private void menu()
	{
		Helper.line(30, "=");
		System.out.println("Subject Management");
		Helper.line(30, "=");
		String output = "1.Add new Subject \n2.View All Subjects \n3.Delete Subject \n4.Quit App";
		System.out.println(output);
	}
	
	public static void doAddSubject(ArrayList<Subject> x, String name, String code, String type)
	{
		
		Subject subj1 = new Subject(name, code, type);
		
		if(name.equals("") || code.equals("") || type.equals(""))
		{
			for (Subject item : x)
			{
				if (item.getCode().equals(code))
				{
					System.out.println("The Subject already exists!");
				}
				else
				{
					x.add(subj1);
					System.out.println("New Subject was Successfully Added");
				}
			}
		}
		else
		{
			System.out.println("There Was An Error Adding A New Subject");
		}
		
	}
	public static String doViewSubject(ArrayList<Subject> x, String y)
	{
		int counter = 0;
		String output = String.format("%-15s %-15s %-15s", "Name", "Subject Code", "Subject Course");
		for (Subject item : x)
		{
			if (item.getName().contains(y))
			{
				counter++;
				output += String.format("%-15s %-15s %-15s", item.getName(), item.getCode(), item.getType());
			}
			
		}
		if (counter == 0)
		{
			output = "The specified subject was not found!";
		}
		return output;
	}
	public static String doDeleteSubject(ArrayList<Subject> x,String code)
	{
		String output;
		for (int i = 0; i < x.size(); i++)
		{
			if (x.get(i).getCode().equals(code))
			{
				x.remove(i);
				output = ("The Subject Was Successfully Deleted");
				return output;
			}
		}
		output = ("The Speficied Subject was not Found");
		return output;
	}
	
}
