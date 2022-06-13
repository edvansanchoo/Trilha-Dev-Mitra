package br.com.trilhadevmitra.DAO;

import br.com.trilhadevmitra.model.Dimension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DimensionDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Dimension> getAllDimension() {
        return jdbcTemplate.query("SELECT * FROM INT_DIMENSION",
                new BeanPropertyRowMapper<Dimension>(Dimension.class));
    }

    public Dimension update(Dimension dimension) {
        jdbcTemplate.update("UPDATE INT_DIMENSION SET NAME = ?, IDDATATYPE = ? WHERE ID = ?",
                dimension.getName(), dimension.getIdDataType(), dimension.getId());
        return dimension;
    }

    public int delete(int id) {
        jdbcTemplate.update("DELETE FROM INT_DIMENSION WHERE ID = ?", id);
        return id;
    }

    public SimpleJdbcInsertOperations getSimpleJdbcInsert() {
        return new SimpleJdbcInsert(jdbcTemplate.getDataSource()).withTableName("INT_DIMENSION").usingGeneratedKeyColumns("ID");
    }
}
