package dominio;



public class Seguro {
	int idSeguro;
	String descripcion;
	int idTipo;
	float costoContratacion;
	float costoAsegurado;
	
	
	public Seguro(){}

	public Seguro(int idSeguro, String descripcion, int idTipo,float costoContratacion,float costoAsegurado) {
		super();
		this.idSeguro = idSeguro;
		this.descripcion = descripcion;
		this.idTipo = idTipo;
		this.costoContratacion = costoContratacion;
		this.costoAsegurado = costoAsegurado;
	}

	public int getIdSeguro() {
		return idSeguro;
	}

	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public float getCostoContratacion() {
		return costoContratacion;
	}

	public void setCostoContratacion(float costoContratacion) {
		this.costoContratacion = costoContratacion;
	}

	public float getCostoAsegurado() {
		return costoAsegurado;
	}

	public void setCostoAsegurado(float costoAsegurado) {
		this.costoAsegurado = costoAsegurado;
	}
	
	public String toString() {
	    return "Seguro{" +
	            "idSeguro=" + idSeguro +
	            ", descripcion='" + descripcion + '\'' +
	            ", idTipo=" + idTipo +
	            ", costoContratacion=" + costoContratacion +
	            ", costoAsegurado=" + costoAsegurado +
	            '}';
	}
	
}