
public class Start
{
public static void main(String args[])
{
	String[] a = new String[5];
switch(args[0])
{
case "create":
System.out.println("ceate");
Employee.main(a);
break;
case "display":
System.out.println("displaying");
DisplayEmployee.main(a);
break;
case "update":
System.out.println("updating");
UpdateEmployee.main(a);
break;
case "delete":
System.out.println("deleteing");
DelEmployee.main(a);
break;
default:System.out.println("wrong input");
break;
}
}
}
