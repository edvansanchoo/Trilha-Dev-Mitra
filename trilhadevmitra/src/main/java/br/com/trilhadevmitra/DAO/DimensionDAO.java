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
}
