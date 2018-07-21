//管理员登录
    function login() {
        //获取username的值
        var username = $("#username").val();
        //获取passowrd的值
        var password = $("#password").val();
        //封装成json格式
        // var data = '{"username":"' + username + '","password":"' + password + '"}';

        // $.ajax({
        //
        //     url: "http://127.0.0.1:8080/manager/login",
        //     type: "post",
        //     data: data,
        //     contentType: 'application/json',
        //     success: returnJson,
        //     async: true,
        //     error: error,
        // });
        //
        // //成功访问
        // function returnJson(data) {
        //
        //     alert("登录成功")
        //     window.location.href = "./index";
        //
        // }
        // //访问失败
        // function error(data) {
        //     console.log(data);
        // }
            if(username=="admin"&&password=="admin"){
                alert("登陆成功")
                window,location.href="./index";
            }else {
                alert("账号或密码有误请重新登陆")
            }
    }


//增加证书
function add_certificate(add_certificateName,add_certificateGrade) {
    var table="#table_certificate";
    var data = '{"name":"' + add_certificateName +'", "grade":"'+add_certificateGrade+'"}';
    $.ajax({
        data: data,
        type: "POST",
        // url: "http://127.0.0.1:8080/certificate/add",
        url: "http://127.0.0.1:8080/certificate",
        contentType: 'application/json',
        dataType: "json",

        success: function(data) {
            reloadTable(table);
            alert(data.msg);
        },
        error: function(data) {
            alert(data.msg);

        }
        // ,
        // headers: {
        //     "username": "admin",
        //     "password": "admin"
        // }
    });
}


//删除证书
function del_certificate(del_id) {
    var table="#table_certificate";
    $.ajax({

        type: "POST",
        // url: "http://127.0.0.1:8080/certificate/delete/" + id,
        url: "http://127.0.0.1:8080/certificate/"+del_id,
        contentType: 'application/json',
        dataType: "json",


        success: function(data) {
            reloadTable(table);
            alert(data.msg);

        },
        error: function(data) {
            alert(data.msg);


        }
        // ,
        // headers: {
        //     "username": "admin",
        //     "password": "admin"
        // }
    });
}

//更改证书
function edit_certificate(edit_id, edit_certificateName,edit_certificateGrade) {
    var table="#table_certificate";
    var data = '{"cerId":"' + edit_id + '","name":"' + edit_certificateName +'","grade":"'+ edit_certificateGrade+'"}';
    alert(data);
    $.ajax({

        data: data,
        type: "POST",
        // url: "http://127.0.0.1:8080/certificate/update",
        url: "http://127.0.0.1:8080/certificate",
        contentType: 'application/json',
        dataType: "json",

        success: function(data) {
            reloadTable(table);
            alert(data.msg);
        },
        error: function(data) {
            alert(data.msg);

        }
    });
}



//重载数据
function reloadTable(table) {
    $(table).DataTable().ajax.reload();
}


function test() {
    alert(11111);
}

