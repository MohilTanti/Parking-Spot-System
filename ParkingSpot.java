
/**
 * ParkingSpot Class
 * This class records the data for each parking spot 
 * @author - Mohil Tanti
 * @version - V1.0
 */

public class ParkingSpot
{
    // Declaring the variables for slotid and the car and also to determine whether owner is staff member or not
    private String slotID;
    private Boolean isStaff;
    private Car car;
    
    // initialising the class variables using constructors
    public ParkingSpot(String slot, String Staff, Car cr)
    {
        this.slotID = slot;
        if(Staff.equals("yes"))
        {
            this.isStaff = true;
        }
        else if(Staff.equals("no"))
        {
            this.isStaff = false;
        }
        this.car = cr;
    }

    
   
}
