document.addEventListener('DOMContentLoaded', function () {
    $(function () {
        "use strict";
        $(".close-switcher").on("click", function () {
            $(".switcher-wrapper").removeClass("switcher-toggled")
        }), new PerfectScrollbar(".header-notifications-list"), $(".mobile-search-icon").on("click", function () {
            $(".search-bar").addClass("full-search-bar")
        }), $(".toggle-icon").click(function () {
            $(".wrapper").hasClass("toggled") ? ($(".wrapper").removeClass("toggled"), $(".sidebar-wrapper").unbind("hover")) : ($(".wrapper").addClass("toggled"), $(".sidebar-wrapper").hover(function () {
                $(".wrapper").addClass("sidebar-hovered")
            }, function () {
                $(".wrapper").removeClass("sidebar-hovered")
            }))
        }), $(document).ready(function () {
            $(".sidebar-wrapper").hover(function () {
                $(".wrapper").addClass("sidebar-hovered")
            }, function () {
                $(".wrapper").removeClass("sidebar-hovered")
            })

            $(window).on("scroll", function () {
                $(this).scrollTop() > 300 ? $(".back-to-top").fadeIn() : $(".back-to-top").fadeOut()
            }), $(".back-to-top").on("click", function () {
                return $("html, body").animate({
                    scrollTop: 0
                }, 600), !1
            })
        }),

            $(function () {
                for (var e = window.location, o = $(".metismenu li a").filter(function () {
                    return this.href === e
                }).addClass("").parent().addClass("mm-active"); o.is("li");) o = o.parent("").addClass("mm-show").parent("").addClass("mm-active")
            }), $(function () {
            $("#menu").metisMenu()
        }), $(".switcher-btn").on("click", function () {
            $(".switcher-wrapper").toggleClass("switcher-toggled")
        })

//замена фона
        $('#theme1').click(theme1);
        $('#theme2').click(theme2);
        $('#theme3').click(theme3);
        $('#theme4').click(theme4);
        $('#theme5').click(theme5);
        $('#theme6').click(theme6);
        $('#theme7').click(theme7);
        $('#theme8').click(theme8);
        $('#theme9').click(theme9);
        $('#theme10').click(theme10);
        $('#theme11').click(theme11);
        $('#theme12').click(theme12);
        $('#theme13').click(theme13);
        $('#theme14').click(theme14);
        $('#theme15').click(theme15);

        function theme1() {
            $('body').attr('class', 'bg-theme bg-theme1');
        }

        function theme2() {
            $('body').attr('class', 'bg-theme bg-theme2');
        }

        function theme3() {
            $('body').attr('class', 'bg-theme bg-theme3');
        }

        function theme4() {
            $('body').attr('class', 'bg-theme bg-theme4');
        }

        function theme5() {
            $('body').attr('class', 'bg-theme bg-theme5');
        }

        function theme6() {
            $('body').attr('class', 'bg-theme bg-theme6');
        }

        function theme7() {
            $('body').attr('class', 'bg-theme bg-theme7');
        }

        function theme8() {
            $('body').attr('class', 'bg-theme bg-theme8');
        }

        function theme9() {
            $('body').attr('class', 'bg-theme bg-theme9');
        }

        function theme10() {
            $('body').attr('class', 'bg-theme bg-theme10');
        }

        function theme11() {
            $('body').attr('class', 'bg-theme bg-theme11');
        }

        function theme12() {
            $('body').attr('class', 'bg-theme bg-theme12');
        }

        function theme13() {
            $('body').attr('class', 'bg-theme bg-theme13');
        }

        function theme14() {
            $('body').attr('class', 'bg-theme bg-theme14');
        }

        function theme15() {
            $('body').attr('class', 'bg-theme bg-theme15');
        }
    });
});
