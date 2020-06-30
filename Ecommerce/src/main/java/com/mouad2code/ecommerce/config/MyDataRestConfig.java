package com.mouad2code.ecommerce.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.hibernate.metamodel.model.domain.DomainType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.HttpMethods;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.mouad2code.ecommerce.entity.Product;
import com.mouad2code.ecommerce.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{
	
	private EntityManager entityManager;
	
	@Autowired
	public MyDataRestConfig(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	/*
	 * @Override public void
	 * configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
	 * 
	 * HttpMethod[] theUnsupporttedActions = {HttpMethod.PUT, HttpMethod.POST,
	 * HttpMethod.DELETE}; // disable HTTP methods for Product: PUT, POST and DELETE
	 * config.getExposureConfiguration() .forDomainType(Product.class)
	 * .withItemExposure((metdata, HttpMethods) ->
	 * HttpMethods.disable(theUnsupporttedActions)) .withCollectionExposure((metata,
	 * HttpMethods) -> HttpMethods.disable(theUnsupporttedActions));
	 * 
	 * 
	 * // disable HTTP methods for ProductCategory: PUT, POST and DELETE
	 * config.getExposureConfiguration() .forDomainType(ProductCategory.class)
	 * .withItemExposure((metdata, HttpMethods) ->
	 * HttpMethods.disable(theUnsupporttedActions)) .withCollectionExposure((metata,
	 * HttpMethods) -> HttpMethods.disable(theUnsupporttedActions));
	 * 
	 * // call an internal helper method exposeIds(config); }
	 */

	private void exposeIds(RepositoryRestConfiguration config) {
		
		// expose entity ids
		// - get a list of all entity classes from entity manager
		Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
		
		// - create an array of the entity types
		List<Class> entityClasses = new ArrayList<>();
		// - get the entity types for the entities
		for(EntityType tempEntityType : entities) {
			entityClasses.add(tempEntityType.getJavaType());
		}
		
		// - expose the entity ids for the array of entity/domain types
		Class[] domainType = entityClasses.toArray(new Class[0]);
		config.exposeIdsFor(domainType);
		
	}
	
}
