package com.example.prj_tcshop.model.daos.impl;

import com.example.prj_tcshop.model.daos.RifaDao;
import com.example.prj_tcshop.model.entities.Rifa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RifaDaoPreparedStatement implements RifaDao {
    private Connection con;

    @Override
    public List<Rifa> findByNombre(String nombre) {
        return List.of();
    }

    @Override
    public void create(Rifa rifa) {
        String sql = "INSERT INTO rifas (nombre_rifa, fecha_rifa, precio_boleto, cantidad_boleto, sedes_idSede) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, rifa.getNombre());
            preparedStatement.setString(2, rifa.getFecha());
            preparedStatement.setString(3, rifa.getPrecio());
            preparedStatement.setString(4, rifa.getCantidad());
            preparedStatement.setString(5, rifa.getIdSede());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Rifa find(String id) {
        return null;
    }

    @Override
    public List<Rifa> findAll() {
        return List.of();
    }

    @Override
    public void update(Rifa rifa) {
        String sql = "UPDATE rifas SET nombre_rifa = ?, fecha_rifa = ?, precio_boleto = ?, cantidad_boleto = ?, sedes_idSede = ? WHERE idrifas = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, rifa.getNombre());
            preparedStatement.setString(2, rifa.getFecha());
            preparedStatement.setString(3, rifa.getPrecio());
            preparedStatement.setString(4, rifa.getCantidad());
            preparedStatement.setString(5, rifa.getIdSede());
            preparedStatement.setString(6, rifa.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Rifa id) {
        String sql = "DELETE FROM rifas WHERE idrifas = ?";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, id.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
