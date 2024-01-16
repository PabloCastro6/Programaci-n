package com.paula.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.paula.hospital.dtos.RecetaMedicaDTO;
import com.paula.hospital.utils.DBUtils;

public class RecetasMedicaModelo {

	public List<RecetaMedicaDTO> buscaRecetaMedica(String id, String nombrePaciente, String nombreMedico,
			String nombreMedicamento, String fecha, String cantidadPrescrita) throws ClassNotFoundException, SQLException {

		String query = "SELECT * FROM RecetasMedicas rm INNER JOIN Pacientes p ON rm.PacienteID = p.ID "
				+ "INNER JOIN Medicos m ON rm.MedicoID = m.ID INNER JOIN Farmacia f ON rm.MedicamentoID = f.ID "
				+ "WHERE p.Nombre LIKE ? " + "AND m.Nombre LIKE ? " + "AND f.Nombre LIKE ? " + "AND rm.ID LIKE ? "
				+ "AND rm.Fecha LIKE ? " + "AND rm.CantidadPrescrita LIKE ?";

		Connection conexionBD = DBUtils.conexionBBDD();
		PreparedStatement ps = conexionBD.prepareStatement(query);

		ps.setString(1, "%" + nombrePaciente + "%");
		ps.setString(2, "%" + nombreMedico + "%");
		ps.setString(3, "%" + nombreMedicamento + "%");
		ps.setString(4, "%" + id + "%");
		ps.setString(5, "%" + fecha + "%");
		ps.setString(6,  "%" + cantidadPrescrita + "%");

		ResultSet recetaMedicaRS = ps.executeQuery();
		List<RecetaMedicaDTO> listaRecetasMedicas = new ArrayList<>();

		while (recetaMedicaRS.next()) {
			RecetaMedicaDTO recetaMedica = new RecetaMedicaDTO(recetaMedicaRS.getInt("ID"),
					recetaMedicaRS.getString("p.Nombre"), recetaMedicaRS.getString("m.Nombre"),
					recetaMedicaRS.getString("f.Nombre"), recetaMedicaRS.getString("Fecha"),
					recetaMedicaRS.getInt("CantidadPrescrita"));
			listaRecetasMedicas.add(recetaMedica);
		}

		conexionBD.close();
		return listaRecetasMedicas;
	}

	public Integer insertarRecetaMedica(int id, String nombrePaciente, String nombreMedico, String nombreMedicamento,
			String fecha, int cantidadPrescrita) throws SQLException, ClassNotFoundException {

		String sql = "INSERT INTO RecetasMedicas (ID, PacienteID, MedicoID, MedicamentoID, Fecha, CantidadPrescrita)"
				+ "VALUES (?, (SELECT p.ID FROM Pacientes p WHERE p.Nombre = ? ), (SELECT m.ID FROM Medicos m WHERE m.Nombre = ? ), (SELECT f.ID FROM Farmacia f WHERE f.Nombre = ? ), ?, ?)";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setInt(1, id);
		ps.setString(2, nombrePaciente);
		ps.setString(3, nombreMedico);
		ps.setString(4, nombreMedicamento);
		ps.setString(5, fecha);
		ps.setInt(6, cantidadPrescrita);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}

	public Integer actualizarRecetaMedica(int id, String nombrePaciente, String nombreMedico, String nombreMedicamento,
			String fecha, int cantidadPrescrita) throws SQLException, ClassNotFoundException {

		String sql = "UPDATE RecetasMedicas SET PacienteID = CASE WHEN ? = '' THEN PacienteID ELSE (SELECT p.ID FROM Pacientes p WHERE p.Nombre = ? ) END,"
				+ "MedicoID = CASE WHEN ? = '' THEN MedicoID ELSE (SELECT m.ID FROM Medicos m WHERE m.Nombre = ? ) END,"
				+ "MedicamentoID = CASE WHEN ? = '' THEN MedicamentoID ELSE (SELECT f.ID FROM Farmacia f WHERE f.Nombre = ? ) END,"
				+ "Fecha = CASE WHEN ? = '' THEN Fecha ELSE ? END,"
				+ "CantidadPrescrita = CASE WHEN ? = '' THEN CantidadPrescrita ELSE ? END " + "WHERE ID = ?";

		Connection connection = DBUtils.conexionBBDD();
		PreparedStatement ps = null;
		Integer resultado = null;

		ps = connection.prepareStatement(sql);

		ps.setString(1, nombrePaciente);
		ps.setString(2, nombrePaciente);

		ps.setString(3, nombreMedico);
		ps.setString(4, nombreMedico);

		ps.setString(5, nombreMedicamento);
		ps.setString(6, nombreMedicamento);

		ps.setString(7, fecha);
		ps.setString(8, fecha);

		ps.setInt(9, cantidadPrescrita);
		ps.setInt(10, cantidadPrescrita);

		ps.setInt(11, id);

		resultado = ps.executeUpdate();

		connection.close();

		return resultado;
	}

}
