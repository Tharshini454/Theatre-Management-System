package Controller;

import java.util.List;

import Model.Show;
import Model.ShowFunction;

public class CustomerController {

	public static List<Show> viewAllShows()
    {
        List<Show> st =ShowFunction.viewAllShows();
        return st;
    }
	
}
