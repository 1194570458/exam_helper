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



/**
 * 证书管理
 *
 */

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

/**
 * 章节管理
 *
 */

//增加章节
function add_property(add_propertyName,add_time) {
    var table="#table_property";
    var data = '{"chapter":"' + add_propertyName +'", "time":"'+add_time+'"}';
    $.ajax({
        data: data,
        type: "POST",
        url: "http://127.0.0.1:8080/property",
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


//删除章节
function del_property(del_id) {
    var table="#table_property";
    $.ajax({

        type: "POST",
        // url: "http://127.0.0.1:8080/certificate/delete/" + id,
        url: "http://127.0.0.1:8080/property/"+del_id,
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


//更改章节
function edit_property(edit_id, edit_propertyName,edit_time) {
    var table="#table_property";
    var data = '{"proId":"' + edit_id + '","chapter":"' + edit_propertyName +'","time":"'+ edit_time+'"}';
    $.ajax({

        data: data,
        type: "POST",
        // url: "http://127.0.0.1:8080/certificate/update",
        url: "http://127.0.0.1:8080/property",
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
/**
 * 论文题管理
 *
 */
//增加题目
function add_thesis(add_thesisTitle,add_thesisContent,add_thesisproId,add_thesiscerId) {
    var table="#table_thesis";
    var data = '{"title":"' + add_thesisTitle +'", "content":"'+add_thesisContent+'","proId":"'+add_thesisproId+'","cerId":"'+add_thesiscerId+'"}';
    $.ajax({
        data: data,
        type: "POST",

        url: "http://127.0.0.1:8080/thesis",
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

//删除题目
function del_thesis(del_id) {
    var table="#table_thesis";
    $.ajax({

        type: "POST",

        url: "http://127.0.0.1:8080/thesis/"+del_id,
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
function edit_thesis(edit_id, edit_thesisTitle,edit_thesisContent,edit_thesisproId,edit_thesiscerId) {
    var table="#table_thesis";
    var data = '{"thesisId":"' + edit_id +'", "title":"'+edit_thesisTitle+'","content":"'+edit_thesisContent+'","proId":"'+edit_thesisproId+'","cerId":"'+edit_thesiscerId+'"}';
    alert(data);
    $.ajax({

        data: data,
        type: "POST",
        url: "http://127.0.0.1:8080/thesis",
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










/**
 *其它功能
 *
 */


//重载数据
function reloadTable(table) {
    $(table).DataTable().ajax.reload();
}

//获取当前时间
function  getDate() {
    Date.prototype.format = function(format) {
        var date = {
            "M+": this.getMonth() + 1,
            "d+": this.getDate(),
            "h+": this.getHours(),
            "m+": this.getMinutes(),
            "s+": this.getSeconds(),
            "q+": Math.floor((this.getMonth() + 3) / 3),
            "S+": this.getMilliseconds()
        };
        if (/(y+)/i.test(format)) {
            format = format.replace(RegExp.$1, (this.getFullYear() + '').substr(4 - RegExp.$1.length));
        }
        for (var k in date) {
            if (new RegExp("(" + k + ")").test(format)) {
                format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? date[k] : ("00" + date[k]).substr(("" + date[k]).length));
            }
        }
        return format;
    }
    // var date = new Date().format('yyyy-MM-ddThh:mm:ss');
    var date = new Date().format('yyyy-MM-dd');
    return date;

}




function test() {
    alert(11111);
}

