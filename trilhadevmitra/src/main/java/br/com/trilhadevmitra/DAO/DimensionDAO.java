package br.com.trilhadevmitra.DAO;

import br.com.trilhadevmitra.model.Dimension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class DimensionDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Dimension> getAllDimension() {
        return jdbcTemplate.query("SELECT * FROM INT_DIMENSION",
                new BeanPropertyRowMapper<Dimension>(Dimension.class));
    }

    public String save(Dimension dimension) {
        int status = jdbcTemplate.update("INSERT INTO INT_DIMENSION (NAME, IDDATATYPE) VALUES(?,?)",
                dimension.getName(), dimension.getIdDataType());
        return status == 1 ? "Dimensão: "+dimension.getName()+" Salvo com Sucesso" : "Erro ao salvar";
    }

    public String update(Dimension dimension) {
        int status = jdbcTemplate.update("UPDATE INT_DIMENSION SET NAME = ?, IDDATATYPE = ? WHERE ID = ?",
                dimension.getName(), dimension.getIdDataType(), dimension.getId());
        return status == 1 ? "Dimensão: "+dimension.getName()+" Atualizada com Sucesso" : "Erro ao Atualizar";
    }

    public String delete(int id) {
        int status = jdbcTemplate.update("DELETE FROM INT_DIMENSION WHERE ID = ?", id);
        return status == 1 ? "Deletado com Sucesso" : "Erro ao Deletar";
    }
}
