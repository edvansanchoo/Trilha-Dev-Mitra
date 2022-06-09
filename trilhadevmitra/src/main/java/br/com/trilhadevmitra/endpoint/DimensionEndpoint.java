package br.com.trilhadevmitra.endpoint;

import br.com.trilhadevmitra.model.Dimension;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dimension")
public class DimensionEndpoint {

    @GetMapping("/allDimension")
    public List<Dimension> getAllDimension(){
        List<Dimension> dimensions = null;
        return dimensions;
    }
}
