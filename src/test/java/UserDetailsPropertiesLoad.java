import com.triscent.utilities.PropertiesSetUp;

public class UserDetailsPropertiesLoad extends PropertiesSetUp {

    private static final String USERDETAILSFILE = "UserDetails.properties";

    public static String getUserName(){
        setUpProperties(USERDETAILSFILE);
        return properties.getProperty("USERNAME");
    }

    public static String getPassword(){
        setUpProperties(USERDETAILSFILE);
        return properties.getProperty("PASSWORD");
    }

}
