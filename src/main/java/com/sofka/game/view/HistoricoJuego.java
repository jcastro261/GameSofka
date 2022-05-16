/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofka.game.view;

public class HistoricoJuego {
    private long idHistoria;
	private int respuestaCorrecta;
	private int premioObtenido;
	private Usuario usuario;
	
	public HistoricoJuego() {
		
	}

	public HistoricoJuego(int respuestaCorrecta, int premioObtenido, Usuario usuario) {
		super();
		this.idHistoria = idHistoria;
		this.respuestaCorrecta = respuestaCorrecta;
		this.premioObtenido = premioObtenido;
		this.usuario = usuario;
	}

	public long getIdHistoria() {
		return idHistoria;
	}

	public void setIdHistoria(long idHistoria) {
		this.idHistoria = idHistoria;
	}

	public int getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	public void setRespuestaCorrecta(int respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}

	public int getPremioObtenido() {
		return premioObtenido;
	}

	public void setPremioObtenido(int premioObtenido) {
		this.premioObtenido = premioObtenido;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
