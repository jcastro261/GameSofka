/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sofka.game.view;


public class Nivel {
    	private long idNivel;
	private int nivel;
	private int premio;

	public Nivel() {

	}

	public Nivel(long idNivel, int nivel, int premio) {
		super();
		this.idNivel = idNivel;
		this.nivel = nivel;
		this.premio = premio;
	}

	public long getIdNivel() {
		return idNivel;
	}

	public void setIdNivel(long idNivel) {
		this.idNivel = idNivel;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getPremio() {
		return premio;
	}

	public void setPremio(int premio) {
		this.premio = premio;
	}
}
