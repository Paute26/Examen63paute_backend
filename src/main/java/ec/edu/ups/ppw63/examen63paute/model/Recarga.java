package ec.edu.ups.ppw63.examen63paute.model;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "RECARGAS" )
public class Recarga {
	
	@Id
	@Column(name = "CODIGO", unique = true, nullable= false, precision = 5, scale = 0)
	private int codigo;
	
	@Column(name = "NUMERO", unique = false, nullable= false, length=13)
	private String numero;
	
	@Column(name = "OPERADORA", unique = false, nullable= false, length=100)
	private String operadora;
	
	@Column(name = "MONTO", unique = false, nullable= false, length=20)
	private String monto;
	
	/*@OneToMany
	@JoinColumn(name = "ID_CLIENTE")
	public List<EncabezadoFactura> encabezadoFacturas;*/

	
	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo  + ",| NUMERO=" + numero + ", Operadora=" + operadora + ", Monto=" + monto +"]";
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

}
