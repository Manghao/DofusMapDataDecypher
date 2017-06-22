package com.dofus.coder;

/**
 * Dechiffrer les mapData des cartes de jeu de Dofus 1.29
 * mapData = mapData du fichier MapId_0---------X.swf
 * @author Manghao
 * @version 1.0
 */
public class Map {

	private int id;
	private String key, mapData;
	
	public Map(int id, String key, String mapData) {
		this.id = id;
		this.key = key;
		this.mapData = mapData;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getMapData() {
		return this.mapData;
	}

	public void setMapData(String mapData) {
		this.mapData = mapData;
	}
	
}
