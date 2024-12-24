package com.cradletechnologies.transportation.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cradletechnologies.transportation.dto.AccessTokenResponse;
import com.cradletechnologies.transportation.dto.CommonSyncResponse;
import com.cradletechnologies.transportation.dto.InternalB2CTransactionRequest;
import com.cradletechnologies.transportation.dto.InternalTransactionStatusRequest;
import com.cradletechnologies.transportation.dto.TransactionStatusSyncResponse;
import com.cradletechnologies.transportation.model.B2C_C2B_Entries;

public interface DarajaApiService {

	AccessTokenResponse getAccessToken();

	CommonSyncResponse performB2CTransaction(InternalB2CTransactionRequest internalB2CTransactionRequest);
	
	CommonSyncResponse checkAccountBalance();
	
	TransactionStatusSyncResponse getTransactionResult(InternalTransactionStatusRequest internalTransactionStatusRequest);

	Page<B2C_C2B_Entries> getPaymentsDataForDatatable(String queryString, Pageable pageRequest);
}
