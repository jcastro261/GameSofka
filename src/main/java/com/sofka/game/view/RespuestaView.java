/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofka.game.view;


public class RespuestaView {
    private long idRespuesta;
	private String respuesta;
	private boolean estado;
	
	public RespuestaView() {
		
	}

	public RespuestaView(String respuesta, boolean estado) {
		super();
		
		this.respuesta = respuesta;
		this.estado = estado;
	}

	public long getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(long idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

    @Override
    public String toString() {
        return "Respuesta{" + "respuesta=" + respuesta + ", estado=" + estado + '}';
    }
	
        
}
