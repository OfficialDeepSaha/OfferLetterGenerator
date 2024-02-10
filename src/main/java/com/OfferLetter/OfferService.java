package com.OfferLetter;

public interface OfferService {
	
	public OfferLetter saveEnrollment(OfferLetter offerLetter);
	
	public void sendOfferLetter(String name , String to) throws Exception;

	

}
