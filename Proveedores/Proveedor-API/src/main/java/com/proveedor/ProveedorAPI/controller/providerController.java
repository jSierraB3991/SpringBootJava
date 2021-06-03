package com.proveedor.ProveedorAPI.controller;

import com.proveedor.ProveedorAPI.models.Provider;
import com.proveedor.ProveedorAPI.models.Response;
import com.proveedor.ProveedorAPI.service.IProviderService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class providerController 
{
    @Autowired
    private IProviderService service;
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/see", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Provider> GetAllProviders()
    {
        return this.service.getAllProviders();
    
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Provider GetProvider(@PathVariable int id)
    {
        return this.service.getOneProvider(id);
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Provider> AddProveedor(@Valid @RequestBody Provider p)
    {
        try {
            Provider newp = this.service.addProvider(p);
            return new Response<>(newp, "Add Provider Successful!!");
        }
        catch(Exception ex){
            return new Response<>(ex.getMessage());
        }
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Provider> EditProveedor(@Valid @RequestBody Provider p)
    {
        try {
            Provider upp = this.service.editProvider(p);
            return new Response<>(upp, "Update Provider Successful!!");
        }
        catch(Exception ex){
            return new Response<>(ex.getMessage());
        }
    }
}
