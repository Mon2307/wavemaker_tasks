

var display_input = document.getElementById("input");
var display_output=document.getElementById("output");
var inputstring="";
function Display(a){
    inputstring  +=a;
    display_input.value= inputstring;  
}

function calculate(){
    var a=  inputstring;
    var result= eval(a);
    display_output.value= result; 
}
let bracketStatus = false;

function Operator(a){
    if(a=='AC'){
      inputstring="";
    display_input.value= inputstring;  
    display_output.value= inputstring; 
    }
       
    else if(a=="()"){
            var p;
            if(!bracketStatus){
                p = "("
            } else {
                p = ")"
            };
            bracketStatus = !bracketStatus;
            inputstring+=p;
            display_input.value= inputstring;  
         

    }

    else if(a=="<"){
        {
			inputstring = inputstring.slice(0, -1);
			display_input.value= inputstring; 
		}
    }

    else if(a=="/"){

    }
}


function Operation(b){
    var n= inputstring.length;

    if(ValidateInput(b)){
        inputstring+=b;
        display_input.value= inputstring;
    }
    else{
        inputstring = inputstring.substring(0, n-1);
        inputstring += b;
        display_input.value = inputstring;

    }
}

function ValidateInput (value) {
	let last_input = inputstring.slice(-1);
	let operators = ["+", "-", "*", "/",".","%"];

	if (operators.includes(value) && operators.includes(last_input)) {
		return false;
	}

	if (operators.includes(value)) {
		if (operators.includes(last_input)) {
			return false;
		} else {
			return true;
		}
	}

	return true;
}





































































//     if(b=="+"){
//         if(operators.includes(inputstring.charAt(n-1))){
//             // console.log(inputstring.charAt(n-1),inputstring[n-1]);
//             // var h=inputstring[n-1];
//             // inputstring.replace(h,b);
//             // display_input.value= inputstring; 
//             return;
//         }
//         else{
//             inputstring  +=b;
//             display_input.value= inputstring;  
//         }
        
//     }
//    else if(b=="-"){
//         if(operators.includes(inputstring.charAt(n-1))){
//             // console.log(inputstring.charAt(n-1),inputstring[n-1]);
//             // var h=inputstring[n-1];
//             // inputstring.replace(h,b);
//             // display_input.value= inputstring; 
//             return;
//         }
//         else{
//             inputstring  +=b;
//             display_input.value= inputstring;  
//         }
        
//     }

//    else if(b=="*"){
        
//         if(operators.includes(inputstring.charAt(n-1))){
//             // console.log(inputstring.charAt(n-1),inputstring[n-1]);
//             // var h=inputstring[n-1];
//             // inputstring.replace(h,b);
//             // display_input.value= inputstring; 
//             return;
//         }
//         else{
//             inputstring  +=b;
//             display_input.value= inputstring;  
//         }
        
//     }

//     else if(b=="."){
//         if(operators.includes(inputstring.charAt(n-1))){
//             // console.log(inputstring.charAt(n-1),inputstring[n-1]);
//             // var h=inputstring[n-1];
//             // inputstring.replace(h,b);
//             // display_input.value= inputstring; 
//            return;
//         }
//         else{
//             inputstring  +=b;
//             display_input.value= inputstring;  
//         }
        
//     }

//     else if(b=="%"){
//         if(operators.includes(inputstring.charAt(n-1))){
//             // console.log(inputstring.charAt(n-1),inputstring[n-1]);
//             // var h=inputstring[n-1];
//             // inputstring.replace(h,b);
//             // display_input.value= inputstring; 
//             return;
//         }
//         else{
//             var c=inputstring.charAt(n-1);
//             var k= c/100;
//             display_input.value= inputstring;  
//         }
        
//     }

//     else if(b=="/"){
//         if(operators.includes(inputstring.charAt(n-1))){
//             //console.log(inputstring.charAt(n-1),inputstring[n-1]);
//             //var h=inputstring[n-1];
//             //inputstring.replace(h,b);
//             //display_input.value= inputstring; 
//             return;
//         }
//         else{
//             inputstring +=b;
//             display_input.value= inputstring;  
//         }
        
//     }


