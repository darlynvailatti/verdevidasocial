package br.com.verdevida.social.app.pattern.common;

import br.com.verdevida.social.app.exception.BusinessLogicException;

public interface IConverter<Entrada,Saida> {

    Saida converte(Entrada entrada) throws BusinessLogicException;
}
