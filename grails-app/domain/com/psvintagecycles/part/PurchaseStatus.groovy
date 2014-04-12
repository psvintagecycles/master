package com.psvintagecycles.part

class PurchaseStatus {

	public static final String SOLD = "sold"
	public static final String AVAILABLE = "avail"
	public static final String EBAY = "ebay"
	
    static constraints = {
		status(nullable:false, blank:false)
		code(nullable:false, blank:false)
    }
	
	static mapping = {
		table 'purchase_status'
		version true
		columns{
			id column:'id'
			status column:'status'
			code column:'code'
		}
	}
	
	String status
	String code
	
	String toString(){
		return status
	}
}
