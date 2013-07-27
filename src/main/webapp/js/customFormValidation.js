var reg = /[0-9 -()+]+$/;
var passwordReg=/(?=.*\d)(?=.*[a-zA-Z])(?=.*[@#$%]).{6,20}/;
$(document).ready(function(){
	var usrNm=$('#userName');
	var usrNmErr=$('#userNmErrDesc');
	var pin=$('#numCheck');
	var pinErrReq=$('#pinReq');
	var password=$('#normalPassReq');
	var passwordErr=$('#normalPassReqErr');
	var confirmPassword=$('#confrimPassReq');
	var confirmPasswordErr=$('#confirmPassReqErr');
	$('#normalTxtReq1').blur('1',normalTxtBxReq);
	$('#normalTxtReq2').blur('2',normalTxtBxReq);
	$('#normalTxtReq3').blur('3',normalTxtBxReq);
	$('#normalTxtReq4').blur('4',normalTxtBxReq);
	usrNm.blur(usrNmReq);
	pin.blur(pinReq);
	$(password).on('blur',checkPassword);
	$(confirmPassword).on('blur',passwordMatching);
	$(password).on('keyup',passLengthCheck);
	usrNm.keyup(usrNmAvailCheck);
	pin.keyup(pinCheck);	
	function pinCheck(){
		numNLengthCheck(pin,pinErrReq,6,6);
	}
	function pinReq(){
		pinReqGen(pin,pinErrReq);
	}
	function usrNmAvailCheck(){
		usrNmAvailCheckGen(usrNm,usrNmErr);
	}
	function usrNmReq(){
		usrNmReqGen(usrNm,usrNmErr);
	}
	function passLengthCheck(){
		minMaxLengthCheck(password,passwordErr,6,20);
	}
	function checkPassword(){
		checkPasswordGen(password,passwordErr)
	}
	function passwordMatching(){
		passwordMatchingGen(password,confirmPassword,confirmPasswordErr);
	}
});
	
	function instCreateValidation(){
		var usrNm=$('#userName');
		var usrNmErr=$('#userNmErrDesc');
		var pin=$('#numCheck');
		var pinErrReq=$('#pinReq');
		var password=$('#normalPassReq');
		var passwordErr=$('#normalPassReqErr');
		var confirmPassword=$('#confrimPassReq');
		var confirmPasswordErr=$('#confirmPassReqErr');
		isValidate=true;
		for(i=1;i<=3;i++){
			normalTxtReq=$('#normalTxtReq'+i);
			normalTxtReqDesc=$('#normalTxtReqDes'+i);
			isValidate=txtReq(normalTxtReq,normalTxtReqDesc)?(isValidate?true:false):false;
		}
		for(i=1;i<=4;i++){
			val=$('#combobox'+i).val();
			if(val==null){
				$('#comboErr'+i).html('<img src="images/small_down_thumb.jpg"> Required field, please select a value');
				$('#comboErr'+i).css('color','#C62D2D');
				isValidate=false;
			}else if(val.length==0){
				$('#comboErr'+i).html('<img src="images/small_down_thumb.jpg"> Required field, please select one value');
				$('#comboErr'+i).css('color','#C62D2D');
				isValidate=false;
			}else{
				if($('#comboErr'+i).attr('style')!='undefined')
					$('#comboErr'+i).removeAttr('style');
				$('#comboErr'+i).html('<img src="images/small green ok.jpg">');
			}
		}
		isValidate=numNLengthCheck(pin,pinErrReq,6,6)?(isValidate?true:false):false;
		isValidate=pinReqGen(pin,pinErrReq)?(isValidate?true:false):false;
		isValidate=usrNmAvailCheckGen(usrNm,usrNmErr)?(isValidate?true:false):false;
		isValidate=usrNmReqGen(usrNm,usrNmErr)?(isValidate?true:false):false;
		isValidate=minMaxLengthCheck(password,passwordErr,6,20)?(isValidate?true:false):false;
		isValidate=checkPasswordGen(password,passwordErr)?(isValidate?true:false):false;
		isValidate=passwordMatchingGen(password,confirmPassword,confirmPasswordErr)?(isValidate?true:false):false;
		
		return isValidate;
	}

	var ret=false;
	function usrNmAvailCheckGen(usrNm,usrNmErr){
		
		$.ajax({
			type: "POST",
			url: "usrNmAvailCheck.action",
			data: 'usrNm='+usrNm.val(),
			cache: false,
			success: function(msg){
				if(msg.isAvailable){
					if(usrNm.attr('style')!='undefined')
						usrNm.removeAttr('style');
					usrNmErr.html('<img src="images/small_up _thumb.jpg"> Its Available');
					usrNmErr.css('color','#80DDE4');
					ret=true;
				}else{
					usrNm.css({'border-width':'5px','border-color':'#C62D2D'});
					usrNmErr.html('<img src="images/small_down_thumb.jpg">  Not Available');
					usrNmErr.css('color','#C62D2D');
					ret=false;
				}
			}
		});

		return ret;
	}
	
	function pinReqGen(pin,pinErrReq){
		if(pin.val().length>0){
			numNLengthCheck(pin,pinErrReq,6,6);
			if(pin.attr('style')!='undefined')
				pin.removeAttr('style');
			return true;
		}
		else{
			pinErrReq.text("--->   This field is required");
			pinErrReq.css('color','#C62D2D');
			pin.css({'border-width':'5px','border-color':'#C62D2D'});
			return false;
		}
	}
	function usrNmReqGen(usrNm,usrNmErr){
		if(usrNm.val().length>0){
			if(typeof(usrNm.attr('style'))!='undefined')
				usrNm.removeAttr('style');
			usrNmAvailCheckGen(usrNm,usrNmErr);
			return true;
		}
		else{
			usrNmErr.text("--->   This field is required");
			usrNmErr.css('color','#C62D2D');
			usrNm.css({'border-width':'5px','border-color':'#C62D2D'});
			return false;
		}
	}

	function checkPasswordGen(password,passwordErr){
		txtReq(password,passwordErr);
		if(password.val().length>0){
			if(password.val()!=null&&passwordReg.test(password.val())){
				passwordErr.html('<img src="images/small green ok.jpg">');
				if(passwordErr.attr('style')!='undefined')
					passwordErr.removeAttr('style');
				if(password.attr('style')!='undefined')
					password.removeAttr('style');
				return true;
			}else{
				password.css({'border-width':'5px','border-color':'#C62D2D'});
				passwordErr.html('<img src="images/small_down_thumb.jpg"> It must contain atleast one digit 0-9, <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;one special symbol, one alphabet <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;and min 6 to max 20 charcters');
				passwordErr.css('color','#C62D2D');
				return false;
			}
				
		}
	}
	
	function passwordMatchingGen(password,confirmPassword,confirmPasswordErr){
		if(password.val()==confirmPassword.val()){
			if(confirmPasswordErr.attr('style')!='undefined')
				confirmPasswordErr.removeAttr('style');
			if(confirmPassword.attr('style')!='undefined')
				confirmPassword.removeAttr('style');
			confirmPasswordErr.html('<img src="images/small green ok.jpg">');
			return true;
		}else{
			confirmPassword.css({'border-width':'5px','border-color':'#C62D2D'});
			confirmPasswordErr.html('<img src="images/small_red_cross.jpg"> Password didnot not match');
			confirmPasswordErr.css('color','#C62D2D');
			return false;
		}
	}
	
	function comboCheck(comboNo){
		if($('#combobox'+comboNo).val()!=null&&$('#combobox'+comboNo).val().trim().length>0){
			$('#comboErr'+comboNo).html('<img src="images/small green ok.jpg">');
			return true;
		}
		else{
			$('#comboErr'+comboNo).html('<img src="images/small_red_cross.jpg"> select a value here');
			return false;
		}
	}
	
	function numNLengthCheck(num,errNum,minlength,maxlength){
		var isNum=reg.test(num.val());
		if(isNum){
			return minMaxLengthCheck(num,errNum,minlength,maxlength);
			
		}else{
			errNum.html('<img src="images/small_down_thumb.jpg"> Only integers allowed');
			errNum.css('color','#C62D2D');
			return false;
		}
	}
	
	function minMaxLengthCheck(num,errNum,minlength,maxlength){
		numToGo=minlength-num.val().length;
		if(num.val().length==minlength&&minlength==maxlength){
			errNum.html('<img src="images/small green ok.jpg">');
			return true;
		}else if(num.val().length>maxlength){
			errNum.html('<img src="images/small_down_thumb.jpg"> It cannot be more than '+maxlength);
			errNum.css('color','#C62D2D');
			return false;
		}else{
			if(num.val().length>minlength&&num.val().length<=maxlength){
				maxToGo=maxlength-num.val().length;
				errNum.html('<img src="images/small_up _thumb.jpg"> you can insert '+maxToGo+' more');
				return true;
			}
			else{
				errNum.html('<img src="images/small_up _thumb.jpg">  type '+numToGo+' more digit');
				errNum.css('color','#80DDE4');
				return true;
			}
		}
	}
	
	function normalTxtBxReq(param){
		normalTxtReq=$('#normalTxtReq'+param.data);
		normalTxtReqDesc=$('#normalTxtReqDes'+param.data);
		txtReq(normalTxtReq,normalTxtReqDesc);
	}
	function txtReq(normalTxtReq,normalTxtReqDesc){
		if(normalTxtReq.val().trim().length<1){
			errorCls=normalTxtReq.parent('td').next('td').find(normalTxtReqDesc);
			errorCls.text("--->   This field is required");
			errorCls.css('color','#C62D2D');
			normalTxtReq.css({'border-width':'5px','border-color':'#C62D2D'});
			return false;
		}else{
			okCls=normalTxtReq.parent('td').next('td').find(normalTxtReqDesc);
			okCls.removeAttr("style");
			okCls.html('<img src="images/small green ok.jpg">');
			if(normalTxtReq.attr('style')!='undefined')
				normalTxtReq.removeAttr('style');
			return true;
		}
	}
	
