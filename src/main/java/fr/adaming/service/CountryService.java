package fr.adaming.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.adaming.model.Country;

public class CountryService {
	
	static HashMap<Integer, Country> countryIdMap = getCountryIdMap(); 
	 
	public CountryService(){
		super(); 
		if (countryIdMap==null){
			countryIdMap= new HashMap<Integer, Country>(); 
			//Creating some  object 
			Country indiaCountry = new Country(1, "India", 10000); 
			Country chinaCountry = new Country(2, "China", 20000); 
			Country nepalCountry = new Country(3, "Nepal", 8000); 
			Country buthanCountry = new Country(4, "Buthan", 7000); 
			
			countryIdMap.put(1, indiaCountry);
			countryIdMap.put(2, chinaCountry);
			countryIdMap.put(3, nepalCountry);
			countryIdMap.put(4, buthanCountry);
		}
	}
	
	public List<Country> getAllCountry(){
		List<Country> countries= new ArrayList<Country>(countryIdMap.values()); 
		return countries; 
	}

	public Country getCountry (int id){
		Country  country= countryIdMap.get(id); 
		return country; 
		
	}
	
	public Country addCountry (Country country){
		country.setId(getMaxId()+1);
		countryIdMap.put(country.getId(), country); 
		return country;
	}
	public Country updateCountry( Country country){
		if (country.getId()<=0)
			return null; 
		countryIdMap.put(country.getId(), country); 
		return country;
	}
	public void deleteCountry (int id){
		countryIdMap.remove(id);
	}
	public static HashMap<Integer, Country> getCountryIdMap(){
		return countryIdMap; 
	}
	//utility method to get maxID
	public static int getMaxId(){
		int max=0; 
		for (int id: countryIdMap.keySet()){
			if(max<=id)
				max=id; 
		}
		return max; 
	}
}
