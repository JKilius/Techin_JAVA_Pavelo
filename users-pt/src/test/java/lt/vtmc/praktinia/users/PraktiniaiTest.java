package lt.vtmc.praktinia.users;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

import lt.vtmc.praktiniai.users.Praktiniai;
import lt.vtmc.praktiniai.users.User;


@SuppressWarnings("deprecation")
public class PraktiniaiTest {
	

	   

	    @Test
	    public void shouldReturnNumberOfUsersOlderThen25() {
	        List<User> users = User.getUsersWithAge(18, 20, 21, 22, 23, 24, 25, 26);
	        Integer count = Praktiniai.countUsersOlderThen25(users);
	        assertTrue(count == 1);
	    }

	   
	    
	   

	   

	   

	 
	    @Test
	    public void shouldFindMinAge(){
	        List<User> users = User.getUsersWithAge(10, 20, 30);
	        assertThat(Praktiniai.getMinAge(users), equalTo(10));
	        List<User> users2 = User.getUsersWithAge(40, 20, 30);
	        assertThat(Praktiniai.getMinAge(users2), equalTo(20));
	        
	    }
	    
	    @Test
	    public void shouldCalculateAverage(){
	        List<User> users = User.getUsersWithAge(10, 20, 30);
	        
	        assertThat(Praktiniai.getAverageAge(users), equalTo((double)(10+20+30)/3));
	        
	    }
	    
   

	    

	    @Test
	    public void shouldFindUserByName(){
	        User homer = new User("Homer", true);
	        User bart = new User("Bart", true);
	        User maggie = new User("Maggie",false);
	        User lisa = new User("Lisa", true);
	        List<User> users = asList(homer, bart, maggie, lisa);
	        User user = Praktiniai.findByName(users, "Homer");
	       
	        assertThat(user, equalTo(homer));
	    }

	    @Test
	    public void shouldSortByAge(){
	        User homer = new User("Homer", 50);
	        User bart = new User("Bart", 12);
	        User maggie = new User("Maggie",2);
	        User lisa = new User("Lisa", 8);
	        List<User> users = asList(homer, bart, maggie, lisa);
	        List<User> sorted = Praktiniai.sortByAge(users);
	        assertThat(sorted, contains(maggie, lisa, bart, homer));
	    }

	    @Test
	    public void shouldFindOldest(){
	        User homer = new User("Homer", 50);
	        User bart = new User("Bart", 12);
	        User maggie = new User("Maggie",2);
	        User lisa = new User("Lisa", 8);
	        List<User> users = asList(homer, bart, maggie, lisa);
	        User oldest = Praktiniai.findOldest(users);
	        assertThat(oldest, equalTo(homer));
	    }

	    @Test
	    public void shouldSumAgeAsInt(){
	        User homer = new User("Homer", 50);
	        User bart = new User("Bart", 12);
	        User maggie = new User("Maggie",2);
	        User lisa = new User("Lisa", 8);
	        List<User> users = asList(homer, bart, maggie, lisa);
	        int sumAge = Praktiniai.sumAge(users);
	        assertThat(sumAge, equalTo(50+12+2+8));
	    }

	  

	 

	  

	    

	   

	    
}
