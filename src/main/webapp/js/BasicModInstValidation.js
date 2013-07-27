var reg = /[0-9 -()+]+$/;
var floatReg=/^[-+]?[0-9]*\.?[0-9]+$/;
var passwordReg=/(?=.*\d)(?=.*[a-zA-Z])(?=.*[@#$%]).{6,20}/;
$(document).ready(function(){
//	var usrNm=$('#userName');
//	var usrNmErr=$('#userNmErrDesc');
//	var pin=$('#numCheck');
//	var pinErrReq=$('#pinReq');
//	var password=$('#normalPassReq');
//	var passwordErr=$('#normalPassReqErr');
//	var confirmPassword=$('#confrimPassReq');
//	var confirmPasswordErr=$('#confirmPassReqErr');
	$(document).on('blur','#normalTxtReq1','1',normalTxtBxReq);
	$(document).on('blur','#normalTxtReq2','2',normalTxtBxReq);
	$(document).on('blur','#normalTxtReq3','3',normalTxtBxReq);
	$(document).on('blur','#percentReq1','#percentReqErr1',anyTxtBxReq);
	$(document).on('blur','#percentReq2','#percentReqErr2',anyTxtBxReq);
//	$(document).on('blur','#percentReq3','#percentReqErr3',anyTxtBxReq);
	$(document).on('blur','#datepickerReq1','#datepickerReqErr1',anyTxtBxReq);
	$(document).on('blur','#totalMarks','#totalMarksErr',anyTxtBxReq);
	$(document).on('blur','.normalTextBoxReq',specialTxtBoxReq);
	$(document).on('click','.normalTextBoxReqErr',peepholeClick);
	$(document).on('blur','#mobileReq1','1',specialMobReq);
	$(document).on('blur','#mobileReq2','2',specialMobReq);
	$(document).on('blur','#emailReq1','1',specialEmailReq);
	$(document).on('click','.mobNoErr',mobileNoClick);
	$(document).on('click','#emailReqErr1',emailReqMsg);
	$(document).on('click','#emailReqErr2',emailReqMsg);
	$(document).on('blur','#specialDatepicker1','1',specialDateReq);
	$(document).on('click','#specialDatepickerErr1',peepholeClick);
	$(document).on('click','#crsBtchErr1',crsBtchClick);
	$(document).on('click','#crsBtchErr2',crsBtchClick);
//	$('#normalTxtReq1').blur('1',normalTxtBxReq);
//	$('#normalTxtReq2').blur('2',normalTxtBxReq);
//	$('#normalTxtReq3').blur('3',normalTxtBxReq);
//	$('#normalTxtReq4').blur('4',normalTxtBxReq);
//	usrNm.blur(usrNmReq);
//	pin.blur(pinReq);
//	$(password).on('blur',checkPassword);
//	$(confirmPassword).on('blur',passwordMatching);
//	$(password).on('keyup',passLengthCheck);
//	usrNm.keyup(usrNmAvailCheck);
//	pin.keyup(pinCheck);	
	function numOfStdCheck(){
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


	function validateSwitch(validatorName){
		var result=false;
		$("form").submit(function () { return false; });
		switch(validatorName){
		case 'subCreate':
			result=subCreateValidation();
			break;
		case 'courseCreate':
			result=courseCreateValidation();
			break;
		case 'exmTypeCreate':
			result=exmTypeCreateValidation();
			break;
		case 'examCreate':
			result=examCreateValidation();
			break;
		case 'batchCreate':
			result=batchCreateValidation();
			break;
		case 'stdCreate':
			result=admissionReq();
			break;
		case 'instSessCreate':
			result=true;
			break;
		case 'gradCreate':
			result=true;
			break;
		case 'lateFee':
			result=true;
			break;
		case 'totalFee':
			result=true;
			break;
		case 'installmentsCreate':
			result=true;
			break;
		case 'scholarShip':
			result=true;
			break;
		case 'otherAccessories':
			result=true;
			break;
		default:
			alert('default calls');
			break;
		}
		return result;
	}
	function batchCreateValidation(){
		res1=txtReq($('#normalTxtReq1'),$('#normalTxtReqDes1'));
		res2=txtReq($('#normalTxtReq2'),$('#normalTxtReqDes2'));
		if(res2==true){
			res2=numNLengthCheck($('#normalTxtReq2'),$('#normalTxtReqDes2'),1,100000);
		}
		res3=comboCheck(1);
		if(res1==true&&res2==true&&res3==true)
			return true;
		else
			return false;
		
	}
	function examCreateValidation(){
		res1=txtReq($('#normalTxtReq1'),$('#normalTxtReqDes1'));
		res2=txtReq($('#normalTxtReq2'),$('#normalTxtReqDes2'));
		res4=txtReq($('#percentReq1'),$('#percentReqErr1'));
		if(res4==true)
			res4==percentValidator($('#percentReq1'),$('#percentReqErr1'));
		res5=txtReq($('#percentReq2'),$('#percentReqErr2'));
		if(res5==true)
			res5=percentValidator($('#percentReq2'),$('#percentReqErr2'));
//		res6=txtReq($('#percentReq3'),$('#percentReqErr3'));
//		if(res6==true)
//			res6=percentValidator($('#percentReq3'),$('#percentReqErr3'));
		res7=txtReq($('#datepickerReq1'),$('#datepickerReqErr1'));
		res8=txtReq($('#totalMarks'),$('#totalMarksErr'));
		if(res8==true)
			res8=percentValidator($('#totalMarks'),$('#totalMarksErr'));
		for(i=1;i<=3;i++){
			comboCheck(i);
		}
		if(res1==true&&res2==true&&res4==true&&res5==true&&res7==true&&res8==true)
			return true;
		else
			return false;
		
	}
	function exmTypeCreateValidation(){
		var percentR=$('#percentReq');
		var percentRErr=$('#percentReqErr');
		res1=txtReq($('#normalTxtReq1'),$('#normalTxtReqDes1'));
		res2=txtReq($('#percentReq'),$('#percentReqErr'));
//		res3=numNLengthCheck(percentR,percentRErr,1,6);
		res3=floatNumCheck(percentR,percentRErr,1,6,false);
		isValidate=true;
		 if(res3==true){
			if((floatReg.test(percentR.val())==true&&percentR.val()>100.00)){
				percentRErr.html('<img src="images/small_down_thumb.jpg"> It cannot be more than 100');
				percentRErr.css('color','#C62D2D');
				isValidate=false;
			}else{
				percentRErr.html('<img src="images/small green ok.jpg">');
				percentRErr.removeAttr('style');
			}
		 }
		var value=$("#mulSelCombo").val();
		if(typeof(value)==='undefined'||value==null){
			$('#mulSelErr').html('<img src="images/small_down_thumb.jpg"> Required field, please select a values');
			$('#mulSelErr').css('color','#C62D2D');
			isValidate=false;
		}else{
			$('#mulSelErr').html('<img src="images/small green ok.jpg">');
			$('#mulSelErr').removeAttr('style');
		}
		if(res1==true&&res2==true&&res3==true&&isValidate==true)
			return true;
		else
			return false;
		
	}
	function subCreateValidation(){
		res1=txtReq($('#normalTxtReq1'),$('#normalTxtReqDes1'));
		res2=txtReq($('#normalTxtReq2'),$('#normalTxtReqDes2'));
		
		if(res1==true&&res2==true)
			return true;
		else
			return false;
	}
	function courseCreateValidation(){
		res1=txtReq($('#normalTxtReq1'),$('#normalTxtReqDes1'));
		res2=txtReq($('#normalTxtReq2'),$('#normalTxtReqDes2'));
		res3=numNLengthCheck($('#normalTxtReq2'),$('#normalTxtReqDes2'),0,100000);
		val=$('#combobox1').val();
		isValidate=true;
		if(val==null){
			$('#comboErr1').html('<img src="images/small_down_thumb.jpg"> Required field, please select a value');
			$('#comboErr1').css('color','#C62D2D');
			isValidate=false;
		}else{
			$('#comboErr1').removeAttr('style');
			$('#comboErr1').html('<img src="images/small green ok.jpg">');
		}
		for(i=1;i<=2;i++){
			var value=$("#mulSelCombo"+i).val();
			if(typeof(value)==='undefined'||value==null){
				$('#mulSelComboDes'+i).html('<img src="images/small_down_thumb.jpg"> Required field, please select a values');
				$('#mulSelComboDes'+i).css('color','#C62D2D');
				isValidate=false;
			}else{
				$('#mulSelComboDes'+i).html('<img src="images/small green ok.jpg">');
				$('#mulSelComboDes'+i).removeAttr('style');
			}
		}
		if(res1==true&&res2==true&&res3==true&&isValidate==true)
			return true;
		else
			return false;
	}
	
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
	function percentValidator(percentR,percentRErr){
				if((floatReg.test(percentR.val())==true&&percentR.val()>100.00)){
					percentRErr.html('<img src="images/small_down_thumb.jpg"> It cannot be more than 100');
					percentRErr.css('color','#C62D2D');
					return false;
				}else{
					percentRErr.html('<img src="images/small green ok.jpg">');
					percentRErr.removeAttr('style');
					return true;
				}
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
		if(isNum==true){
			return minMaxLengthCheck(num,errNum,minlength,maxlength);
			
		}else{
			errNum.html('<img src="images/small_down_thumb.jpg"> Only integers allowed');
			errNum.css('color','#C62D2D');
			return false;
		}
	}
	function floatNumCheck(num,errNum,minlength,maxlength,isOnlyFloat){
		var isFloat=floatReg.test(num.val());
		if(isOnlyFloat==true){
			if(isFloat==true){
				return minMaxLengthCheck(num,errNum,minlength,maxlength);
			}else{
				errNum.html('<img src="images/small_down_thumb.jpg"> Only Floats allowed');
				errNum.css('color','#C62D2D');
				return false;
			}
		}else{
			if(isFloat==true){
				return minMaxLengthCheck(num,errNum,minlength,maxlength);
			}else if(numNLengthCheck(num,errNum,minlength,maxlength)==true){
				return true;
			}else{
				errNum.html('<img src="images/small_down_thumb.jpg"> Only Number or Floats allowed');
				errNum.css('color','#C62D2D');
				return false;
			}
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
		return txtReq(normalTxtReq,normalTxtReqDesc);
	}
	function anyTxtBxReq(errSpan){
		return txtReq($(this),$(errSpan.data));
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
	var email_check = /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,6}$/i;
	function admissionReq(){
		isValidate=true;
		for(i=0;i<=8;i++){
			if($('.normalTextBoxReq').eq(i).val().trim().length<1){
				$('.normalTextBoxReq').eq(i).css({'border-width':'5px','border-color':'#C62D2D'});
				$('.normalTextBoxReqErr').eq(i).html('<img src="images/peephole.jpg">');
				isValidate=false;
			}else{
				$('.normalTextBoxReq').eq(i).removeAttr('style');
			}
		}
		for(i=1;i<=2;i++){
			res=specialMobileReq(i);
			if(res==false)
				isValidate=false;
		}
		if($('#emailReq1').val().length>0){
			res=email_check.test($('#emailReq1').val());
			if(res==false){
				isValidate=false;
				$('#emailReq1').css({'border-width':'5px','border-color':'#C62D2D'});
				$('#emailReqErr1').html('<img src="images/peephole.jpg">');
			}else{
				$('#emailReq1').removeAttr('style');
				$('#emailReqErr1').html('');
			}
		}else{
			$('#emailReq1').css({'border-width':'5px','border-color':'#C62D2D'});
			$('#emailReqErr1').html('<img src="images/peephole.jpg">');
		}
		if($('#emailReq2').val().length>0){
			res=email_check.test($('#emailReq2').val());
			if(res==false){
				isValidate=false;
				$('#emailReq2').css({'border-width':'5px','border-color':'#C62D2D'});
				$('#emailReqErr2').html('<img src="images/peephole.jpg">');
			}else{
				$('#emailReq2').removeAttr('style');
				$('#emailReqErr2').html('');
			}
		}else{
			$('#emailReq2').removeAttr('style');
			$('#emailReqErr2').html('');
		}
		dateval=$('#specialDatepicker1').val();
		if(dateval.length>0){
			$('#specialDatepicker1').removeAttr('style');
			$('#specialDatepickerErr1').html('');
		}else{
			$('#specialDatepicker1').css({'border-width':'5px','border-color':'#C62D2D'});
			$('#specialDatepickerErr1').html('<img src="images/peephole.jpg">');
			isValidate=false;
		}
		for(i=1;i<=2;i++){
			
			if($('#crsBtch'+i).val()>-1){
				$('#crsBtchErr'+i).html('');
			}else{
				$('#crsBtchErr'+i).html('<img src="images/peephole.jpg">');
				isValidate=false;
			}
		}
		return isValidate;
	}
	function specialTxtBoxReq(){
		indexId=$('.normalTextBoxReq').index($(this));
		if($('.normalTextBoxReq').eq(indexId).val().length<1){
			$('.normalTextBoxReq').eq(indexId).css({'border-width':'5px','border-color':'#C62D2D'});
			$('.normalTextBoxReqErr').eq(indexId).html('<img src="images/peephole.jpg">');
		}else{
			$('.normalTextBoxReq').eq(indexId).removeAttr('style');
			$('.normalTextBoxReqErr').eq(indexId).html('');
		}	
	}
	function specialDateReq(param){
		dateval=$('#specialDatepicker'+param.data).val();
		if(dateval.length>0){
			$('#specialDatepicker'+param.data).removeAttr('style');
			$('#specialDatepickerErr'+param.data).html('');
			return true;
		}else{
			$('#specialDatepicker'+param.data).css({'border-width':'5px','border-color':'#C62D2D'});
			$('#specialDatepickerErr'+param.data).html('<img src="images/peephole.jpg">');
			return false;
		}
	}
	function crsBtchClick(){
		alert("Required field, plese select a value");
	}
	function peepholeClick(){
		alert("This is a required box, please type a value");
	}
	function mobileNoClick(){
		alert("It must be a 10 digit number.");
	}
	function emailReqMsg(){
		alert("Email must contain @ and domain TLD. e.g. ryan@rengoni.com")
	}
	function specialEmailReq(param){
		if($('#emailReq'+param.data).val().length>0){
			res=email_check.test($('#emailReq'+param.data).val());
			if(res==false){
				isValidate=false;
				$('#emailReq'+param.data).css({'border-width':'5px','border-color':'#C62D2D'});
				$('#emailReqErr'+param.data).html('<img src="images/peephole.jpg">');
			}else{
				$('#emailReq'+param.data).removeAttr('style');
				$('#emailReqErr'+param.data).html('');
			}
		}else{
			$('#emailReq'+param.data).css({'border-width':'5px','border-color':'#C62D2D'});
			$('#emailReqErr'+param.data).html('<img src="images/peephole.jpg">');
		}
	}
	function specialMobReq(param){
		specialMobileReq(param.data);
	}
	function specialMobileReq(data){
		mobReq=$('#mobileReq'+data);
		err=$('#mobileReqErr'+data);
		if(mobReq.val().trim().length>0){
			isNum=reg.test(mobReq.val());
			minlength=10;
			maxlength=10;
			if(isNum==true){
				if(mobReq.val().length==minlength&&minlength==maxlength){
					mobReq.removeAttr('style');
					err.html('');
					return true;
				}else if(num.val().length>maxlength){
					mobReq.css({'border-width':'5px','border-color':'#C62D2D'});
					err.html('<img src="images/peephole.jpg">');
					return false;
				}
			}else{
				mobReq.css({'border-width':'5px','border-color':'#C62D2D'});
				err.html('<img src="images/peephole.jpg">');
				return false;
			}
		}else{
			mobReq.css({'border-width':'5px','border-color':'#C62D2D'});
			err.html('<img src="images/peephole.jpg">');
			return false;
		}
	}
