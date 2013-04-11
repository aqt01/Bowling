Laboratorio de Técnica Fundamentales de Software 
Profesor: Francisco Pereza 
Integrantes: 
-	Enrique Evertz 10-0917 (Evertz5)
-	Victor Polanco 10-0715 (vmp2408)
-	Lowell Abbott 11-0697 (aqt01)
	         
Entrega del proyecto inicial “Bowling”

Descripción: 
En nuestra primera versión de la aplicación de bowling podemos contemplar los siguientes caracteres:
Contiene 3 paquetes las cuales los nombremos 
-	Controller 
-	Model 
-	View
Cada paquete contiene clases específicas que hacen una tarea x, permitiendo que la aplicación trabaje correctamente.
1.	Dentro del Controller esta:  
-	Master.Java: Maneja todo, es el main de la aplicación
2.	Dentro del Model están:
-	File-Reader.Java: coge los archivos y lo entra a la lista.
-	Input-Handler.Java: verifica si el archivo está correcto.
-	Player.Java: Tiene todos los datos de la partida.
-	ResHalper.Java: Recursos, contiene todo con respecto a la aplicación.
-	Shot.Java: Contiene los datos del toro.
3.	Detro del View están:
-	BowFrame.Java: es el view de la aplicación.
-	InitFrame.Java: Busca el archivo del frame.
-	SimpleProgressBar.Java: es la barra completa.
-	Table.Java: La tabla de cada panel.
-	TablaPanel.Java: contiene los paneles donde se ven.
-	SplashScreen.Java: llama al Splash.

En la reciente versión agregamos una clase dentro del paquete Test, en el cual este paquete fue añadido.
4.	Dentro de Test esta:
-	TestCaseFileBuilder: esta es una clase para testiar los score de la aplicación, este crea un archivo con puntación aleatorias, aunque también se encuentra un método que le inserta basura al score para analizar el comportamiento de la aplicación en estos casos.
