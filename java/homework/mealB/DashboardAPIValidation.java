package homework.mealB;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.jayway.jsonpath.JsonPath;

import utils.MealBFunctionalLibrary;

public class DashboardAPIValidation extends MealBFunctionalLibrary{
	
	
	String dashboardInfoURL = "http://dev-mb.yoll.io/api/dashboard";
	String getExpenseAPI ="http://dev-mb.yoll.io/api/expenses";
	
	@Test
	public void dashboardAPIValidation() {
//Submit GET request to MealB Dashboard API
	getMealBInfo(dashboardInfoURL);
	Double otherExpenses = JsonPath.read(MealBFunctionalLibrary.respInfo.asString(), "$.result.otherExpenses");
	Double travelExpenses = JsonPath.read(MealBFunctionalLibrary.respInfo.asString(), "$.result.travelExpenses");
	Double giftExpenses = JsonPath.read(MealBFunctionalLibrary.respInfo.asString(), "$.result.giftExpenses");
	

	
//Submit GET request to GetExpenses API
	getMealBInfo(getExpenseAPI);
	
//From response get the total amount of all otherExpenses and validate against the value from Dashboard API
	List<Double>  otherExpenseList = JsonPath.read(MealBFunctionalLibrary.respInfo.asString(), "$.result[?(@.expenseType==10)].amount");
	getTotalExpense(otherExpenseList);
	assertEquals(MealBFunctionalLibrary.totalExpense, otherExpenses);
	
//From response get the total amount of all travelExpenses and validate against the value from Dashboard API
	List<Double>  travelExpenseList = JsonPath.read(MealBFunctionalLibrary.respInfo.asString(), "$.result[?(@.expenseType==40)].amount");
	getTotalExpense(travelExpenseList);
	assertEquals(travelExpenses, MealBFunctionalLibrary.totalExpense);
	
//From response get the total amount of all giftExpenses and validate against the value from Dashboard API
	List<Double>  giftExpenseList = JsonPath.read(MealBFunctionalLibrary.respInfo.asString(), "$.result[?(@.expenseType==50)].amount");
	getTotalExpense(giftExpenseList);
	assertEquals(giftExpenses, MealBFunctionalLibrary.totalExpense);
	}
}
