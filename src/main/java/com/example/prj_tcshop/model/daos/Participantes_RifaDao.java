package com.example.prj_tcshop.model.daos;

import com.example.prj_tcshop.model.entities.Participante_Rifa;

import java.util.List;

public interface Participantes_RifaDao extends EntidadDao<Participante_Rifa, String> {
    public List<Participante_Rifa> findbyNombre(String nombre);
}
