package com.example.tenancy.config.multitenat.database;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;

@Component
public class TenantDataSource implements Serializable 
{
	private static final long serialVersionUID = 1L;

	private HashMap<String, DataSource> dataSources = new HashMap<>();
	
	@Autowired
	private DataSourceConfigRepository configRepo;
	
	@PostConstruct
    public Map<String, DataSource> getAll() 
	{
        List<DataSourceConfig> configList = configRepo.findAll();
        Map<String, DataSource> result = new HashMap<>();
        for (DataSourceConfig config : configList) {
            DataSource dataSource = getDataSource(config.getName());
            result.put(config.getName(), dataSource);
        }
        return result;
    }

	public DataSource getDataSource(String name) 
	{
        if (Optional.ofNullable(dataSources.get(name)).isPresent()) {
            return dataSources.get(name);
        }
        DataSource dataSource = createDataSource(name);
        if (Optional.ofNullable(dataSource).isPresent()) {
            dataSources.put(name, dataSource);
        }
        return dataSource;
    }
	
	private javax.sql.DataSource createDataSource(String name) 
	{
        DataSourceConfig config = configRepo.findByName(name);
        if (Optional.ofNullable(config).isPresent()) 
        {
            return DataSourceBuilder
                    .create().driverClassName(config.getDriverClassName())
                    .username(config.getUsername())
                    .password(config.getPassword())
                    .url(config.getUrl()).build();
        }
        return null;
    }   
}
