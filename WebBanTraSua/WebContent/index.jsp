<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.TaiKhoan"%>
<%TaiKhoan tk = (TaiKhoan)session.getAttribute("user"); %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Trà Sửa TooCha</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="khachhang/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="khachhang/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="khachhang/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="khachhang/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="khachhang/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="khachhang/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="khachhang/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="khachhang/css/style.css" type="text/css">
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Humberger Begin -->
    <div class="humberger__menu__overlay"></div>
    <div class="humberger__menu__wrapper">
        <div class="humberger__menu__logo">
            <a href="#"><img src="khachhang/img/logo.png" alt=""></a>
        </div>
        <div class="humberger__menu__cart">
            <ul>
                <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
            </ul>
            <div class="header__cart__price">item: <span>15000đ</span></div>
        </div>
        <div class="humberger__menu__widget">
            <div class="header__top__right__auth">
                <a href="#"><i class="fa fa-user"></i> Login</a>
            </div>
        </div>
        <nav class="humberger__menu__nav mobile-menu">
            <ul>
                <li class="active"><a href="index.jsp">Trang chủ</a></li>
                <li><a href="#">Sản phẩm</a></li>
                <li><a href="#">About us</a>
                </li>
                <li><a href="#">Blog</a></li>
            </ul>
        </nav>
        <div id="mobile-menu-wrap"></div>
        <div class="header__top__right__social">
            <a href="#"><i class="fa fa-facebook"></i></a>
            <a href="#"><i class="fa fa-instagram"></i></a>
        </div>
        <div class="humberger__menu__contact">
            <ul>
                <li><i class="fa fa-envelope"></i> hello@email.com</li>
                <li>Khuyến mãi đến 50% cho tất cả sản phẩm vào mùa hè</li>
            </ul>
        </div>
    </div>
    <!-- Humberger End -->

    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__left">
                            <ul>
                                <li><i class="fa fa-envelope"></i> hello@email.com</li>
                                <li>Khuyến mãi đến 50% cho tất cả sản phẩm vào mùa hè</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="header__top__right">
                            <div class="header__top__right__social">
                                <a href="https://www.facebook.com"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-instagram"></i></a>
                            </div>
                            <div class="header__top__right__auth">
                            	<!-- Xử lý đăng nhập-->
                                <a href="khachhang/info.html"><%if(tk!=null){ out.print(tk.getTendangnhap());}%></a>
               					<a href="login.jsp" style="float: left"><% if(tk==null){ out.print("Đăng nhập ");}%></a>
               					<!-- <a style="float: left; margin-left: 2px"> <span> | </span> </a> -->
               					<a href="register.jsp" style="float: left; padding-left: 2px"><% if(tk==null){ out.print(" Đăng ký");}%></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="header__logo">
                        <a href="#"><img src="khachhang/img/ts/logo.jpg" alt="" width="102" height="35"></a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
                            <li class="active"><a href="index.jsp" style="font-family: Arial, serif" >Trang chủ</a></li>
                            <li><a href="#" style="font-family: Arial, sans-serif" >Sản phẩm</a></li>
                            <li><a href="#" style="font-family: Arial, sans-serif" >About us</a>
                            </li>
                            <li><a href="#" style="font-family: Arial, serif" >Blog</a></li>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                    <div class="header__cart">
                        <ul>
                            <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                            <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
                        </ul>
                        <div class="header__cart__price">item: <span>15000đ</span></div>
                    </div>
                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->

    <!-- Hero Section Begin -->
    <section class="hero">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="hero__search">
                        <div class="hero__search__form">
                            <form action="#">
                                <input type="text" placeholder="Trà sữa trân châu">
                                <button type="submit" class="site-btn">Tìm kiếm</button>
                            </form>
                        </div>
                        <div class="hero__search__phone">
                            <div class="hero__search__phone__icon">
                                <i class="fa fa-phone"></i>
                            </div>
                            <div class="hero__search__phone__text">
                                <h5>+84 999 9999</h5>
                                <span>Hỗ trợ 24/7</span>
                            </div>
                        </div>
                    </div>
                    <div class="hero__item set-bg" data-setbg="khachhang/img/ts/bg.jpg">
                        <div class="hero__text">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Footer Section Begin -->
    <footer class="footer spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="footer__about">
                        <div class="footer__about__logo">
                            <a href="#"><img src="khachhang/img/ts/logo.jpg" alt="" width="102" height="35"></a>
                        </div>
                        <ul>
                            <li>Địa chỉ: Đại học Nông Lâm, TP.HCM</li>
                            <li>Phone: +65 11.188.888</li>
                            <li>Email: milktea@toocha.com</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                    <div class="footer__widget">
                        <h6>Liên hệ với chúng tôi</h6>
                        <ul>
                            <li><a href="#">Thông tin</a></li>
                            <li><a href="#">Chính sách</a></li>
                        </ul>
                        <ul>
                            <li><a href="#">Dịch vụ</a></li>
                            <li><a href="#">Liên lạc</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-12">
                    <div class="footer__widget">
                        <h6>Tham gia nhận bản tin</h6>
                        <p>Nhận email về các món mới và các ưu đãi.</p>
                        <form action="#">
                            <input type="text" placeholder="Hãy để lại email">
                            <button type="submit" class="site-btn">Đăng kí</button>
                        </form>
                        <div class="footer__widget__social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="footer__copyright">
                        <div class="footer__copyright__text"><p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;2020 | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="#" target="_blank">K-team</a>
  						</p></div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="khachhang/js/jquery-3.3.1.min.js"></script>
    <script src="khachhang/js/bootstrap.min.js"></script>
    <script src="khachhang/js/jquery.nice-select.min.js"></script>
    <script src="khachhang/js/jquery-ui.min.js"></script>
    <script src="khachhang/js/jquery.slicknav.js"></script>
    <script src="khachhang/js/mixitup.min.js"></script>
    <script src="khachhang/js/owl.carousel.min.js"></script>
    <script src="khachhang/js/main.js"></script>



</body>

</html>