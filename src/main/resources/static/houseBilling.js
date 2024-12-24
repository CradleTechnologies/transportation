<html>
	<body>
		  <th:block layout:fragment="script">

					<script>										
						$(".input").on('input', function(){
						 		//alert("Hi Sankale"); 
							if(document.getElementById('currentMeterReadings').value==null)
							{
								var CMR = document.getElementById('currentMeterReadings').value = 0;
								current = parseFloat(CMR);
							}
							else{
								var CMR = document.getElementById('currentMeterReadings').value || 0;
								current = parseFloat(CMR);
							}		
							
								
							var PMR = document.getElementById('previousMeterReadings').value || 0;
							previous = parseFloat(PMR);
							
							var waterUnits = current - previous;		
							document.getElementById('waterUnitsUsed').value=waterUnits;
							
							var WR = document.getElementById('waterRates').value || 0;
							waterRates = parseFloat(WR);
							
							var waterBill = waterUnits * waterRates;
							document.getElementById('newWaterBill').value=waterBill;
							
							var RC = document.getElementById('newRentAmount').value || 0;
							rentalCharges = parseFloat(RC);
							var TC = document.getElementById('newTrashCharges').value || 0;
							trashCharges = parseFloat(TC);
							
							var totalNewBill = rentalCharges + waterBill + trashCharges;
							document.getElementById('totalNewBill').value=totalNewBill;
							
							var BBF = document.getElementById('balanceBf').value || 0;
							balanceBf = parseFloat(BBF);
							
							var totalAmount = totalNewBill + balanceBf;
							document.getElementById('totalAmount').value=totalAmount;
							
							if(document.getElementById('newWaterBill').value<0)
							{
								document.getElementById('newWaterBill').style.color = 'white';
								document.getElementById('newWaterBill').style.backgroundColor = 'red';								
							}
							else{
								document.getElementById('newWaterBill').style.color = 'white';
								document.getElementById('newWaterBill').style.backgroundColor = 'green';
							}	
								});								
					</script>
					
					<script>
					/*	function myFunction() {
						
						$(document).ready(function(){
						  $('#billingDate').attr("value", Date());
						});
						
						}
						*/
					</script>
					   
	     </th:block>
	</body>
</html>

					