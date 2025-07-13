# **Arquitectura en Capas (N-Capas) y Documentación con Javadoc**  
*Un enfoque práctico para Fundamentos de Programación*  

---

## **1. ¿Qué es la Arquitectura en Capas (N-Capas)?**  
La arquitectura en capas es un **patrón de diseño** que organiza un sistema en niveles o capas independientes, donde cada una tiene una responsabilidad específica.  

### **🔹 Beneficios**  
✅ **Separación de preocupaciones**: Cada capa se enfoca en una tarea concreta.  
✅ **Mantenibilidad**: Facilita la modificación de una capa sin afectar las demás.  
✅ **Reusabilidad**: Las capas pueden usarse en otros proyectos.  
✅ **Escalabilidad**: Permite agregar nuevas funcionalidades sin romper el sistema.  

---

## **2. Capas en el Ejemplo de Pizzalator**  
El proyecto **Pizzalator** sigue una arquitectura de **3 capas**:  

| **Capa**       | **Responsabilidad**                          | **Ejemplo en Pizzalator**                     |
|----------------|---------------------------------------------|-----------------------------------------------|
| **Presentación** | Interfaz de usuario (menús, entradas/salidas) | `Presentacion.java` (Muestra opciones al usuario) |
| **Lógica**      | Procesamiento de datos y reglas de negocio    | `Logica.java` (Calcula áreas, precios, etc.)     |
| **Datos**       | Almacenamiento y recuperación de información  | `Datos.java` (Guarda el historial de pizzas)    |

### **📌 Flujo de Datos**  
```
Usuario → Presentación → Lógica → Datos → Lógica → Presentación → Usuario
```  
*(Ejemplo: Registrar una pizza → Calcular su área → Guardar en historial → Mostrar resultados)*  

---

## **3. Importancia de la Arquitectura por Capas**  
- **Evita código espagueti**: Sin capas, todo estaría mezclado (interfaz, cálculos y datos).  
- **Facilita pruebas**: Puedes probar la lógica sin necesidad de la interfaz gráfica.  
- **Trabajo en equipo**: Diferentes personas pueden trabajar en capas separadas.  

> **💡 Analogía**: Como una hamburguesa:  
> - **Pan superior (Presentación)**: Lo que ves.  
> - **Carne/vegetales (Lógica)**: La preparación.  
> - **Pan inferior (Datos)**: Base que sostiene todo.  

---

## **4. Documentación con Javadoc**  
### **¿Qué es?**  
Javadoc es una herramienta que genera **documentación HTML** a partir de comentarios especiales en el código Java.  

### **📝 Ejemplo de Comentario**  
```java
/**
 * Calcula el área de un círculo.
 * @param radio Radio del círculo (en pulgadas).
 * @return Área en pulgadas cuadradas.
 */
public static double calcularArea(double radio) {
    return Math.PI * Math.pow(radio, 2);
}
```  

### **🛠️ Cómo Generar Javadoc en VSCode**  
1. **Asegúrate de tener el JDK instalado**.  
2. **Abre una terminal** en VSCode (`Ctrl + `` `).  
3. **Ejecuta**:  
   ```bash
   javadoc -d docs -sourcepath src -subpackages pizzalator
   ```  
   - `-d docs`: Guarda la documentación en la carpeta `docs`.  
   - `-sourcepath src`: Indica dónde está el código fuente.  
4. **Abre `docs/index.html`** para ver la documentación.  

### **📌 Importancia de Javadoc**  
- **Documentación viva**: Se actualiza con el código.  
- **Ayuda a otros desarrolladores**: Explica cómo usar tus clases/métodos.  
- **Profesionalismo**: Estándar en la industria Java.  

---

## **5. Conclusión**  
- **Arquitectura en capas** = Código organizado y mantenible.  
- **Pizzalator** = Ejemplo práctico de 3 capas (Presentación, Lógica, Datos).  
- **Javadoc** = Documentación automática para proyectos Java.  

**🔗 Recursos adicionales**:  
- [Documentación oficial de Javadoc](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html)  
- [Ejemplo completo en GitHub](https://github.com/tu-usuario/pizzalator)  
