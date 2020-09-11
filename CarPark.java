
/**
 * CarPark Class.
 * This class ensures all the operations of the parking slot such as adding slot, parking car, removing car, listing all slots, etc.,
 * @author - Mohil Tanti
 * @version - V1.0
 */
import java.util.*;

public class CarPark
{
    // Creating array list for the parking slots, its type and status, registration and owner of car and also for the objects of parking spots
    public ArrayList<String> slot = new ArrayList<String>();
    public ArrayList<String> type = new ArrayList<String>();
    public ArrayList<String> status = new ArrayList<String>();
    public ArrayList<ParkingSpot> park = new ArrayList<ParkingSpot>();
    public ArrayList<String> reg = new ArrayList<String>();
    public ArrayList<String> owner = new ArrayList<String>();
    
    // Creating slots for staff and visitor using constructor when creating the object
    public CarPark(int staff, int visitor)
    {
        // Adding and naming slots for staff members
        for(int i=1; i <=staff; i++)
        {
            slot.add("S00"+i);
            type.add("staff");
            status.add("not occupied");
            reg.add("");
            owner.add("");
        }
        
        // Adding and naming slots for visitors
        for(int i=1; i <=visitor; i++)
        {
            slot.add("V00"+i);
            type.add("visitor");
            status.add("not occupied");
            reg.add("");
            owner.add("");
        }
    }

    // Method to find a car in the Parking
    public void find_slot(String registration)
    {
        // Checking is there is any car parked with the registration provided by user 
        if(check_reg(registration))
        {
        int i = reg.indexOf(registration);
        
        // Displaying the details of the car parked
        System.out.println("The car with registration "+reg.get(i)+" is parked on slot "+slot.get(i)+", and the owner is "+owner.get(i));
        }
        else 
        {
            // Printing message when no car is parked with registration provided by use
            System.out.println("Please enter valid car registration!!!");
        }
    }
    
    // Method to add parking slot
    public void add_slot(String slotid, String Staff)
    {
        // Checking if the slot already exist or not
        if(check_slot(slotid))
        {
            System.out.println("Please enter valid ParkingSlot!!!");
        }
        else
        {
            // Adding staff or visitor parking spot if any existing spot not found
            if(Staff.equals("yes"))
            {
                slot.add(slotid);
                type.add("staff");
                status.add("not occupied");
                reg.add("");
                owner.add("");
            }
            else if(Staff.equals("no"))
            {
                slot.add(slotid);
                type.add("visitor");
                status.add("not occupied");
                reg.add("");
                owner.add("");
            }
            System.out.println("The parking slot added successfully");
        }
    }
    
    // Method to delete parking spot
    public void delete_slot(String slotid)
    {
        // Checking whether spot is present or not which user provided
        if(check_slot(slotid))
        {
            // If spot found and is not occupied then deleting the slot else displaying message for the existing parked car is occupied
            int i = slot.indexOf(slotid);
            if(status.get(i).equals("not occupied"))
            {
                slot.remove(i);
                type.remove(i);
                reg.remove(i);
                owner.remove(i);
                status.remove(i);
                System.out.println("The parking slot removed successfully");
            }
            else 
            {
                
                System.out.println("Parking Slot cannot be removed as car is already parked!!!");
            }
        }
        else
        {
            // Displaying message if the ParkingSpot not found
            System.out.println("Please enter valid ParkingSlot!!!");
        }
    }
    
    
    // Method to remove car from parking spot
    public void remove_car(String registration)
    {
        // Checking the registration provided by user whether any car of that registration is parked or not
        if(check_reg(registration))
        {
            // If car found then removing the car from the spot
            int i = reg.indexOf(registration);
            status.set(i, "not occupied");
            reg.set(i, "");
            owner.set(i, "");
            System.out.println("The car with registration "+reg.get(i)+" was removed");
        }
        else
        {
            // If car not found the displaying the following message
            System.out.println("Please enter valid car registration!!!");
        }
    }
    
    
    // Method to add car in parking spot
    public void add_car(String slotid, String Staff, Car cr)
    {
        // Checking whether the slot is empty and the car with same registration is not parked anywhere else
        if (check_slotempty(slotid) && !check_reg(cr.registration))
        {
            int i = slot.indexOf(slotid);
            
            // Checking the user input to ensure staff member parks in staff parking and visitor in visitor parking
            if((type.get(i).equals("staff") && Staff.equals("yes")) || (type.get(i).equals("visitor") && Staff.equals("no")))
            {
            park.add(new ParkingSpot(slotid,Staff,cr));
        
            
            status.set(i, "occupied");
            reg.set(i, cr.registration);
            owner.set(i, cr.owner);
            
            System.out.println("The car with registration "+cr.registration+" was parked successfully");
            }
            else
            {
                // Displaying message if any conflict found in staff and visitor parking 
                System.out.println("Staff members can park only in Staff parking slots and visitors can park only in Visitors parking slots!!");
            }
        }
        else
        {
            // Checking if the car is parked or not
            if(check_reg(cr.registration))
            {
                // Displaying message that car is parked in other spot
                System.out.println("The car with registration "+cr.registration+" is already parked at other parking slot");
            }
            else
            {
                // Displaying message if the invalid slot is provided by user
                System.out.println("Please enter valid-empty slot and registration of car again!!!");
            }
        }
               
        
        
    }
    
    
    // Method to display all the parking spots
    public void list_slot()
    {
        for(int i=0; i<slot.size(); i++)
        {   
            // Display car details is parked and only parking spot details when car not parked
            if(status.get(i).equals("occupied"))
            {
                System.out.println("SlotID is: "+slot.get(i)+", is for "+type.get(i)+" and is "+status.get(i)+" by a car with reg "+reg.get(i));
            }
            else
            {
                System.out.println("SlotID is: "+slot.get(i)+", is for "+type.get(i)+" and is "+status.get(i));
            }
        }
    }
    
    
    // Method to check whether the slot is empty or not
    public boolean check_slotempty(String slotid)
    {
        boolean flag = false;
        for(int i=0; i<slot.size(); i++)
        {
            // Checking the slot id with the user's provided slot id
            if(slot.get(i).equals(slotid))
            {
                // Checking whether the slot is occupied by car or not
                if(status.get(i).equals("not occupied"))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }
    
    
    // Method to check valid parking slots
    public boolean check_slot(String slotid)
    {
        boolean flag = false;
        for(int i=0; i<slot.size(); i++)
        {
            // Checking slot id with the slot id provided by user 
            if(slot.get(i).equals(slotid))
            {
                    flag = true;
                
            }
        }
        return flag;
    }
    
    // Method to check car parked in the parking spots
    public boolean check_reg(String registration)
    {
        boolean flag = false;
        for(int i=0; i<reg.size(); i++)
        {  
            // Checking the registration of the parked cars with the registration the user provided
            if(reg.get(i).equals(registration))
            {
                flag = true;
            }
        }
        return flag;
    }
}
