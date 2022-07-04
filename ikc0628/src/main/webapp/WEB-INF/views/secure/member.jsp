<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>IKcare | 線上營養師</title>
    <meta name="referrer" content="no-referrer-when-downgrade">
    <meta name="description" property="og:description" itemprop="description" content="紀錄飲食，線上營養諮詢。" />
    <meta property="og:locale" content="zh_TW" />
    <meta property="og:title" itemprop="name" content="IKcare | 線上營養師" />
    <meta property="og:url" itemprop="url" content="#" />
    <meta property="og:image" itemprop="image" content="../img/logo2.png" />
    <meta property="og:type" content="website" />
    <meta property="og:site_name" content="ikcare" />

    <link rel="canonical" href="#" />
    <!-- <link href="https://static.tpx.tw/sff/mouggan/css/main.css?v=20220518v1" rel="stylesheet"> -->
    <link href="../css/style.css" rel="stylesheet">
    <link href="https://static.tpx.tw/sff/mouggan/css/rwd-content.css?v=20220518v1" rel="stylesheet">

    <!-- <script>
        window.Email = '';
    </script> -->



</head>

<body id="page-shop" class="style-lang-en">
    
    <style>
        .mycategory:hover{
            color:#876d5a; 
            line-height: 24px;
        }
        .mycategory{
            line-height: 24px;
            font-weight: bold;
        }
       .nav:hover{
        color:#876d5a; 
        text-decoration: lemonchiffon wavy underline;
       }
       #mysubtitle{
        font-weight: bold;
       }
       #mysubtitle:hover{
        color:#876d5a; 
       }
    
    </style>

    <!-- header -->
    <header class="header" id="one">
        <div class="container-fluid align-items-center justify-content-center position-relative">
            <div class="header-inner">
                <div class="logo">
                    <a href="/ec_p1_main.html"><img class="img-fluid" style="width:150px ;" src="../img/logo2.png" alt=""></a>
                </div>

                <!-- icon-s-logo小logo -->
                <div class="navbar-nav">
                    <ul class="d-md-inline-block d-none align-top">
                        <li class="nav-item s-logo ml-0">
                            <a href="/en-us/"><i class="icon-s-logo"></i></a>
                        </li>
                    </ul>

                    <!-- header右邊 -->
                    <ul class="main-list member-nav">
                        <li class="nav-item search-item" style="width: auto;">
                            <a class="btn-global-search global-search d-md-inline-block d-none" href="">
                                <i class="icon-search hide-search"></i>
                            </a>
                            <a class="btn-global-search-mobile hide-search global-search d-inline-block d-md-none"
                                href="">
                                <i class="icon-search"></i>
                            </a>
                            <span class="close-global-search-m">
                                <a class="close-global-search" href="">
                                    <i class="icon-close"></i>
                                </a>
                            </span>
                            <form class="search-form align-bottom" id="form-global-search" action="">
                                <i class="icon-search2"></i>
                                <input class="input-global-search form-control border-0 d-inline-block mx-2"
                                    id="search-input" type="text" placeholder="SEARCH" style="font-size: 18px;">
                                <a class="close-global-search" href="">
                                    <i class="icon-close"></i>
                                </a>
                            </form>

                        </li>
                        <!-- <li class="nav-item d-md-inline-block d-none hide-search">
                            <a href="/ec_p3_login.html">
                                <div class="text-en" style="margin-left: -18px;">Login</div>
                                <i class="icon-member"></i>
                            </a>
                        </li> -->

                        <!-- 右上會員 -->
                        <li class="nav-item hide-search">
                            <a href="#">
                                <div class="text-en" style="margin-left: -28px;">Member</div><i class="icon-member"></i>
                            </a>
                            <div class="sub-list-block down-left sub-member-list" style="left: -50px;">
                                <!-- 登入前版本 -->
                                <c:if test="${empty membersbean}">
									<ol class="sub-list p-4" style="height: 110px;">
										<li class="my-3">
											<div style="padding: 10px 30px">
												<a class="btn btn-outline-primary w-100"
													style="font-size: 16px;"
													href="<c:url value="/secure/ec_p3_login" />" title="登入">登入</a>
											</div>
										</li>
									</ol>
								</c:if>
								<!-- 登入後版本 -->
								<c:if test="${not empty membersbean}">
									<ol class="sub-list p-4" style="height: 180px;">
										<li><a class="menu-collapse with-plus collapsed"
											href="/ec_p9_member.html" title="會員中心"
											style="text-align: center; font-size: 16px;">會員中心</a></li>
										<li><a class="menu-collapse with-plus collapsed"
											href="/ec_p10_history.html" title="訂單查詢"
											style="text-align: center; font-size: 16px;">訂單查詢</a></li>
										<li class="my-3">
											<div style="padding: 10px 30px">
												<a class="btn btn-outline-primary w-100"
													style="font-size: 16px;"
													href="<c:url value="/en-us/logout" />" title="登出">登出</a>
											</div>
										</li>
									</ol>
								</c:if>
                            </div>
                        </li>

                        <!-- 購物車邊欄 -->

                        <li class="nav-item hide-search" id="app-mini-cart">
                            <a class="open-sidebar" href="#" data-sidebar="#cart-menu" data-mask="#cart-mask"
                                ref="cartdot" :class="{'show': count !== 0 &amp;&amp; dataisload}">
                                <div class="text-en" style="margin-left: -15px;">Cart</div><i class="icon-cart"></i>
                                <!-- <span v-text=" count "></span> -->
                                <span>1</span>
                                <!-- 範例demo -->
                            </a>
                            <div class="sidebar h5" id="cart-menu">
                                <div class="inner-block p-5">
                                    <a class="close-sidebar float-right" data-sidebar="#cart-menu"
                                        data-mask="#cart-mask" data-btn="" href="#"><i class="icon-close"
                                            style="width: 18px; height: 18px;"></i></a>
                                    <div class="clearfix"></div>
                                    <div class="shopping-cart-list my-5">
                                        <ul>
                                            <!-- 無商品版 -->
                                            <!-- <li class="text-left mb-3" v-if="count !== 0 &amp;&amp; dataisload"
                                                v-for="(item, index) in datas" :index="index"
                                                :key="item.CustomMarketID">
                                                <a class="row m-0" :href="item.Url">
                                                    <div class="col-4 cart-img p-0 pr-4">
                                                        <div class="inner-wrap item-img-box">
                                                            <new-image :url="item.Cover" :size="'_w120_h160'"
                                                                :name="item.Name"></new-image>
                                                        </div>
                                                    </div>
                                                    <div class="col-8 p-0">
                                                        <div class="item-name d-block text-truncate mb-4"
                                                            :href="item.Url">{{item.Name}}</div>
                                                        <div><span>尺寸 </span><span
                                                                class="item-size">{{item.Size}}</span></div>
                                                        <div><span>顏色 </span><span
                                                                class="item-color">{{item.ColorName}}</span></div>
                                                        <div><span>數量 </span><span>{{item.Count}}</span></div>
                                                    </div>
                                                </a>
                                            </li> -->

                                            <!-- demo版 -->
                                            <li index="0" class="text-left mb-3"><a href="/ec_p2_product.html"
                                                    class="row m-0">
                                                    <div class="col-4 cart-img p-0 pr-4">
                                                        <div class="inner-wrap" style="position: absolute; top: 10px;">
                                                            <img
                                                                src="https://cloudinary.images-iherb.com/image/upload/f_auto,q_auto:eco/images/cgn/cgn00932/l/102.jpg"
                                                                alt="" class="img-fluid"></div>
                                                    </div>
                                                    <div class="col-8 p-0">
                                                        <div href="/ec_p2_product.html" 
                                                            class="item-name d-block text-truncate mb-4">
                                                            <span style="font-size: 14px; white-space:normal;">
                                                                California Gold Nutrition, 金 C 粉，維生素 C，1,000 毫克，240 粒素食膠囊</span> 
                                                        </div>
                                                        <div><span>尺寸 </span><span class="item-size">F</span></div>
                                                        <div><span>數量 </span><span>1</span></div>
                                                    </div>
                                                </a>
                                            </li>

                                        </ul>
                                    </div>
                                    <a class="btn-go-cart btn btn-outline-primary btn-lg w-100"
                                        href="/ec_p7_cart.html" style="font-size: 14px;"></a>
                                </div>
                            </div>

                        </li>
                        <li class="nav-item d-md-none d-inline-block hide-search">
                            <a class="open-sidebar btn-burger" href="#" data-sidebar="#burger-menu"
                                data-mask="#burger-mask">
                                <span></span>
                            </a>
                        </li>
                    </ul>



                    <!-- header欄位 -->
                    <ul class="main-list d-md-inline-block d-none hide-search">
                        <li class="nav-item nav-change">
                            <a class="nav" href="/ec_p1_main.html"
                                style="font-weight: bold; font-size: 18px; font-family: 'Courier New', Courier, monospace;">最新</a>
                        </li>
                        <li class="nav-item nav-change">
                            <a class="nav" href="/ec_p1_main.html"
                                style="font-weight: bold; font-size: 18px; font-family: 'Courier New', Courier, monospace;">熱賣商品</a>
                        </li>
                        <li class="nav-item nav-change">
                            <a class="nav" href="/ec_p1_main.html"
                                style="font-weight: bold; font-size: 18px; font-family: 'Courier New', Courier, monospace;">全部商品</a>
                            <div class="sub-list-block down-left">
                                <ol class="sub-list"
                                    style="font-size: 18px; font-family: 'Courier New', Courier, monospace; width: 180px; height:335px;">
                                    <li>
                                        <a id="mysubtitle" href="#">消化健康</a>
                                    </li>
                                    <li>
                                        <a id="mysubtitle" href="#">能量精力</a>
                                    </li>
                                    <li>
                                        <a id="mysubtitle" href="#">眼與視覺健康</a>
                                    </li>
                                    <li>
                                        <a id="mysubtitle" href="#">免疫健康</a>
                                    </li>
                                    <li>
                                        <a id="mysubtitle" href="#">健康睡眠</a>
                                    </li>
                                    <li>
                                        <a id="mysubtitle" href="#">減重塑形</a>
                                    </li>
                                    <li>
                                        <a id="mysubtitle" href="#">骨與關節健康</a>
                                    </li>
                                </ol>
                            </div>
                        </li>
                        <li class="nav-item nav-change">
                            <a class="nav" href="/"
                                style="font-weight: bold; font-size: 18px; font-family: 'Courier New', Courier, monospace;">線上營養師</a>
                        </li>
                    </ul>

                </div>
            </div>
        </div>
    </header>

    <!-- RWD網頁縮小後的選單 -->

    <div class="sidebar h4" id="burger-menu">
        <div class="inner-block p-5">
            <ul class="accordion" id="accordionMobileMenu" style="font-size: 18px;">
                <li class="mb-4"><a href="/ec_p1_main.html">最新</a></li>
               

                <!-- 縮小後的邊欄event -->
                <li class="mb-4">
                    <a class="menu-collapse with-plus collapsed" href="#" data-toggle="collapse"
                        data-target="#collapse0" aria-expanded="true">優惠活動</a>
                    <div class="collapse menu-collapse-block" id="collapse0" data-parent="#accordionMobileMenu">
                        <ol class="p-4">
                            <li class="py-2">
                                <a href="#"> 歡慶開幕 單件免運</a>
                            </li>

                        </ol>
                    </div>
                </li>

                <!-- 縮小後的邊欄category -->
                <li class="mb-4">
                    <a class="menu-collapse with-plus collapsed" href="/ec_p1_main.html" data-toggle="collapse"
                        data-target="#collapse1" aria-expanded="true">商品分類</a>
                    <div class="collapse menu-collapse-block" id="collapse1" data-parent="#accordionMobileMenu">
                        <ol class="p-4">
                            <li class="py-2">
                                <a href="/ec_p1_main.html">全部商品</a>
                            </li>
                            <li class="py-2">
                                <a href="#">消化健康</a>
                            </li>
                            <li class="py-2">
                                <a href="#">能量精力</a>
                            </li>
                            <li class="py-2">
                                <a href="#">眼與視覺健康</a>
                            </li>
                            <li class="py-2">
                                <a href="#">免疫健康</a>
                            </li>
                            <li class="py-2">
                                <a href="#">健康睡眠</a>
                            </li>
                            <li class="py-2">
                                <a href="#">減重塑形</a>
                            </li>
                            <li class="py-2">
                                <a href="#">骨與關節健康</a>
                            </li>
                        </ol>
                    </div>
                </li>

                <li class="mb-4"><a href="/mainpage.html">線上營養師</a></li>

            </ul>

            <!-- 縮小後的邊欄 會員功能 -->
            <ul class="member-menu w-75" style="font-size: 18px;">
                <!-- 登入前版本 -->
                <!-- <li class="mb-4"><a class="menu-collapse with-plus collapsed" href="/ec_p3_login.html">會員中心</a></li>
                <li class="mb-4"><a class="menu-collapse with-plus collapsed" href="/ec_p3_login.html">訂單查詢</a></li>
                <li class="mb-4"><a class="btn btn-outline-primary btn-lg btn-block" href="/ec_p3_login.html"
                        style="font-size: 18px;">登入</a></li> -->
                <!-- 登入後版本 -->
                <li class="mb-4"><a class="menu-collapse with-plus collapsed" href="/ec_p9_member.html">會員中心</a></li>
                <li class="mb-4"><a class="menu-collapse with-plus collapsed" href="/ec_p10_history.html">訂單查詢</a></li>
                <li class="mb-4"><a class="btn btn-outline-primary btn-lg btn-block" href="/ec_p1_main.html"
                        style="font-size: 18px;">登出</a></li>
            </ul>
        </div>
    </div>

    <!-- 搜尋功能 -->
    <div class="mask close-sidebar" id="burger-mask" data-sidebar="#burger-menu" data-mask="#burger-mask"
        data-btn=".open-sidebar"></div>
    <div class="mobile-search-block" id="search-popup">
        <div class="container-fluid">
            <form class="search-form mt-3" action=""><input class="input-global-search form-control with-search mb-3"
                    id="search-input-m" type="text" placeholder="請輸入關鍵字" style="font-size: 18px;">
                <button class="btn btn-primary btn-block btn-lg" id="btn-global-search-m"
                    style="font-size: 18px; width:300px ;">搜尋</button>
            </form>
        </div>
    </div>


    <!-- 中間頁面 -->

    <div id="main-wrap">
        <div class="container-fluid">
            <div class="content-block content-md">
                <div class="row">
                    <div class="col-12 col-md-12">

                        <div class="block-widge">
                            <div class="block-title" style="font-size: 18px;">
                                <span style="font-family:'Courier New', Courier, monospace;">會員帳號: </span>
                                ${membersbean.useraccount}</div>
                            <div id="app-address" class="user-info-block">
                                <form id="form-modify" action="/en-us/user/account" method="POST" class="form-style"
                                    novalidate="novalidate" >
                                    <input name="__RequestVerificationToken" type="hidden"
                                        value="tX75x-JsR_THSLTAIYu8hmqqQ_ovFLacYKpmhr37saES_ADXmyp5dPL-j3GvWiPzVm3syFP_pBZC05aEwu9qhPBBExlwzhWK4klAA2x3EMc1">
                                    <div class="row">
                                        <div class="col">
                                            <div class="form-g mb-5"><input type="text" name="name" value="${membersbean.membername}"
                                                    placeholder="姓名" required="required"
                                                    style="font-size: 18px;"
                                                    class="floatLabel form-control">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row" >
                                        <div class="col">
                                            <!-- <div class="form-g"><input type="text" placeholder="YYYY-MM-DD"
                                                    name="birthday" data-value="" readonly="" disabled="disabled"
                                                    class="date-picker-birth form-control bg-white">
                                            </div> -->
                                            <div class="form-g mb-5"><input type="date" name="birhtday" value="${membersbean.birthday}"
                                                    placeholder="YYYY-MM-DD" required="required"
                                                    class="floatLabel form-control" style="font-size: 18px;">
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="form-g mb-5"><select name="Gender" class="form-control custom-ui"
                                                style="font-size: 18px; font-family:'Courier New', Courier, monospace;">
                                                    <option value="男" <c:if test="${membersbean.gender eq'男'}">selected</c:if>>男</option>
                                                    <option value="女" <c:if test="${membersbean.gender eq'女'}">selected</c:if>>女</option>
                                                </select></div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col">
                                            <div class="form-g">
                                                <div class="form-g">
                                                    <input class="form-control" type="text" placeholder="身高" name="" value="${height}"
                                                        required style="font-size: 18px;">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="form-g">
                                                <div class="form-g">
                                                    <input class="form-control" type="text" placeholder="體重" name="" value="${weight}"
                                                        required style="font-size: 18px;">
                                                </div>
                                            </div>
                                        </div>
                                    </div>



                                    <div class="row">
                                        <div class="col">
                                            <div class="form-g mb-5"><input id="tel" type="tel" name="mobile"
                                                    placeholder="電話號碼" required="required" value="${membersbean.cellphone}"
                                                    class="form-control" 
                                                    style="font-size: 18px; "></div>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="row with-small-gap">
                                            <div class="col">
                                                <div class="form-g mb-5"><select name="city" aria-invalid="false" placeholder=""
                                                        class="form-control custom-ui" 
                                                        style="font-size: 18px;">
                                                        <option value="臺北市" <c:if test="${membersbean.area eq'臺北市'}">selected</c:if>>臺北市</option>
                                                        <option value="基隆市" <c:if test="${membersbean.area eq'基隆市'}">selected</c:if>>基隆市</option>
                                                        <option value="新北市" <c:if test="${membersbean.area eq'新北市'}">selected</c:if>>新北市</option>
                                                        <option value="宜蘭縣" <c:if test="${membersbean.area eq'宜蘭縣'}">selected</c:if>>宜蘭縣</option>
                                                        <option value="新竹市" <c:if test="${membersbean.area eq'新竹市'}">selected</c:if>>新竹市</option>
                                                        <option value="新竹縣" <c:if test="${membersbean.area eq'新竹縣'}">selected</c:if>>新竹縣</option>
                                                        <option value="桃園市" <c:if test="${membersbean.area eq'桃園市'}">selected</c:if>>桃園市</option>
                                                        <option value="苗栗縣" <c:if test="${membersbean.area eq'苗栗縣'}">selected</c:if>>苗栗縣</option>
                                                        <option value="臺中市" <c:if test="${membersbean.area eq'臺中市'}">selected</c:if>>臺中市</option>
                                                        <option value="彰化縣" <c:if test="${membersbean.area eq'彰化縣'}">selected</c:if>>彰化縣</option>
                                                        <option value="南投縣" <c:if test="${membersbean.area eq'南投縣'}">selected</c:if>>南投縣</option>
                                                        <option value="嘉義市" <c:if test="${membersbean.area eq'嘉義市'}">selected</c:if>>嘉義市</option>
                                                        <option value="嘉義縣" <c:if test="${membersbean.area eq'嘉義縣'}">selected</c:if>>嘉義縣</option>
                                                        <option value="雲林縣" <c:if test="${membersbean.area eq'雲林縣'}">selected</c:if>>雲林縣</option>
                                                        <option value="臺南市" <c:if test="${membersbean.area eq'臺南市'}">selected</c:if>>臺南市</option>
                                                        <option value="高雄市" <c:if test="${membersbean.area eq'高雄市'}">selected</c:if>>高雄市</option>
                                                        <option value="澎湖縣" <c:if test="${membersbean.area eq'澎湖縣'}">selected</c:if>>澎湖縣</option>
                                                        <option value="屏東縣" <c:if test="${membersbean.area eq'屏東縣'}">selected</c:if>>屏東縣</option>
                                                        <option value="臺東縣" <c:if test="${membersbean.area eq'臺東縣'}">selected</c:if>>臺東縣</option>
                                                        <option value="花蓮縣" <c:if test="${membersbean.area eq'花蓮縣'}">selected</c:if>>花蓮縣</option>
                                                        <option value="金門縣" <c:if test="${membersbean.area eq'金門縣'}">selected</c:if>>金門縣</option>
                                                        <option value="連江縣" <c:if test="${membersbean.area eq'連江縣'}">selected</c:if>>連江縣</option>
                                                    </select></div>
                                            </div>

                                        </div>
                                        <div class="row with-small-gap">
                                            <div class="col">
                                                <div class="form-g mb-5"><input type="text" name="address" placeholder="地址"
                                                        required="required" class="form-control valid"
                                                        aria-invalid="false"  value="${membersbean.address}"
                                                        style="font-size: 18px;"></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col">
                                            <div class="form-g"><input id="email" type="email" placeholder="電子信箱"
                                                    name="email" value="${membersbean.email}"
                                                    class="form-control valid" aria-invalid="false"
                                                    style="font-size: 18px; "></div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col mt-5">
                                            <div class="float-right"><input type="submit" value="確定修改"
                                                    class="btn btn-outline-primary btn-lg"
                                                    style="font-size: 18px; font-family:'Courier New', Courier, monospace;"
                                                    href="/ec_p1_main.html"></div>
                                            <div class="clearfix"></div>

                                            <!-- alert待修改 -->
                                            <!-- <div class="alert-modal-style" data-name="">
                                                <div class="modal-body">
                                                    <div class="modal-info text-center">修改完成</div>
                                                    <div class="text-center">
                                                        <a class="btn-close-alert btn btn-secondary w-100" href="#"><span>確定</span></a>
                                                    </div>
                                                </div>
                                            </div> -->
                                            
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- <div class="col-12 col-md-6">

                        <div class="block-widge lh-15">
                            <div class="block-title">
                                <span style="font-family:'Courier New', Courier, monospace; font-size: 16px;"> 
                                    會員級別
                                </span>
                            </div>
                            <div class="vip-block">
                                <div>
                                    <div class="float-left mr-3">
                                        <i class="icon-vip"></i>
                                    </div>
                                    <div class="float-left">
                                        <div class="d-table-cell align-middle" style="height: 40px">
                                            <p style="font-size: 16px; font-family:'Courier New', Courier, monospace;">
                                                您為 <span style="font-weight: bold;">一般會員</span><br>
                                                <br>歡慶開幕，可享有商品九折及免運優惠喔！
                                            </p>
                                        </div>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                                <!-- <div class="mt-3">
                                    <div class="text-gray-700 float-right">
                                        <a href="/faqs">會員升級說明</a>
                                    </div>
                                    <div class="clearfix"></div>
                                </div> -->
                            <!-- </div>
                        </div>
                    </div> --> -->
                </div>
            </div>
        </div>
    </div>


    <!-- ikcare footer -->
    <footer style="background-color: #eee6d3;">
        <div class="container p-4">
            <div class="row">
                <div class="col-lg-2 col-md-12 mb-4">

                </div>

                <div class="col-lg-2 col-md-6 mb-4">
                    <h5 class="mb-3" style="color: #9A6852; font-weight: bold; font-size: 16px; 
                    font-family:'Courier New', Courier, monospace;">購物資訊</h5>

                    <ul class="list-unstyled mb-0" style="font-size: 16px;">
                        <li class="mb-1">
                            <a href="/pages/FAQ">FAQs</a>
                        </li>
                        <li class="mb-1">
                            <a href="/pages/FAQ">How to buy</a>
                        </li>
                    </ul>
                </div>

                <div class="col-lg-2 col-md-6 mb-4">
                    <h5 class="mb-3" style="color: #9A6852; font-weight: bold; font-size: 16px;">I K Care</h5>
                    <ul class="list-unstyled mb-0"
                        style="font-weight: bold; font-size: 16px; font-family:'Courier New', Courier, monospace;">
                        <li class="mb-1">
                            <a href="/pages/aboutus">關於我們</a>
                        </li>
                        <li class="mb-1">
                            <a href="/pages/policy">隱私權政策</a>
                        </li>
                    </ul>
                </div>

                <div class="col-lg-2 col-md-6 mb-4">
                    <h5 class="mb-3"
                        style="color: #9A6852; font-weight: bold; font-size: 16px; font-family:'Courier New', Courier, monospace;">
                        相關網站</h5>
                    <ul class="list-unstyled mb-0"
                        style="font-weight: bold; font-size: 16px; font-family:'Courier New', Courier, monospace;">
                        <li class="mb-1">
                            <a href="#!">國民飲食指標</a>
                        </li>
                        <li class="mb-1">
                            <a href="#!">營養小知識</a>
                        </li>
                    </ul>
                </div>

                <div class="col-lg-3 col-md-6 mb-4">
                    <h5 class="mb-3"
                        style="color: #9A6852; font-weight: bold; font-size: 16px; font-family:'Courier New', Courier, monospace;">
                        聯絡我們</h5>
                    <ul class="list-unstyled mb-0" style="font-size: 16px;">
                        <li class="mb-1">
                            <a href="#!">service@ikcare.com</a>
                        </li>
                        <li class="mb-1">
                            <a href="#!"><img src="../img/facebook_logos_PNG19753.png" type="button" width="30px"></a>
                            <!-- </li>
                        <li class="mb-1"> -->
                            <a href="#!"><img src="../img/instagram.png" type="button" width="30px"></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
            <span style="font-size: 16px;">© 2022 Copyright: </span>
            <a class="text-dark" href="IKcare2.html" style="font-size: 16px;">ikcare.com</a>
        </div>
        <!-- Copyright -->
    </footer>


    <!-- script -->
    <!-- <script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script> -->
    <script type=text/javascript
        src="https://static.tpx.tw/sff/mouggan/static/libs/js/vendors.js?V=20220512v1"></script>

    <script type="text/javascript" src="https://static.tpx.tw/sff/mouggan/js/member.js?v=20220512v1"></script>
    <!-- script -->

    <script type="text/javascript">
        window.userRegion = '';
        window.userCounty = '';
        window.userZipcode = '';
        window.userProvince = '';
        window.userAddress = '';

    </script>

</body>

</html>