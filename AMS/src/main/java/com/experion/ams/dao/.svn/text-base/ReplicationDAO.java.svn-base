package com.experion.ams.dao;

import java.util.List;

import com.experion.ams.entity.Asset;

/**
 * 
 * @author Vishnu
 *
 */
public interface ReplicationDAO {

	/**
	 * This function is used to return all the asset number from Asset.
	 *  
	 * @return List<String>
	 */
	public List<Asset> getAllAssetDetails();

	/**
	 * Function to save the asset details to number of replication provided by the user.
	 * 
	 * @param assetNumber	Selected asset number of the asset to be replicated.	
	 * @param numberOfReplication		Asset to be replicated based on the provided number. 
	 * @return
	 */
	public Integer saveAssetReplication(String assetNumber,
			Integer numberOfReplication);
	/**
	 * Function to return the asset details of the selected asset.
	 * 
	 * @param assetNumber Asset number for the selected asset.
	 * @return	Returns an asset object.
	 */
	public Asset getSelectedAssetDetaills(String assetNumber);

	/**
	 * Function to return the asset details of the selected asset.
	 * 
	 * @param assetNumber Asset number for the selected asset.
	 * @return	Returns an asset object.
	 */
	public Asset getAssetDetailsToSave(String assetNumber);
}
