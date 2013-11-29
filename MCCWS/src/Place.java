
public class Place {
	public String Name;
	public String Address;
	public String Rating;
	public String Cusine;
	public double Distance;
	public String Phone;
	public String URL;
	
	public Place(String name, String rating, double distance, String address, String cusine)
	{
		Name = name;
		Address = address;
		Rating  = rating;
		Cusine = cusine;
		Distance = distance;
	}
	public Place(String name, String rating, double distance, String address, String phone, String url, String cusine)
	{
		Name = name;
		Address = address;
		Rating  = rating;
		Cusine = cusine;
		Distance = distance;
		Phone = phone;
		URL = url;
	}
	public Place()
	{
		
	}
}
