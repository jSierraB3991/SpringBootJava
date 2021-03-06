package com.example.tenancy.config.multitenat.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import static com.example.tenancy.constant.MultiTenantConstants.DEFAULT_TENANT_ID;;

@Component
public class DataSourceBasedMultiTenantConnectionProviderImpl 
					extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl
{
	private static final long serialVersionUID = 1L;
	
	@Autowired private DataSource defaultDS;
	@Autowired private ApplicationContext context;

    private Map<String, DataSource> map = new HashMap<String, DataSource>();
    boolean init = false;
    
    @PostConstruct
    public void load() {
        map.put(DEFAULT_TENANT_ID, defaultDS);
    }
    
    @Override
    protected DataSource selectAnyDataSource() {
        return map.get(DEFAULT_TENANT_ID);
    }
    
    @Override
    protected DataSource selectDataSource(String tenantIdentifier) {
        if (!init) {
            init = true;
            TenantDataSource tenantDataSource = context.getBean(TenantDataSource.class);
            map.putAll(tenantDataSource.getAll());
        }
        return Optional.ofNullable(map.get(tenantIdentifier)).isPresent() 
        		? map.get(tenantIdentifier) 
        		: map.get(DEFAULT_TENANT_ID);
    }
}
