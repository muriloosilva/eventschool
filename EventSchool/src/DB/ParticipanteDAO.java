package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Participante;

public class ParticipanteDAO {
	public static boolean adicionarParticipante(Participante participante){
		
		String sql = "insert into participante " +
				"(nome, cpf, email, data_nascimento, senha)" +
				" values (?,?,?,?,?)";
		try {
			// prepared statement para insersão
			Connection con = ConnectionMannager.getConnetion();
			PreparedStatement stmt = con.prepareStatement(sql);
			// seta os valores
			stmt.setString(1,participante.getNome());
			stmt.setString(2,participante.getCpf());
			stmt.setString(3,participante.getEmail());
			stmt.setDate(4,participante.getDataNascimento());
			stmt.setString(5,participante.getSenha());
			// executa
			stmt.execute();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	
//	public static List<Evento> listaDeEventos(){
//		
//		PreparedStatement stmt;
//		List<Evento> eventos = new ArrayList<Evento>();
//		try {
//			Connection con = ConnectionMannager.getConnetion();
//			stmt = con.prepareStatement("select * from evento");
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				
//				Evento evento = new Evento();
//				evento.setId_evento(rs.getInt("evento_pk"));
//				evento.setNome(rs.getString("nome"));
//				evento.setDescricao(rs.getString("descricao"));
//				evento.setLocal(rs.getString("local"));
//				evento.setDataInicio(rs.getDate("data_inicio"));
//				evento.setDataFim(rs.getDate("data_fim"));
//				evento.setDataInicioInscricoes(rs.getDate("data_inicio_inscricoes"));
//				evento.setDataFimInscricoes(rs.getDate("data_fim_inscricoes"));
//				evento.setTelefone(rs.getString("telefone"));
//				evento.setEmail(rs.getString("email"));
//				eventos.add(evento);
//			}
//			rs.close();
//			stmt.close();
//			con.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		if(eventos.isEmpty())
//			return null;
//		else
//			return eventos;
//		
//	}
	
	public static Participante pegarParticipante(int id){
		
		PreparedStatement stmt;
		Participante participante = null;
		try {
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from participante where participante_pk = "+ id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Contato
				participante = new Participante();
				participante.setIdParticipante(rs.getInt("participante_pk"));
				participante.setNome(rs.getString("nome"));
				participante.setCpf(rs.getString("cpf"));
				participante.setEmail(rs.getString("email"));
				participante.setDataNascimento(rs.getDate("data_nascimento"));
				participante.setSenha(rs.getString("senha"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return participante;
		
	}
	
	public static boolean alterarParticipante(Participante participante){
		
		String sql = "update participante set nome=?, cpf=?, email=?," +
				"data_nascimento=?, senha=? where participante_pk=?";
		try {
			Connection con = ConnectionMannager.getConnetion();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			// seta os valores
			stmt.setString(1,participante.getNome());
			stmt.setString(2,participante.getCpf());
			stmt.setString(3,participante.getEmail());
			stmt.setDate(4,participante.getDataNascimento());
			stmt.setString(5,participante.getSenha());
			stmt.setInt(6, participante.getIdParticipante());
			stmt.execute();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			return false;
		}
		return true;

		
	}
	
	public static boolean deletarParticipante(Participante participante){
		
		try {
			Connection con = ConnectionMannager.getConnetion();
			PreparedStatement stmt = con.prepareStatement("delete * from participante where "
					+ "participante_pk=?");
			stmt.setInt(1, participante.getIdParticipante());
			stmt.execute();
			stmt.close();
			con.close();
			} catch (SQLException e) {
				return false;
			}
		return true;
	}	
	
}
