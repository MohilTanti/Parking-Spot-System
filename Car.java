
/**
 * Car class
 * This class records the data for the each car 
 * @author - Mohil Tanti
 * @version - V1.0
 */
public class Car
{
    // Declaring the variables for registration and owner of the car and also to determine whether owner is staff member or not
    public String registration;
    public String owner;
    public boolean isStaff;

    // initialising the class variables using constructors
    public Car(String reg,String owner,String staff)
    {
        this.registration = reg;
        this.owner = owner;
        if(staff.equals("yes"))
        {
            this.isStaff = true;
        }
        else if(staff.equals("no"))
        {
            this.isStaff = false;
        }
    }
}
