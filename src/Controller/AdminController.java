package Controller;

import java.util.List;

import Model.Bill;
import Model.BillFunction;
import Model.Show;
import Model.ShowFunction;

public class AdminController {

	public static List<Bill> viewAllBills()
    {
        List<Bill> st =BillFunction.viewAllBills();
        return st;
    }
	public static List<Show> viewAllShows()
    {
        List<Show> st =ShowFunction.viewAllShows();
        return st;
    }
}
