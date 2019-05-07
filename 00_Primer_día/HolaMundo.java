class HolaMundo {
	public static void main (String argumentos []){
		System.out.println("Hola mundo");
		for (int i=0; i<argumentos.length; i++){
			System.out.println("Arg "+ i + " = " + argumentos[i]);
		}
		int entero = 2012345678;
		long enteroLargo = 10123456789l;
		float decimal = 1234567890123456789f;
		double doble = 1234567890123456789d;
		byte unByte = -128; //Hasta 127
		char caracter = 'A';
		String texto = "Hola" + "-" + "Mundo " + caracter;
		System.out.println(texto);
		System.out.println("Entero = "+ entero);
		System.out.println("Entero largo = "+ enteroLargo);
		System.out.println("Decimal = "+ decimal);
		System.out.println("Doble = "+doble);
		System.out.println("Byte = "+unByte);
	}
}
/*"C:\Program Files\Java\jdk1.8.0_211\bin\javac.exe" "C:\Users\Admin\Desktop\CURSO_JAVA\HolaMundo.java"*/
/*C:\Users\Admin\Desktop\CURSO_JAVA>"C:\Program Files\Java\jdk1.8.0_211\bin\java.exe" HolaMundo*/
/*java HolaMundo ArgA Argum2 Otroarg "Ultimo arg"*/