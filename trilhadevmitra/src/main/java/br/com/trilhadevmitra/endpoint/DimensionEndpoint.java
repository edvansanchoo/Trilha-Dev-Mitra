package br.com.trilhadevmitra.endpoint;

import br.com.trilhadevmitra.DAO.DimensionDAO;
import br.com.trilhadevmitra.model.Dimension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dimension")
public class DimensionEndpoint {

    @Autowired
    private DimensionDAO dimensionDAO;

    @GetMapping()
    public List<Dimension> getAllDimension(){
        return dimensionDAO.getAllDimension();
    }

    @PostMapping()
    public ResponseEntity<Dimension> save(@RequestBody Dimension dimension){
        dimension.setId(dimensionDAO.getSimpleJdbcInsert().executeAndReturnKey(new BeanPropertySqlParameterSource(dimension)).intValue());
        return new ResponseEntity<Dimension>(dimension, HttpStatus.OK);

    }
    @PutMapping()
    public ResponseEntity<Dimension> update(@RequestBody Dimension dimension){
        return new ResponseEntity<Dimension>(dimensionDAO.update(dimension), HttpStatus.OK);

    }

    @DeleteMapping(path= "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return new ResponseEntity<>(dimensionDAO.delete(id), HttpStatus.OK);
    }
}
