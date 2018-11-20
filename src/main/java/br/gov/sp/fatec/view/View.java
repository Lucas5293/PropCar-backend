package br.gov.sp.fatec.view;

/**
 * Esta classe define as diferentes visualizacoes disponiveis para serializacoes
 */
public class View {

	/**
	 * Visualizacao da pessoa sem id
	 */
	public static class PessoaSemId {
	}

	/**
	 * Visualizacao da pessoa com id
	 */
	public static class PessoaComId extends PessoaSemId {
	}

	/**
	 * Visualizacao com todos os atributos da pessoa e
	 * com automóvel
	 */
	public static class PessoaComAutomovel extends PessoaComId {
	}

}
