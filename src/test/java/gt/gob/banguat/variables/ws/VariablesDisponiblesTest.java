package gt.gob.banguat.variables.ws;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VariablesDisponiblesTest {

	@Test
	void test() {
		TipoCambioSoap servicio = new TipoCambio().getTipoCambioSoap();
		//int tm = servicio.variablesDisponibles().getTotalItems();
		
		for (Variable array : servicio.variablesDisponibles().getVariables().variable) {
			if (array.moneda % 2 == 0) {
				System.out.println("Codigo de Moneda: "+array.moneda+" Nombre de la moneda: "+array.descripcion);
		    } 
			
		}	
	}

}
