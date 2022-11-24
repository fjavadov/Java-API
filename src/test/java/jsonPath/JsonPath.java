package jsonPath;

public class JsonPath {
	
	
	/*
	{
		 "store":{
			"car":[
				{
				"make":"Honda",
				"model":"Accord",
				"year":2010,
				"price":11500
				},
				{
				"make":"Honda",
				"model":"Civic",
				"year":2016,
				"price":18000,
		      		"sunroof": true
				},
				{
				"make":"Toyota",
				"model":"Camry",
				"year":2019,
				"price":27000
				},
				{
				"make":"Nissan",
				"model":"Versa",
				"year":2005,
				"price":3200,
		        	"sunroof": true
				}
			       ],
			 "bicycle":{
				"colour": "red",
				 "price": 99.99
				}
		       }
		       */
	
//	$.store.car[0] -- gets 1st object in car array
//	$.store.car[0].model  -- gets model of 1st object in car array
//	$.store.car[*].model  -- gets model of all objects in car array
//	$.store.car[0,1,2].model  -- gets model of 1st, 2nd, 3rd objects in car array
//	$.store.car[:3].model  -- gets model of first 3 objects in car array
//	$.store.car[-3:].model -- gets model of last 3 objects in car array
//	$.store.car[1:].model -- gets all models starting from index num 1 in car array
//
//	$.store.car[?(@.make=="Honda")] -- get cars which model is Honda
//	$.store.car[?(@.year>2011)]      -- get cars which year is greater then 2011
//	$.store.car[?(@.year>=2010 & @.year<=2016)] -- get cars which year between 2010 and 2016
//	$.store.car[?(@.sunroof)]  -- get cars with sunroof
//	$.store.car[?(@.price>10000 & @.make=="Honda")].model -- gets honda models where price>10000

}
