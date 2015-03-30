package com.niedson.votebook.model.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niedson.votebook.persistence.dao.BookDAO;
import com.niedson.votebook.persistence.entity.Book;

@Service
public class BookService {
	
	private static final Logger logger = LoggerFactory.getLogger(BookService.class);
	
	private BookDAO bookDAO;
	
	@Autowired
	public BookService(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	public Book save(Book book){
		Book savedBook  = bookDAO.save(book);
		return savedBook;
	}
	
	public List<Book> listAll(){
		return bookDAO.listAll();
	}
	
	public Book get(Long id) {
		return bookDAO.get(id);
	}
	
	
//	
//	public void addLocationToMap(String mapName, String locationA, String locationB, Integer cost){
//		logger.debug("params: [mapName:{},locationA:{},locationB:{},cost:{}]", mapName, locationA, locationB, cost);
//		
//		locationA = locationA.trim().toUpperCase();
//		locationB = locationB.trim().toUpperCase();
//		
//		Maps maps = mapsDAO.findByNameIgnoreCase(mapName);
//		if(maps == null){
//			maps = new Maps( mapName.trim() );
//			mapsDAO.insert(maps);
//		}
//		
//		List<String> listNames = new ArrayList<String>();
//		listNames.add( locationA );
//		listNames.add( locationB );
//		
//		List<MapLocation> listMapLocations = mapLocationDAO.findByMapsIdAndLocationInList(maps.getId(), listNames);
//		if( listMapLocations.isEmpty() ){
//			MapLocation mapLocationA = new MapLocation( locationA, maps.getId() );
//			mapLocationDAO.insert(mapLocationA);
//			listMapLocations.add(mapLocationA);
//			
//			MapLocation mapLocationB = new MapLocation( locationB, maps.getId() );
//			mapLocationDAO.insert(mapLocationB);
//			listMapLocations.add(mapLocationB);
//		} else if( listMapLocations.size() == 1 ){
//			boolean existLocationA = false;
//			for (MapLocation mapLocation: listMapLocations) {
//				if(mapLocation.getLocation().equals(locationA)){
//					existLocationA = true;
//				}
//			}
//			
//			if(existLocationA == false){
//				MapLocation mapLocationA = new MapLocation( locationA, maps.getId() );
//				mapLocationDAO.insert(mapLocationA);
//				listMapLocations.add(mapLocationA);
//			} else {
//				MapLocation mapLocationB = new MapLocation( locationB, maps.getId() );
//				mapLocationDAO.insert(mapLocationB);
//				listMapLocations.add(mapLocationB);
//			}
//		}
//		
//		for (MapLocation mapLocation : listMapLocations) {
//			if(mapLocation.getLocation().equals(locationA)){
//				mapLocation.addEdge(locationB, cost);
//			} else if(mapLocation.getLocation().equals(locationB)){
//				mapLocation.addEdge(locationA, cost);
//			}
//			mapLocationDAO.update(mapLocation);
//		}
//	}
//	
//	public MinorPathTO calculateMinorPath(String mapName, String locationBegin, String locationEnd, Integer fuelAutonomy, Double fuelCost) throws DeliveryException{
//		logger.debug("params: [mapName:{},locationBegin:{},locationB:{},fuelAutonomy:{},fuelCost:{}]", mapName, locationBegin, locationEnd, fuelAutonomy, fuelCost);
//		
//		Maps maps = mapsDAO.findByNameIgnoreCase(mapName);
//		if(maps == null){
//			logger.info("mapName '{}' not found", mapName);
//			throw new DeliveryException("Not found mapName.");
//		}
//		
//		ResultMinorPathAlgorithm resultMinorPathAlgorithm = new MinorPathAlgorithm(mapLocationDAO).calculate(maps.getId(), locationBegin, locationEnd);
//		
//		MinorPathTO minorPathTO = new MinorPathTO(resultMinorPathAlgorithm);
//		minorPathTO.setFuelAutonomy(fuelAutonomy);
//		minorPathTO.setFuelCost(fuelCost);
//		minorPathTO.setMapName(mapName);
//		
//		return minorPathTO;
//	}
}
