let xhr=new XMLHttpRequest();//1准备ajax请求对象
let count = 0;
let pagination = 5;
let ulist=document.getElementById("ulist");
let trone=document.createElement("tr");
window.onload=function () {
    xhr.open("post","../user/tableall");
    openajax();
    xhr.send("count="+count+"&pagination="+pagination);
}

function query() {
    count=0;
    document.getElementById("ulist").innerHTML = "";
    console.log(count);
    console.log("第一");
    let querytext=document.getElementById("querytext").value;
    xhr.open("post","../user/page");
    openajax();
    xhr.send("querytext="+querytext+"&count="+count+"&pagination="+pagination);
}

function previouspage() {
    count=count-pagination;
    document.getElementById("ulist").innerHTML = "";
    let querytext=document.getElementById("querytext").value;
    if(querytext!=""){
        xhr.open("post","../user/pagepr");
        openajax();
        xhr.send("querytext="+querytext+"&count="+count+"&pagination="+pagination);
    }else{
        xhr.open("post","../user/tableall");
        openajax();
        xhr.send("count="+count+"&pagination="+pagination);
    }

}
function nextpage() {
    console.log(1);
    count=count+pagination;
    console.log(count);
    document.getElementById("ulist").innerHTML = "";
    let querytext=document.getElementById("querytext").value;
    if(querytext!=""){
        xhr.open("post","../user/nextp");
        openajax();
        xhr.send("querytext="+querytext+"&count="+count+"&pagination="+pagination);
    }else{
        xhr.open("post","../user/tableall");
        openajax();
        xhr.send("count="+count+"&pagination="+pagination);
    }

}
function openajax() {
    xhr.onreadystatechange=function () {
        if(xhr.readyState==4){//ajax请求已完成
            if(xhr.status==200){//服务器成功响应
                console.log(123);
                let result =JSON.parse(xhr.responseText); //获取服务器响应
                if(result.state ==1){
                    let users=result.data;
                    for (let i=0;i<users.length;i++){
                        let user=users[i];
                        console.log(user.name)
                        //将资料形成一行
                        trone=document.createElement("tr");
                        trone.setAttribute("name","ct");
                        trone.innerHTML="<td>"+user.id+"</td>\n" +
                            "                <td>"+user.name+"</td>\n" +
                            "                <td>"+user.password+"</td>\n" +
                            "                <td>"+user.phone+"</td>";
                        //把这行数据添加到表格的tbody中
                        ulist.appendChild(trone);

                    }
                }else{
                    alert(result.message);
                }
                // location.href='../page/user_login.html';
            }else{
                alert("服务异常")
            }
        }
    };
    //对请求url及请求参数进行编码
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");//设置请求头（只要是post请求都需要写请求头）
}