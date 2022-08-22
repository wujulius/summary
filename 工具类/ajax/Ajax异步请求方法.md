
# js封装代码：

~~~~ js

/获取异步请求对象
       function getXmlHttp() {
            //1.获取核心对象
            var xmlhttp;
            if (window.XMLHttpRequest)
            {// code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp=new XMLHttpRequest();
            }
            else
            {// code for IE6, IE5
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            return xmlhttp;
        }
//自定义jQuery全局的插件: 封装异步请求方法,使用json作为参数
//1.提供一个方法: 异步请求方法,参数就是一个json
function  aj(jsonParam){// var jsonParam = { type:"get",path:服务器路径,param: 用户提交的参数}
    //1.得到异步请求对象
    var xh = getXmlHttp();
    //2.判断请求方式
    var method = jsonParam.type;
    var url = jsonParam.path;
    var param = jsonParam.param;
    if(method.toLowerCase()=="get"){//method: Get, GET, get
        xh.open(method,url+"?"+param,true);
        xh.send(null);
    }else if(method.toLowerCase()=="post"){
        xh.open(method,url,true);
        //作用: 提交的数据时key=value
        xh.setRequestHeader("content-type","application/x-www-form-urlencoded");
        xh.send(param);
    }
    //3.建立连接
    //4.接收服务器响应的数据
    xh.onreadystatechange = function () {
        if(xh.readyState==4 && xh.status==200){
            var value = xh.responseText;//接收请求参数
            //处理的方式:打印到控制台
            console.log("异步请求响应的数据:  "+ value);
            
        }
        
    }
}
//2.定义插件:
$.extend({
    "ajk":aj
})

~~~~