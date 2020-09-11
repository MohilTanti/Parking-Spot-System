
/**
 * Application Class
 * This class is the main clas which will be the interface between user and the program.
 * @author - Mohil Tanti
 * @version - V1.0
 */
import java.util.Scanner;

public class Application
{
    public static void main(String args[]) 
    {
        // Defining the basic variables 
        int staff_slots;
        int visitor_slots;
        int choice;
        boolean flag = true;
        
        // Creating scanner object to take user's input
        Scanner sc = new Scanner(System.in);
        // Displaying and getting user input for the number of slots for staff and visitors
        System.out.println("Start to establish a car parking with slots of staff and visitors");
        
        System.out.println("Please enter the number of slots for staff");
        staff_slots = sc.nextInt();
        
        System.out.println("Please enter the number of slots for visitors");
        visitor_slots = sc.nextInt();
        
        // Creating object of CarPark class and passing number of slots
        CarPark cp = new CarPark(staff_slots,visitor_slots);
        System.out.println("The "+staff_slots+" slots for staff are created successfully");
        System.out.println("The "+visitor_slots+" slots for visitors are created successfully");
        System.out.println();
        
        // Running while loop until user choose to exit 
        while(flag)
        {
           // Displaying the options
           System.out.println(); 
           System.out.println("1. List all car slots");
           System.out.println("2. Park a car");
           System.out.println("3. Find a car");
           System.out.println("4. Remove a car");
           System.out.println("5. Add a car slot");
           System.out.println("6. Delete a car slot");
           System.out.println("7. Exit");
           
           // Getting user's choice of option
           // Running while loop to ensure user enter only 1-7 as a choice
           boolean flagchoice = true;
           String x;
           do
           {
               System.out.print("Please select an option (1-7): ");
               x = sc.next();
                           
               // checking the format of choice provided by user with conditions that length should be 1 and 
               // number between 1 to 7 
               if(x.length() == 1)
               {
                   if((x.charAt(0) >='1' && x.charAt(0)<='7'))
                   {
                       flagchoice = false;
                   }
               }
           }
           while(flagchoice);
           
		   // casting the user's choice into integer       
           choice = Integer.parseInt(x);
           
           switch(choice)
           {
               case 1: cp.list_slot(); // Listing all the parking slots
                       break;
                       
               case 2: // Running do while loop until user enters slot id in correct format
                       boolean flagslot = true;
                       String slot;
                       do
                       {
                           System.out.println("Please enter the slot ID you want to car park at (e.g. S001): ");
                           slot = sc.next();
                           
                           // checking the format of slotid provided by user with conditions that length should be 4 and 
                           // first character should be letter and numbers in rest 
                           if(slot.length() == 4)
                           {
                               if((slot.charAt(0) >='A' && slot.charAt(0)<='Z') && (slot.charAt(1) >= '0' && slot.charAt(1)<='9') 
                                && (slot.charAt(2) >='0' && slot.charAt(2)<='9') && (slot.charAt(3) >='0' && slot.charAt(3)<='9'))
                           {
                               flagslot = false;
                           }
                        }
                       }
                       while(flagslot);
                       
                       // Running do while loop until user enters registration number in correct format
                       boolean flagreg = true;
                       String reg;
                       do
                       {
                           System.out.println("Please enter the car registration number (e.g. W12345): ");
                           reg = sc.next();
                           
                           // checking the format of registration provided by user with conditions that length should be 6 and 
                           // first character should be letter and numbers in rest 
                           if(reg.length() == 6)
                           {
                               if((reg.charAt(0) >='A' && reg.charAt(0)<='Z') && (reg.charAt(1) >= '0' && reg.charAt(1)<='9') 
                                && (reg.charAt(2) >='0' && reg.charAt(2)<='9') && (reg.charAt(3) >='0' && reg.charAt(3)<='9')
                                && (reg.charAt(4) >='0' && reg.charAt(4)<='9') && (reg.charAt(5) >='0' && reg.charAt(5)<='9'))
                                {
                                    flagreg = false;
                                }
                            }
                       }
                       while(flagreg);
                       
                       // Running do while loop until user enters staff information in correct format
                       boolean flagstaff = true;
                       String staff;
                       do
                       {
                           System.out.println("Is the car registered for the staff member? (yes/no): ");
                           staff = sc.next();
                           
                           // Checking and ensuring that user enters the following options only
                           if(staff.equals("yes") || staff.equals("no"))
                           {
                               flagstaff = false;
                           }
                        
                       }
                       while(flagstaff);    
                       
                       // Getting owner name from the user
                       System.out.println("Who is the owner of the car?");
                       String owner = sc.next();
                       System.out.println();
                       
                       // Creating object of car class and passing the data of car and owner to it
                       Car cr = new Car(reg,owner,staff);
                       
                       // Adding car to parking slot
                       cp.add_car(slot,staff,cr);
                       break;
                       
               case 3: // Running do while loop until user enters registration in correct format
                       boolean flagregs = true;
                       String regs;
                       do
                       {
                           System.out.println("Please enter the car registration number (e.g. W12345): ");
                           regs = sc.next();
                           
                           // checking the format of registration provided by user with conditions that length should be 6 and 
                           // first character should be letter and numbers in rest 
                           if(regs.length() == 6)
                           {
                               if((regs.charAt(0) >='A' && regs.charAt(0)<='Z') && (regs.charAt(1) >= '0' && regs.charAt(1)<='9') 
                                && (regs.charAt(2) >='0' && regs.charAt(2)<='9') && (regs.charAt(3) >='0' && regs.charAt(3)<='9')
                                && (regs.charAt(4) >='0' && regs.charAt(4)<='9') && (regs.charAt(5) >='0' && regs.charAt(5)<='9'))
                                {
                                    flagregs = false;
                                }
                            }
                       }
                       while(flagregs);
                       
                       // Calling method to find car
                       cp.find_slot(regs);
                       break;
                       
               case 4: // Running do while loop until user enters registration in correct format
                       boolean flagregno = true;
                       String regno;
                       do
                       {
                           System.out.println("Please enter the car registration number (e.g. W12345): ");
                           regno = sc.next();
                           
                           // checking the format of registration provided by user with conditions that length should be 6 and 
                           // first character should be letter and numbers in rest 
                           if(regno.length() == 6)
                           {
                               if((regno.charAt(0) >='A' && regno.charAt(0)<='Z') && (regno.charAt(1) >= '0' && regno.charAt(1)<='9') 
                                && (regno.charAt(2) >='0' && regno.charAt(2)<='9') && (regno.charAt(3) >='0' && regno.charAt(3)<='9')
                                && (regno.charAt(4) >='0' && regno.charAt(4)<='9') && (regno.charAt(5) >='0' && regno.charAt(5)<='9'))
                                {
                                    flagregno = false;
                                }
                            }
                       }
                       while(flagregno);
                       
                       // Calling method to remove car
                       cp.remove_car(regno);
                       break;
                       
               case 5: // Running do while loop until user enters slot id in correct format
                       boolean flagslotid = true;
                       String slotid;
                       do
                       {
                           System.out.println("Please enter the slot ID: ");
                           slotid = sc.next();
                           
                           // checking the format of slot id provided by user with conditions that length should be 4 and 
                           // first character should be letter and numbers in rest 
                           if(slotid.length() == 4)
                           {
                               if((slotid.charAt(0) >='A' && slotid.charAt(0)<='Z') && (slotid.charAt(1) >= '0' && slotid.charAt(1)<='9') 
                                && (slotid.charAt(2) >='0' && slotid.charAt(2)<='9') && (slotid.charAt(3) >='0' && slotid.charAt(3)<='9'))
                           {
                               flagslotid = false;
                           }
                        }
                       }
                       while(flagslotid);
                       
                       // Running do while loop until user enters staff information in correct format
                       boolean flagisstaff = true;
                       String isstaff;
                       do
                       {
                           System.out.println("Is the car registered for the staff member? (yes/no): ");
                           isstaff = sc.next();
                           
                           // Checking and ensuring that user enters the following options only
                           if(isstaff.equals("yes") || isstaff.equals("no"))
                           {
                               flagisstaff = false;
                           }
                        
                       }
                       while(flagisstaff); 
                       // Calling Method to add slot
                       cp.add_slot(slotid,isstaff);
                       break;
                       
               case 6: // Running do while loop until user enters slot id in correct format
                       boolean flagSlot = true;
                       String Slot;
                       do
                       {
                           System.out.println("Please enter the slot ID: ");
                           Slot = sc.next();
                           
                           // checking the format of slot id provided by user with conditions that length should be 4 and 
                           // first character should be letter and numbers in rest 
                           if(Slot.length() == 4)
                           {
                               if((Slot.charAt(0) >='A' && Slot.charAt(0)<='Z') && (Slot.charAt(1) >= '0' && Slot.charAt(1)<='9') 
                                && (Slot.charAt(2) >='0' && Slot.charAt(2)<='9') && (Slot.charAt(3) >='0' && Slot.charAt(3)<='9'))
                           {
                               flagSlot = false;
                           }
                        }
                       }
                       while(flagSlot);
                       
                       // Calling method to delete slot
                       cp.delete_slot(Slot);
                       break;
                       
               case 7: // Changing flag to stop the loop 
                       flag = false;
                       break;
                       
               default: System.out.println("Please enter valid choice");
           }
        }
        
    }
}
