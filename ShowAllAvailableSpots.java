import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class ShowAllAvailableSpots {

	private HashMap<String, Object> ListOfAllClasses = new HashMap<>();

	public ShowAllAvailableSpots(HashMap input /* , Radiobutton */) {
		ListOfAllClasses = input;
		String term = "term"; //input from radio button


		//Go through list of classes to see what is open
		Set set = ListOfAllClasses.entrySet();
		Iterator iterator = set.iterator();

		while(iterator.hasNext()) {
			
			Map.Entry current = (Map.Entry)iterator.next();
			

			int seatsLeft = Integer.parseInt(ListOfAllClasses[12]);

			if(ListOfAllClasses[14].equals(term) && seatsLeft > 0  ) //if selected term and seats open are greater than 0
				current.toString();
		}



	}



}
