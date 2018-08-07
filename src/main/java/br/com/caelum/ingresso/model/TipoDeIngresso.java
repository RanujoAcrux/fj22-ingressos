package br.com.caelum.ingresso.model;

import br.com.caelum.ingresso.model.desconto.SemDesconto;

import java.math.BigDecimal;

import br.com.caelum.ingresso.model.desconto.Desconto;
import br.com.caelum.ingresso.model.desconto.DescontoParaBancos;
import br.com.caelum.ingresso.model.desconto.DescontoParaEstudantes;

public enum TipoDeIngresso {

	INTEIRO(new SemDesconto()), ESTUDANTE(new DescontoParaEstudantes()), BANCO(new DescontoParaBancos());

	private final Desconto desconto;

	TipoDeIngresso(Desconto desconto) {
		this.desconto = desconto;
	}

	public BigDecimal aplicaDesconto(BigDecimal valor) {
		return desconto.aplicarDescontoSobre(valor);
	}

	public String getDescricao() {
		return desconto.getDescricao();
	}
}
