package gt.gob.banguat.variables.ws;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TipoCambioRangoTest {

	@Test
	void test() {
		TipoCambioSoap servicio = new TipoCambio().getTipoCambioSoap();
		for (Var array : servicio.tipoCambioRango("30/07/2020", "31/07/2020").vars.var) {
			System.out.println(array.fecha+" "+array.moneda+" Compra: "+array.compra+" Venta: "+array.venta);
		}
	}

}
