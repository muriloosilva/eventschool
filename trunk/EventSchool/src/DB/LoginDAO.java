package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.User;

public class LoginDAO {
	
	public static User loginUser(User user){
		PreparedStatement stmt;
		User userBD = null;
		try {
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from usuarios " +
					"where loginusuario = ? and papelusuario = 'user'");
			stmt.setString(1,user.getLogin());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Contato
				userBD = new User();
				userBD.setId(rs.getInt("idusuario"));
				userBD.setName(rs.getString("nomeusuario"));
				userBD.setLogin(rs.getString("loginusuario"));
				userBD.setPasswd(rs.getString("senhausuario"));
				userBD.setRole(rs.getString("papelusuario"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(userBD != null){
			if(userBD.getLogin().equals(user.getLogin()) 
					&& userBD.getPasswd().equals(user.getPasswd())){
				userBD.setLogged(true);
			}
			else
				userBD.setLogged(false);
		}
		return userBD;
	}
	
	public static User loginAdmin(User user){
		PreparedStatement stmt;
		User userBD = null;
		try {
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from usuarios where loginusuario = ? and papelusuario = 'admin'");
			stmt.setString(1,user.getLogin());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Contato
				userBD = new User();
				userBD.setId(rs.getInt("idusuario"));
				userBD.setName(rs.getString("nomeusuario"));
				userBD.setLogin(rs.getString("loginusuario"));
				userBD.setPasswd(rs.getString("senhausuario"));
				userBD.setRole(rs.getString("papelusuario"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(userBD != null){
			if(userBD.getLogin().equals(user.getLogin()) && userBD.getPasswd().equals(user.getPasswd())){
				userBD.setLogged(true);
			}
			else
				userBD.setLogged(false);
		}
		return userBD;
	}
	
	public static void teste(){
		PreparedStatement stmt;
		User userBD = null;
		try {
			Connection con = ConnectionMannager.getConnetion();
			stmt = con.prepareStatement("select * from usuarios");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				// criando o objeto Contato
				userBD = new User();
				System.out.println(rs.getInt("idusuario"));
				System.out.println(rs.getString("nomeusuario"));
				System.out.println(rs.getString("loginusuario"));
				System.out.println(rs.getString("senhausuario"));
				System.out.println(rs.getString("papelusuario"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
