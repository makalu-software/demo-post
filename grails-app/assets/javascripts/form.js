$(document).ready(function (){
    loadHrmSpecificForm();
    $(".selectHrm").change(function (){
        loadHrmSpecificForm();
    });
})


function loadHrmSpecificForm(){
    let selectedVal = $(".selectHrm").find(":selected").val();
    if(selectedVal == "ZOHO"){
        $('.replaceElement').load(serverBaseUrl+"zohoForm");
    }
    else if(selectedVal == "DARWINBOX"){
        $('.replaceElement').load(serverBaseUrl+"darwinboxForm");
    }
    else if(selectedVal == "KEKA"){
        $('.replaceElement').load(serverBaseUrl+"kekaForm");
    }
    else if(selectedVal == "ZENHR"){
        $('.replaceElement').load(serverBaseUrl+"zenhrForm");
    }else if(selectedVal == "BAMBOOHR"){
        $('.replaceElement').load(serverBaseUrl+"bamboohrForm");
    }else if(selectedVal == "ORACLE"){
        $('.replaceElement').load(serverBaseUrl+"oracleForm");
    }else{
        $('.replaceElement').empty();
    }
}