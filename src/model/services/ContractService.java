package model.services;

import java.util.ArrayList;

import model.entities.Contract;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;
	
	
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}



	public void processContract(Contract contract, int months) {
		double basicQuota = contract.getTotalValue() / months;
		for (int i = 0; i < months; i++) {
			double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota, i);
			updatedQuota += onlinePaymentService.paymentFee(updatedQuota);
		}
	}

}
