package br.com.trilhadevmitra.endpoint;

import br.com.trilhadevmitra.DAO.DimensionDAO;
import br.com.trilhadevmitra.model.Dimension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dimension")
public class DimensionEndpoint {

    @Autowired
    private DimensionDAO dimensionDAO;

    @GetMapping("/allDimension")
    public List<Dimension> getAllDimension(){
        return dimensionDAO.getAllDimension();
    }
}
