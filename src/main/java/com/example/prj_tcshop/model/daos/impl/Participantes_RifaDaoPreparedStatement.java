package com.example.prj_tcshop.model.daos.impl;

import com.example.prj_tcshop.model.daos.Participantes_RifaDao;
import com.example.prj_tcshop.model.entities.Participante_Rifa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Participantes_RifaDaoPreparedStatement implements Participantes_RifaDao {
    private Connection con;

    @Override
    public List<Participante_Rifa> findbyNombre(String nombre) {
        return List.of();
    }

    @Override
    public void create(Participante_Rifa participanteRifa) {
        String sql = "INSERT INTO participantes_rifa (numero_boleto, rifas_idrifa, usuarios_idUsuario) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, participanteRifa.getNumero());
            preparedStatement.setString(2, participanteRifa.getIdrifa());
            preparedStatement.setString(3, participanteRifa.getIdUsuario());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Participante_Rifa find(String id) {
        return null;
    }

    @Override
    public List<Participante_Rifa> findAll() {
        return List.of();
    }

    @Override
    public void update(Participante_Rifa participanteRifa) {
        String sql = "UPDATE participantes_rifa SET numero_boleto = ?, rifas_idrifa = ?, usuarios_idUsuario = ? WHERE idparticipante = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, participanteRifa.getNumero());
            preparedStatement.setString(2, participanteRifa.getIdrifa());
            preparedStatement.setString(3, participanteRifa.getIdUsuario());
            preparedStatement.setString(4, participanteRifa.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Participante_Rifa id) {
        String sql = "DELETE FROM participantes_rifa WHERE idparticipante = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, id.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
