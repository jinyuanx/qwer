function loading(btn){
    if($(btn).attr("class") == "btn btn-warning"){
        alert("请勿频繁点击！");
        return {isloading : true};
    }
    var h = $(btn).html();
    $(btn).attr("class", "btn btn-warning").html('<span class="glyphicon glyphicon-refresh glyphicon-refresh-animate"></span> 请稍后...');
    return {isloading : false, btn : btn, html : h};
}

function unloading(obj){
    $(obj.btn).attr("class", "btn btn-primary").html(obj.html);
}