package poo;
import java.util.Scanner;

/**
 * @author João Pedro Teixeira
 *
 */
public class Main {

	public static final String CAPSULES_OF_COFFEE = "CAPSULAS";
	public static final String RESERVOIR = "RESERVATORIO";
	public static final String COFFEE = "CAFE";
	public static final String WATER = "AGUA";
	public static final String QUANTITY_PER_COFFEE= "QUANTIDADE";
	public static final String SHORT_COFFEE = "CURTO";
	public static final String NORMAL_COFFEE = "NORMAL";
	public static final String LUNGU_COFFEE = "LONGO";
	public static final String ALL_CAPSULES = "CAPSULAS ALL";
	public static final String CAPSULES_BY_TYPE = "CAPSULAS";
	public static final String END = "Sair";
	
	//Mensagens do sistema
	public static final String SERVED = "servido.";
	public static final String WATER_PER_COFFEE = "Quantidade de agua a usar por cafe:";
	public static final String ADD_WATER = "Foram adicionados";
	public static final String ADD_WATER1 = "de agua.";
	public static final String RESERVOIR_WATER = "O reservatorio de agua contem";
	public static final String LIST_CAPSULES = "A sequencia das";
	public static final String LIST_CAPSULES1 = "capsulas utilizadas e a seguinte";
	public static final String LIST_CAPSULES2 = "capsulas do tipo";
	public static final String LIST_CAPSULES3 = "utilizadas e a seguinte:";
	public static final String END_MESSAGE = "Fim de execucao do programa.";
	public static final String RESIDUAL_CAFFEINE = "Cafeina residual:";
	public static final String UNKNOWN_COFFEE = "Tipo de cafe desconhecido.";
	
	public static final String WRONG_COMM = "Comando errado";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String comm = getCommand(in);
		CoffeeMachine machine = new CoffeeMachineClass();

		//Interpretador de comandos
		while(!comm.equals(END)){
			if(comm.equals(COFFEE))
			servingCoffee(in, machine);
			else if(comm.equals(CAPSULES_OF_COFFEE))
			listAll(machine);
			else if(comm.equals(RESERVOIR))
			getWaterLevelOFReservoir(machine);
			else if(comm.equals(WATER))
			setFillReservoir(machine);
			else if(comm.equals(QUANTITY_PER_COFFEE))
			coffeeWater(machine);
			else if(comm.equals(SHORT_COFFEE))
			setShort(machine);
			else if(comm.equals(NORMAL_COFFEE))
			setNormal(machine);
			else if(comm.equals(LUNGU_COFFEE))
			setLungu(machine);
			else if(comm.equals(ALL_CAPSULES))
			listAll(machine);
			else 
			System.out.println(WRONG_COMM);
			comm = getCommand(in);
		}
	if(comm.equals(END))
		System.out.println("Fim de execucao do programa");
		in.close();
}
	
	private static String getCommand(Scanner in){
		
		String input = "";
		System.out.print("> ");
		input = in.next().toUpperCase();
		return input;
	}
	
	public static void servingCoffee(Scanner in, CoffeeMachine machine){
		
		String type, name, colour;
		
		type = in.next();
		name = in.next();
		colour = in.next();
		
		if(!machine.underLimit())
			System.out.println("A maquina ja serviu o numero maximo de cafes.");
		
		else if(!machine.hasWaterReservoir())
			System.out.println("Nao e possivel servir o cafe indicado.");
		
		else if(!machine.hasCapsuleType(type))
			System.out.println("Tipo de cafe desconhecido.");
		
		else{
			machine.servingCoffee(type, name, colour);
			System.out.println(type + " " + name + " " + "servido.");
		}
	}
	
	public static void setShort(CoffeeMachine machine){
		
		machine.setShort();
		System.out.println(WATER_PER_COFFEE + " " + machine.coffeeWater() + " " + "ml.");
	}
	
	public static void setNormal(CoffeeMachine machine){
		
		machine.setNormal();
		System.out.println(WATER_PER_COFFEE + " " + machine.coffeeWater() + " " + "ml.");
	}
	
	public static void setLungu(CoffeeMachine machine){
		
		machine.setLongu();
		System.out.println(WATER_PER_COFFEE + " " + machine.coffeeWater() + " " + "ml.");
	}
	
	public static void coffeeWater(CoffeeMachine machine){
		
		System.out.println(WATER_PER_COFFEE + " " + machine.coffeeWater() + " " + "ml.");
	}
	
	public static void setFillReservoir(CoffeeMachine machine){
		
		System.out.println(ADD_WATER + " " + machine.fillReservoir() + " ml" + " " + ADD_WATER1);
	}
	
	public static void getWaterLevelOFReservoir(CoffeeMachine machine){
		
		System.out.println(RESERVOIR_WATER + " " + machine.waterLevelOfReservoir() + " " + "ml.");
	}
	
	public static void listAll(CoffeeMachine machine){
		
		Iterator i = machine.allCapsules();
		if(i.hasNext()){
			while(i.hasNext()){
			
			CapsuleOfCoffee cc = i.next();
			System.out.println(cc.getCoffeeType() + " " + cc.getName() + " " + cc.getColour() + "." + " " + RESIDUAL_CAFFEINE + " " + cc.getResidualCaffeine() + " " + "mg");
			}
		}
		else
		System.out.println("Nao existem cafes para listar.");	
	}
	
	public static void listByType(String type, CoffeeMachine machine){
		
		Iterator i = machine.typeCapsule(type);
		if(machine.hasCapsuleType(type)){
			System.out.println("A sequencia das (" + machine.getCounter() + ") capsulas do tipo" + type + " utilizadas e a seguinte:");
			
			while(i.hasNext()){

			CapsuleOfCoffee cc = i.next();
			System.out.println(cc.getName() + "." + " " + RESIDUAL_CAFFEINE + " " + cc.getResidualCaffeine() + " " + "mg");
			}
		}
		else
			System.out.println(UNKNOWN_COFFEE);
	}
}