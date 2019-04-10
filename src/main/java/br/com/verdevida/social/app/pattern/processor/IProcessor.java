package br.com.verdevida.social.app.pattern.processor;

import br.com.verdevida.social.app.exception.BusinessLogicException;

public interface IProcessor<In extends AbstractProcessorDTO,Out extends AbstractProcessorDTO> {

    Out execute(In in) throws BusinessLogicException;
}
