function page1() {
    $.ajax({
        url: "/user/page1",
        type: "get",
        success: function (res) {
            //动态改变周中间页面
            $('.middle').html(res);
        }
    })
}

function page2() {
    $.ajax({
        url: "/user/page2",
        type: "get",
        success: function (res) {
            //console.log(res);
            $('.middle').html(res);
        }
    })
}

function page3() {
    $.ajax({
        url: "/user/page3",
        type: "get",
        success: function (res) {
            $('.middle').html(res);
        }
    })
}

function page4() {
    $.ajax({
        url: "/user/page4",
        type: "get",
        success: function (res) {
            $('.middle').html(res);
        }
    })
}