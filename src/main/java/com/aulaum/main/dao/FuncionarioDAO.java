/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aulaum.main.dao;

import com.aulaum.main.model.FuncionarioBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class FuncionarioDAO {
    
    public List<FuncionarioBean> listaFuncionarios() {
        List<FuncionarioBean> lista = new ArrayList();
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("select * from funcionarios");
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                FuncionarioBean funcionarios = new FuncionarioBean();
                funcionarios.setId(rs.getInt("id"));
                funcionarios.setNome(rs.getString("nome"));
                funcionarios.setCargo(rs.getString("cargo"));
                funcionarios.setDepartamento(rs.getString("departamento"));
                funcionarios.setEmail(rs.getString("email"));
                funcionarios.setDataContratacao(rs.getDate("data_contratacao"));
                
                lista.add(funcionarios);
            }     
                    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}