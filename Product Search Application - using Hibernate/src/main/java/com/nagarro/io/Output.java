package com.nagarro.io;

import java.util.ArrayList;
import java.util.List;

import com.nagarro.customexceptions.CustomException;
import com.nagarro.tshirt.Tshirt;

public class Output {
public void displayOutput(List<Tshirt>matchedTshirts) throws CustomException {
		System.out.println("Thanks for Confarmation!!! Your Result:\n");
		
//		if(matchedTshirts.isEmpty()) {
//			System.out.println("Sorry,no tshirt is avaliable of your required choice");
//			
//		}else {
//			matchedTshirts.forEach(i ->{
//				System.out.println("ID:\t"+ i.getId());
//				System.out.println("NAME:\t"+ i.getName());
//				System.out.println("COLOR:\t"+ i.getColor());
//				System.out.println("GENDER:\t"+ i.getGender());
//				System.out.println("SIZE:\t"+ i.getSize());
//				System.out.println("PRIZE:\t"+ i.getPrice());
//				System.out.println("RATING:\t"+ i.getRating());
//				System.out.println("AVALIABILITY:\t"+ i.getAvalibilty());
//				System.out.println();
//			});
//			
//			
//		}
		
		if (matchedTshirts.isEmpty()) {
          //  System.out.println("");
			throw new CustomException("Sorry, no t-shirt is available of your required choice");
        } else {
            System.out.printf("%-15s%-30s%-15s%-10s%-10s%-10s%-10s%-15s%n", "ID", "NAME", "COLOR", "GENDER", "SIZE", "PRICE", "RATING", "AVAILABILITY");
            System.out.println("======================================================================================================================");
            for (Tshirt tshirt : matchedTshirts) {
             System.out.printf("%-15s%-30s%-15s%-10s%-10s%-10s%-10s%-15s%n", tshirt.getID(), tshirt.getName(), tshirt.getColour(), tshirt.getGender(), tshirt.getSize(), tshirt.getPrice(), tshirt.getRating(), tshirt.getAvailability());
            }
        }
    }
	
}