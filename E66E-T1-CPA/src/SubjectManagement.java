import java.util.ArrayList;

public class SubjectManagement
{
	public static void start()
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
						String add = doAddSubject(SubList, name , code, type);
						System.out.println(add);
					}
					else if (option == 2)
					{
						String keyword = Helper.readString("Enter Subject Name > ");
						String view = doViewSubject(SubList, keyword);
						System.out.println(view);
					}
					else if (option == 3)
					{
						String code = Helper.readString("Enter Subject Code to Delete > ");
						String del = doDeleteSubject(SubList,code);
						System.out.println(del);
					}
					else if (option == 4)
					{
						System.out.println("Thank you!");
					}
				}
	}
	private static void menu()
	{
		Helper.line(30, "=");
		System.out.println("Subject Management");
		Helper.line(30, "=");
		String output = "1.Add new Subject \n2.View All Subjects \n3.Delete Subject \n4.Quit App";
		System.out.println(output);
	}
	
	public static String doAddSubject(ArrayList<Subject> x, String name, String code, String type)
	{
		
		Subject subj1 = new Subject(name, code, type);
		String output = "";
		if(name.equals("") || code.equals("") || type.equals(""))
		{
			output = "There Was An Error Adding A New Subject";
			return output;
		}
		else
		{
			for (int i = 0; i < x.size();i++)
			{
				if (x.get(i).getCode().equals(code))
				{
					output = "The Subject already exists!";
					return output;
				}
			}
			x.add(subj1);
			output = "New Subject was Successfully Added";
			return output;
			
		}
		
	}
	public static String doViewSubject(ArrayList<Subject> x, String y)
	{
		int counter = 0;
		String output = String.format("%-15s %-15s %-15s\n", "Name", "Subject Code", "Subject Course");
		for (Subject item : x)
		{
			if (item.getName().equalsIgnoreCase(y) || item.getName().contains(y))
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

