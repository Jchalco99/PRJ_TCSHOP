package com.example.prj_tcshop.model.daos;

import com.example.prj_tcshop.model.entities.Rifa;

import java.util.List;

public interface RifaDao extends EntidadDao<Rifa, String> {
    public List<Rifa> findByNombre(String nombre);
}
