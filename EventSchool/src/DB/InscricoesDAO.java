package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Inscricao;

public class InscricoesDAO {
	public static boolean adicionarInscricao(Inscricao inscricao){
		
		String sql = "insert into inscricao " +
				"(participante_pk, ativiadade_pk)" +
				" values (?,?)";
		try {
			// prepared statement para insersão
			Connection con = ConnectionMannager.getConnetion();
			PreparedStatement stmt = con.prepareStatement(sql);
			// seta os valores
			stmt.setInt(1,inscricao.getParticipante().getIdUsuario());
			stmt.setInt(2,inscricao.getAtividade().getIdAtividade());
			// executa
			stmt.execute();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	
	
	public static boolean cancelarInscricao(Inscricao inscricao){
		
		try {
			Connection con = ConnectionMannager.getConnetion();
			PreparedStatement stmt = con.prepareStatement("delete * from inscricao where "
					+ "inscricao_pk=?");
			stmt.setInt(1, inscricao.getIdInscricao());
			stmt.execute();
			stmt.close();
			con.close();
			} catch (SQLException e) {
				return false;
			}
		return true;
	}	
	
}
