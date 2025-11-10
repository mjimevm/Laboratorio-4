# Laboratorio 4 - Programación Orientada a Objetos

Descripción
-----------
Este repositorio contiene el material y el código fuente del "Laboratorio 4" para la asignatura de Programación Orientada a Objetos. El objetivo del laboratorio es implementar conceptos de POO en Java (clases, herencia, encapsulamiento, polimorfismo y manejo básico de excepciones).

Requisitos
---------
- Java Development Kit (JDK) 11 o superior
- Un IDE compatible con Java (IntelliJ IDEA, Eclipse, VS Code) o herramientas de línea de comandos (javac/java)
- (Opcional) Maven o Gradle si se agrega soporte de build en el futuro

Instalación
-----------
Clona el repositorio:
```bash
git clone https://github.com/mjimevm/Laboratorio-4.git
cd Laboratorio-4
```

Compilación y ejecución (línea de comandos)
-------------------------------------------
Compila todos los archivos .java y deja los .class en el directorio `out` (comando para sistemas tipo Unix):
```bash
mkdir -p out
find . -name "*.java" > sources.txt
javac -d out @sources.txt
```

Ejecuta la aplicación (reemplaza `com.ejemplo.Main` con la clase que contenga el método `main` del proyecto):
```bash
java -cp out com.ejemplo.Main
```

Si trabajas en Windows sin `find`, puedes compilar con:
```powershell
Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName } > sources.txt
javac -d out @sources.txt
```

Ejecutar en un IDE
------------------
- Importa el proyecto en tu IDE preferido.
- Configura la clase con `main` como clase de ejecución y ejecuta desde el IDE.

Estructura del repositorio
--------------------------
(Ejemplo; ajusta según la estructura real del repositorio)
```
Laboratorio-4/
├─ src/                 # Código fuente Java
├─ out/                 # Archivos compilados (generado)
├─ README.md
```

Buenas prácticas y notas
------------------------
- Asegúrate de mantener los paquetes Java correctamente organizados (por ejemplo, `com.tuusuario.laboratorio4`).
- Documenta las clases y métodos importantes con comentarios Javadoc.
- Si agregas dependencias o tareas repetitivas, considera añadir un build tool (Maven o Gradle).

Contribuciones
--------------
Si quieres contribuir:
1. Haz fork del repositorio.
2. Crea una rama con tu mejora: `git checkout -b feat/mi-cambio`
3. Realiza tus cambios y commitea.
4. Abre un Pull Request describiendo los cambios.

Autor
-----
- mjimevm (https://github.com/mjimevm)
- AlejandroSagastume (https://github.com/AlejandroSagastume)

Licencia
--------
Este repositorio actualmente no contiene una licencia especificada. Si deseas que otros reutilicen tu código, añade un archivo `LICENSE` con la licencia deseada (por ejemplo MIT, Apache-2.0).

Contacto
--------
Si necesitas ayuda con el laboratorio o quieres compartir mejoras, abre una issue o contacta al autor a través de GitHub.
