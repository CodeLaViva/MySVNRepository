var myApp = angular.module("myApp", ["ngAnimate"]);

myApp.controller("sliderCtrl", function($scope) {
    $scope.show1 = false;
    $scope.show2 = false;
    $scope.show3 = false;
    $scope.show4 = false;
    $scope.show5 = false;
    $scope.show6 = false;
    $scope.images = [{
        src: "image/1.jpg "
    }, {
        src: "image/2.jpg "
    }, {
        src: "image/3.jpg "
    }, {
        src: "image/4.jpg "
    }];

});

/*myApp.directive("slider", function($timeout) {
    return {
        restrict: "EA",
        replace: true,
        scope: {
            images: "="
        },
        templateUrl: "slider.tpl.html",
        link: function(scope, element, attrs) {
            console.log(scope);
            console.log(element);
            console.log(attrs);
            scope.current = 0;
            scope.totalNumber = scope.images.length;
            scope.next = function() {
                if (scope.current < scope.totalNumber - 1) {
                    scope.current = scope.current + 1;
                } else {
                    scope.current = 0;
                }
            };
            scope.prev = function() {
                if (scope.current > 0) {
                    scope.current = scope.current - 1;
                } else {
                    scope.current = scope.totalNumber - 1;
                }
            };
            //
            var timer = null;
            var autoPlay = function() {
                timer = $timeout(function() {
                    scope.next();
                    //
                    timer = $timeout(autoPlay, 1000 * 3);
                }, 1000 * 3)
            };
            //autoPlay();
            if (attrs.auto == "true") {
                autoPlay();
            };
            //鼠标移上去停止播放
            element.on("mouseover", function() {
                $timeout.cancel(timer);
            });
            //鼠标移出继续播放
            element.on("mouseout", function() {
                autoPlay();
            });
            //
            scope.$on('$destroy', function() {
                $timeout.cancel(timer);
            });
        }
    }
});*/

var i = 0;

function next() {
    //获取元素
    var demoimg = document.getElementById("demoimg");
    var demoli = demoimg.getElementsByTagName("li");
    //获取图片盒子距左边的距离给left，图片的宽度给swidth，
    //图片盒子中li即图片总数给lis
    var left = demoimg.offsetLeft;
    var swidth = demoli[0].offsetWidth;
    var lis = demoli.length;
    //left从0开始逐渐递减，图片盒子向左移动。
    //当所有图片都移动到左边之后，left=0，重新开始，形成循环播放。
    if (left > -swidth * (lis - 1)) {
        left = left - swidth;
        demoimg.style.left = left + "px";
        i = i + 1;
    } else {
        left = 0;
        demoimg.style.left = left + "px";
        i = 0;
    }


    //附加效果 blue部分  
    var dblue = document.getElementById("blue");
    //通过参数i设置与图片li对应的blue部分第i个li背景色
    dblue.getElementsByTagName("li")[i].style.background = "blue";
    var thisi = dblue.getElementsByTagName("li")[i];
    var syi = dblue.getElementsByTagName("li");
    //遍历blue的所有li元素，设置非当前li的背景色，注意:syi[j]!=thisi
    for (j = 0; j < lis; j++) {
        if (syi[j] != thisi) {
            syi[j].style.background = "#ccc";
        }
    }
}

function last() {
    //获取元素
    var demoimg = document.getElementById("demoimg");
    var demoli = demoimg.getElementsByTagName("li");
    //获取图片盒子距左边的距离给left，图片的宽度给swidth，
    //图片盒子中li即图片总数给lis
    var left = demoimg.offsetLeft;
    var swidth = demoli[0].offsetWidth;
    var lis = demoli.length;
    //left从0开始逐渐递减，图片盒子向左移动。
    //当所有图片都移动到左边之后，left=0，重新开始，形成循环播放。

    if (left < 0) {
        left = left + swidth;
        demoimg.style.left = left + "px";
        i = i - 1;
    } else {
        left = -swidth * (lis - 1);
        demoimg.style.left = left + "px";
        i = 3;
    }


    //附加效果 blue部分  
    var dblue = document.getElementById("blue");
    //通过参数i设置与图片li对应的blue部分第i个li背景色
    dblue.getElementsByTagName("li")[i].style.background = "blue";
    var thisi = dblue.getElementsByTagName("li")[i];
    var syi = dblue.getElementsByTagName("li");
    //遍历blue的所有li元素，设置非当前li的背景色，注意:syi[j]!=thisi
    for (j = 0; j < lis; j++) {
        if (syi[j] != thisi) {
            syi[j].style.background = "#ccc";
        }
    }
}

//定时器，每隔2000毫秒执行一次 change()代码，数值越小，幻灯片切换越快
window.setInterval("next()", 5000);