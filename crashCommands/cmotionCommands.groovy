import org.crsh.cli.*
import org.crsh.command.*

@Usage("Un par de comandos de prueba para Codemotion 2015")
class cmotionCommands {
        @Usage("Comando para decir hola")
        @Command
        public String diHola(
                @Argument @Required String nombre ){
                String hola = metodoHola()
                return "${hola} ${nombre}!"
        }
        def metodoHola(){
          out.println("Estamos en el metodoHola", red)
          return "Hola"
        }

        // -----------------------------------------------------------------

        @Usage("Comando para decir adios")
        @Man("Informacion extendida del comando diAdios")
        @Command
        public String diAdios(
                @Usage("Tratamiento opcional para incluir")
                @Option(names=["t","tratamiento"])
                String tratamiento,
                // -------------
		            @Argument
		            @Required
		            String nombre ) {

                tratamiento = (tratamiento == null ? "" : tratamiento)
		            out.println("El tratamiento es [${tratamiento}] y el nombre es [${nombre}]", green)
                return "Adios ${tratamiento} ${nombre}"
        }
}
