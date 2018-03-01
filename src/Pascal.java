import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Pascal {
	public static void main(String[] args) throws FileNotFoundException {
		if(args.length != 1)
			return;
		
		Scanner inputFile = new Scanner(new File(args[0]), "UTF-8");
		
		String l1 = inputFile.nextLine();
		//System.out.println(l1);
		String[] params = l1.split(" ");
		inputFile.close();
		
		int r, c, f, n, b, t, number_vehicules, number_rides;
		r = Integer.parseInt(params[0]);
		c = Integer.parseInt(params[1]);
		f = number_vehicules = Integer.parseInt(params[2]);
		n = number_rides = Integer.parseInt(params[3]);
		b = Integer.parseInt(params[4]);
		t = Integer.parseInt(params[5]);
		
		int nb_rides = number_rides/number_vehicules;
		int bonus_rides = number_rides % (nb_rides*number_vehicules);
		
		int current_ride=0;
		
		System.out.print(nb_rides+bonus_rides + " ");
		for(int i = 0; i < nb_rides+bonus_rides; i++) {
			System.out.print(current_ride + " ");
			
			current_ride++;
		}
		System.out.println();
		for(int vehicule=1; vehicule < number_vehicules; vehicule++) {
			System.out.print(nb_rides + " ");
			for(int i = 0; i < nb_rides; i++) {
				System.out.print(current_ride + " ");
				
				current_ride++;
			}
			System.out.println();
		}
	}
}
