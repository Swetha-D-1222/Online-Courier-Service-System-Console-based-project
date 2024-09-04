package view;

import Model.SendingDetails;
import Model.Transaction;

public class TransactionView {
//	public static SendingDetails insertRecord(SendingDetails sendingdetail)
//	{
//		Transaction transaction=new Transaction();
//		transaction.setSendingId(sendingdetail.getsendId());
//		transaction=transaction.insertRecord(transaction);
//		return sendingdetail;
//		
//	}

	public void updateDetails(int s_Id, int amount) 
	{
		Transaction trans=new Transaction();
		trans.update_Detail(s_Id,amount);
		
	}

}
