import javax.swing.JOptionPane;
public class Procesos {

	String nombres [];
	int edades[];
	
	public void iniciar() {

		
		String menu="GESTION ESTUDIANTES\n";
		menu+="1. Pedir datos estudiante\n";
		menu+="2. Indique cual es el promedio de las edAdes\n";
		menu+="3. indique cual o cuales es el estudiante de mayor edad del grupo\n";
		menu+="4. indique cual o cuales es el estudiante de menor edad del grupo\n";
		menu+="5. indique cuantos estudiantes son mayores de edad\n";
		menu+="6. busqueda por nombre\n";
		menu+="7. busqueda por edad\n";
		menu+="8. salir\n";
		menu+="Ingrese una opción\n";
		
		int opc=0;

		do {
			opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
			crearMenu(opc);
		} while (opc!=8);
	}
	
	public void crearMenu(int opcion) {

		
			switch (opcion) {
			case 1:
				llenarDatos();			
				break;
			case 2: 
				if (validarLlenado()) {
					promedio();	
				}					
				break;
			case 3: 
				if (validarLlenado()) {
					mayor(nombres);
				}
				break;
			case 4: 
				if (validarLlenado()) {
					menor(nombres);
				}
				break;
			case 5:
				if (validarLlenado()) {
					mayorYMenor(edades);
				}
				break;
			case 6:
				if (validarLlenado()) {
					buscarPorNombre();
				}
				break;
			case 7:
				System.out.println("no alcanze a terminar:( ");
				break;
			case 8: 
				System.out.println("chao!!");
				break;
			default:System.out.println("No existe el codigo");
				break;
			}
	}
	
	public boolean validarLlenado() {
		if (nombres!=null) {
			return true;	
		}else {
			System.out.println("Debe llenar datos");
			return false;
		}
	}
	
	public void llenarDatos() {
		int tam=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes"));
		nombres=new String[tam];
		edades=new int[tam];
		
		for (int i = 0; i < nombres.length; i++) {
			nombres[i]=JOptionPane.showInputDialog("Ingrese el nombre");
			edades[i]=Integer.parseInt(JOptionPane.showInputDialog("ingresa la edad"));
			System.out.println("Nombre: " + nombres[i]+ " y su edad es:"+ edades[i]);

			
		}
	}
	

	public void promedio() {
		double suma=0;
		for (int i = 0; i < edades.length; i++) {
			suma=suma+edades[i];
		}
		System.out.println("el promedio de edades es: "+suma/edades.length);
	}
	
	public void mayor(String[] a) {
		for(int i = 0; i<edades.length; i++) {
			if(edades[i] >= 18)
			System.out.print(a[i] + " - ");
		}
		System.out.println("son los estudiantes mayores de edad");

	}
	
	public void menor(String[]a) {
		for(int i = 0; i<edades.length; i++) {
			if(edades[i] < 18)
			System.out.print(a[i] + " - ");
		}
		System.out.println("son los estudiantes menores de edad");
	}
	
	public void mayorYMenor(int[] a) {
		int minor = a[0],major = a[0];
		String minorNames = "",majorNames = "";
		for(int el: a) {
			if(el>major) {
				major=el;
			}
			if (el<minor) {
				minor=el;
			}
		}
		for(int el = 0; el<a.length; el++) {
			if (a[el] == minor) {
				minorNames += nombres[el] + " ";
			} else if (a[el] == major) {
				majorNames += nombres[el] + " ";
			}
		}
	System.out.println("los estudiantes mayores son "+majorNames);
	}
	
	
	
	
	public void buscarPorNombre() {
		System.out.println("Buscar nombre");
		int cont=0;
		String nombreBuscar=JOptionPane.showInputDialog("Ingrese el nombre a buscar");
		
		for (int i = 0; i < nombres.length; i++) {
			if (nombres[i].equalsIgnoreCase((nombreBuscar))) {
				System.out.println("Encuentra a "+nombreBuscar+" en la pos: "+i);
				cont++;
			}
		}
		
		if (cont>0) {
			System.out.println("Encontró a "+nombreBuscar+" "+cont+" veces");
		}else {
			System.out.println("No encuentra a "+nombreBuscar);
		}
		
		
	}
}
