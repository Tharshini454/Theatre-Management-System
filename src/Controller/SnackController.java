package Controller;

import Model.SnackFunction;


public class SnackController {
	public static boolean updateSnack(int new_quantity,String snack_name) throws Exception
    {
        try
        {
            boolean b=SnackFunction.updateSnack(new_quantity,snack_name);
            return b;
        }
        catch(Exception e)
        {
           throw new Exception("Error During Updation");
        }	
    }
		public static boolean addSnack(int s_id,String name,int quantity,int price) throws Exception
	    {
	        boolean b=SnackFunction.addSnack(s_id,name,quantity,price);
	        return b;
	    }

}
