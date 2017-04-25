package com.experion.ams.service;

import java.util.List;

import com.experion.ams.entity.Asset;

/**
 * 
 * @author Vishnu
 *
 */
public interface ReplicationService {

	/**
	 * Service class function to return all the asset number from Asset.
	 *  
	 * @return List<String>
	 */
	public List<Asset> getAllAssetDetails();

	/**
	 * Service class function to save the asset details to number of replication provided by the user.
	 * 
	 * @param assetNumber	Selected asset number of the asset to be replicated.	
	 * @param numberOfReplication		Asset to be replicated based on the provided number. 
	 * @return
	 */
	public Integer saveAssetReplication(String assetNumber,
			Integer numberOfReplication);
	/**
	 * Service class function to return the asset details of the selected asset.
	 * 
	 * @param assetNumber Asset number for the selected asset.
	 * @return Asset	Returns an asset object.
	 */
	public Asset getSelectedAssetDetaills(String assetNumber);

	/**
	 * Service class function to return the asset details of the selected asset.
	 * 
	 * @param assetNumber Asset number for the selected asset.
	 * @return Asset	Returns an asset object.
	 */
	public Asset getAssetDetailsToSave(String assetNumber);

}
