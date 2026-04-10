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
    
    public int totalFuncionarios() {
        int total = 0;
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("select count(*) as total from funcionarios");
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                total = rs.getInt("total");
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
    
    
    
     public List<FuncionarioBean> listarFuncionariosTecnologia() {
        List<FuncionarioBean> lista = new ArrayList();
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("select * from funcionario where departamento ='Tecnologia'");
            rs = stmt.executeQuery();
            
             while(rs.next()) {
                FuncionarioBean funcionariosTec = new FuncionarioBean();
                funcionariosTec.setId(rs.getInt("id"));
                funcionariosTec.setNome(rs.getString("nome"));
                funcionariosTec.setCargo(rs.getString("cargo"));
                funcionariosTec.setDepartamento(rs.getString("departamento"));
                funcionariosTec.setEmail(rs.getString("email"));
                funcionariosTec.setDataContratacao(rs.getDate("data_contratacao"));
                
                lista.add(funcionariosTec);
            }     
                    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}