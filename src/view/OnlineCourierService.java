package view;
import java.util.*;
import static Model.DBConnectivity.*;
public class OnlineCourierService {

	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createConn();
		while(true)
		{
			System.out.println(" ~ ONILNE COURIER SERVICE MANAGEMENT SYSTEM ~");
			System.out.println("1) ADMIN \n2) STAFF \n3) CUSTOMER");
			int user=sc.nextInt();
			sc.nextLine();
			if(user==1)
			{
				adminView adminview=new adminView();
				adminview.view();
			}
			if(user==2)
			{
				StaffView staffview=new StaffView();
				staffview.view();
			}
			if(user ==3)
			{
				customerView custview=new customerView();
				custview.view();
			}
		}

	}

}
