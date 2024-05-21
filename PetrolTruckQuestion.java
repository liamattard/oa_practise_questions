import java.util.List;

public class PetrolTruckQuestion {
  
      public static int checkRemaining(List<Integer> pump, int remainingPetrol){
            int petrolNow = remainingPetrol + pump.get(0);
            int distanceNextPump = pump.get(1);
            
            return petrolNow - distanceNextPump;
    }

    public static boolean checkNextPumps(List<List<Integer>> petrolpumps, int currentInitPump, int remainingPetrol){
        
        
        for (int i = currentInitPump + 1; i < petrolpumps.size(); i++) {
            System.err.println("Checking Next Pump: " + i);
            remainingPetrol = checkRemaining(petrolpumps.get(i), remainingPetrol);
            if (remainingPetrol < 0){
                return false;
            }
            
        }
        
        System.err.println("Starting circle from beginning now");
        
        // Do a method for the inner loop
        for (int i = 0; i < currentInitPump; i++) {
            remainingPetrol = checkRemaining(petrolpumps.get(i), remainingPetrol);
            if (remainingPetrol < 0){
                return false;
            }
        }
        
        
        return true;
        
    }
    
    

    public static int truckTour(List<List<Integer>> petrolpumps) {
        for (int i = 0; i < petrolpumps.size(); i++) {
            // System.err.println("Checking Init Pump i: " + i);
            int initPetrol = petrolpumps.get(i).get(0);
            int initDistance = petrolpumps.get(i).get(1);
            int remainingPetrol = initPetrol - initDistance;
            
            if (remainingPetrol >= 0) {
                // System.err.println("Found Good Init Pump i: " + i + "init petrol: " + remainingPetrol);
                if(checkNextPumps(petrolpumps, i, remainingPetrol)) {
                    return i;
                }
            }
        }

        return 0;
    }

