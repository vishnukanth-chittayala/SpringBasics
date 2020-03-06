import static org.junit.Assert.assertEquals;

//import com.example.demo.*;
import org.junit.Test;

public class Testing
{
	String[] a = new String[5];
//Employee e1=new Employee();
//DisplayEmployee e2=new DisplayEmployee();
//DelEmployee e3=new DelEmployee();
//UpdateEmployee e4=new UpdateEmployee();

        @Test
	public void create(){
		assertEquals("employee added",Employee.main(a));
		}
        @Test
    	public void display(){
    		assertEquals("employee displayed",DisplayEmployee.main(a));
    		}
        @Test
    	public void update(){
    		assertEquals("employee updated",UpdateEmployee.main(a));
    		}
        @Test
    	public void delete(){
    		assertEquals("employee deleted",DelEmployee.main(a));
    		}


}
