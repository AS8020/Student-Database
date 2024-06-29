import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class Student 
{
	private String name;
	private long ph_no;
	private String gender;
	private int roll_no;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPh_no() {
		return ph_no;
	}

	public void setPh_no(long ph_no) {
		this.ph_no = ph_no;
	}

	public String getGender() {
		return gender;
	}

	public int getRoll_no() {
		return roll_no;
	}

	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}

	Student()
	{
		
	}
	
	Student(String name,long ph_no,String gender,int roll_no)
	{
		this.name = name;
		this.ph_no = ph_no;
		this.gender = gender;
		this.roll_no = roll_no;
	}
	
	public String toString()
	{
		return "[" + name + ","+ ph_no +","+ gender+","+roll_no+" ]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(gender, name, ph_no, roll_no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(gender, other.gender) && Objects.equals(name, other.name) && ph_no == other.ph_no
				&& roll_no == other.roll_no;
	}
	
	




	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> al = new ArrayList<Student>();
		boolean flag = false;
		while(!flag)
		{
			System.out.println();
			System.out.println("*********************************");
			System.out.println("*Welcome to the Student Database*");
			System.out.println("*********************************");
			System.out.println("1.Add Student");
			System.out.println("2.Remove Student");
			System.out.println("3.Show details");
			System.out.println("4.Modify Student Details");
			System.out.println("5.Exit");
			int choice = sc.nextInt();
			switch (choice) 
			{
				case 1: {
							System.out.println("Enter the name of the student");
							String name = sc.next();
							System.out.println("Enter the roll no of the student");
							int roll_no = sc.nextInt();
							System.out.println("Enter the gender of student");
							String gender = sc.next();
							System.out.println("Enter the phone number of student");
							long ph_no = sc.nextLong();
							boolean search = true;;
							for(int i=0;i<al.size();i++)
							{
								if(new Student(name,ph_no,gender,roll_no).equals(al.get(i)))
								{
									search =  false;
									break;
								}
							}
							if(search)
							{
								al.add(new Student(name,ph_no,gender,roll_no));
								System.out.println("Student has been added successfully");
							}
							else
							{
								System.out.println("Student with same detail found!! So can't add in the database");
							}
							
						}break;
						
				case 2:
				{
					if(al.isEmpty())
					{
						System.out.println("No students added yet");
					}
					else
					{
						for(int i=0;i<al.size();i++)
						{
							System.out.println((i+1)+" "+al.get(i).getName());
						}
						System.out.println("Which Student you want to remove");
						int choice1 = sc.nextInt();
						al.remove(choice1-1);
						System.out.println("Student removed from the database");
					}
				}break;
				
				case 3:
				{
					if(al.isEmpty())
					{
						System.out.println("No student added yet");
					}
					else
					{
						for(int i=0;i<al.size();i++)
						{
							System.out.println((i+1)+" "+al.get(i).getName());
						}
						System.out.println("For which student you want the details");
						int choice1 = sc.nextInt();
						System.out.println(al.get(choice1-1));
					}
				}break;
				case 4:
				{
					if(al.isEmpty())
					{
						System.out.println("No students added yet");
					}
					else
					{
						System.out.println("Enter the name of the student");
						String s = sc.next();
						boolean name_flag = false;
						int index = 0;
						for(int i=0;i<al.size();i++)
						{
							if(al.get(i).getName().equalsIgnoreCase(s))
							{
								name_flag = true;
								index = i;
								
							}
						}
						if(name_flag)
						{
							System.out.println("Student found with the details");
							System.out.println();
							System.out.println("1.Name :"+al.get(index).getName());
							System.out.println("2.Roll No :"+al.get(index).getRoll_no());
							System.out.println("3.Phone number :"+al.get(index).getPh_no());
							System.out.println("4.Gender :"+al.get(index).getGender());
							System.out.println();
							System.out.println("Which field you want to modify");
							int field_choice = sc.nextInt();
							switch (field_choice) 
							{
								case 1: 
								{
									sc = new Scanner(System.in);
									System.out.println("Enter the new name");
									al.get(index).setName(sc.nextLine());
									System.out.println("Data modified successfully");
								}break;
								case 2:
								{
									System.out.println("Enter the new Roll No");
									al.get(index).setRoll_no(sc.nextInt());
									System.out.println("Data modified successfully");
								}break;
								case 3:
								{
									System.out.println("Enter the new Phone Number");
									al.get(index).setPh_no(sc.nextLong());
									System.out.println("Data modified successfully");
								}break;
								case 4:
								{
									System.out.println("Ops!! Gender can't be modified");
								}break;
								default:
									System.out.println("Invalid choice");
							}
						}
						else
						{
							System.out.println("No student found with the name :"+s);
						}
					}
				}break;
				case 5:
				{
					flag = true;
				}break;
			default:
				System.out.println("Invalid choice");
			}

		}
		sc.close();

	}
}



