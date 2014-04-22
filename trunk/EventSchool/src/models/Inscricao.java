package models;

public class Inscricao {
	
	private int idInscricao;
	private Participante participante;
	private Atividade atividade;
	
	
	public int getIdInscricao() {
		return idInscricao;
	}
	public void setIdInscricao(int idInscricao) {
		this.idInscricao = idInscricao;
	}
	public Participante getParticipante() {
		return participante;
	}
	public void setParticipante(Participante participante) {
		this.participante = participante;
	}
	public Atividade getAtividade() {
		return atividade;
	}
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	
	

}
