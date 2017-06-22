package com.dofus.coder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Dechiffrer les mapData des cartes de jeu de Dofus 1.29
 * mapData = mapData du fichier MapId_0---------X.swf
 * @author Manghao
 * @version 1.0
 */
public class MapDataDecypher {
	
	public static String decypherMapData(Map map) {
		String preparedKey = prepareKey(map.getKey());
		String akey = null;
		try {
			akey = URLDecoder.decode(preparedKey, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String mapData = decypherData(map.getMapData(), akey, checksum(akey));
		return mapData;
	}
	
	private static String prepareKey(String key) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < key.length(); i = (i + 2)) {
			sb.append((char)Integer.parseInt(key.substring(i, (i + 2)), 16));
		}
		return sb.toString();
	}
	
	private static String checksum(String akey) {
		String HEX_CHARS[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
		int index = 0;
		for (int i = 0; i < akey.length(); i++) {
			index = index + (((int) akey.charAt(i)) % 16);
		}
		return HEX_CHARS[index % 16];
	}
	
	private static String decypherData(String mapData, String akey, String checksum) {		
		StringBuilder sb = new StringBuilder();
		int c = (Integer.parseInt(checksum, 16) * 2);
		int akeyLength = akey.length();
		int j = 0;
		for (int i = 0; i < mapData.length(); i = (i + 2)) {
			sb.append(Character.toString((char) (Integer.parseInt(mapData.substring(i, i + 2), 16) ^ (int)akey.charAt((j++ + c) % akeyLength))));
		}
		return sb.toString();
	}
}
