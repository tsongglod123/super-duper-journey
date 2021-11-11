<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Classic Model</title>
    <script src="./scripts/script.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="./styles/index.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark" id="navbar">
    <div class="container-fluid">
        <a class="navbar-brand text-warning" href="javascript:loadHomepage()">Classic Model</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="javascript:loadOffice('')">Office</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="javascript:loadProduct(1, 15)">Product</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="javascript:void(0)">Order History</a>
                </li>
                <li class="nav-item ml-4">
                    <a class="nav-link text-light" href="#"><i class="bi bi-box-arrow-in-right"></i>Login</a>
                </li>
            </ul>
            <div style="margin-right: 20px">
                <img src="assets/images/cart.png" width="42px" onclick="viewCart()" alt="shopping-cart"/>
                <button id="noOfItemInCart" class="cart-info" onclick="viewCart()"></button>
            </div>
            <form class="d-flex">
                <label>
                    <input class="form-control me-2" type="text" placeholder="Search">
                </label>
                <button class="btn btn-primary" type="button">Search</button>
            </form>
        </div>
    </div>
</nav>
<div class="container" id="body-content">
    <h2 id="title">SIT-202: Classic Model Online</h2>
    <h4 id="sub-title">SIT-202 is a global online marketplace.</h4>
    <p id="details">SIT-202 is a young and dynamic company specialized in the online sale of static collectible models
        and related
        accessories.
        Our location are distributed around the world. <br>
        Welcome to the world of classic cars and antique cars! On our marketplace, we offer a huge assortment of Classic
        Cars from different manufacturers and decades. Horses, flashpoints and stars are popular motives you may
        encounter - Classic Cars were made as lifestyle products once and not just as technical status symbols. Share
        some good taste on the street and show the style you identify with the most. We make it easy to obtain European
        and American cars including insurance and shipping issues.
        The Emergence of a new Cult in Society - Classic Cars as Status Symbols
        In 1885, Carl Benz turned over a new leaf in the history of mobility and was granted a patent for the first
        automobile. The technique evolved with new makes and models like the Ford Tin Lizzie and the Mercedes-Benz 300
        SL over the past 100 years. Some of the tedious models from the past turned into popular classic Car models over
        the years - European cars like the Volkswagen Beetle, Citroen 2CV or Jaguar XK and other "oldies" are good
        examples for this nostalgic value.
        Over 2.500 manufacturers produced a countless number of different car models over the past 100 years. It is not
        that easy to tell what makes a certain car so special, even decades after the production shut down. Sometimes it
        depends on the car body as such, sometimes a famous driver increased the popularity of a certain car model. Good
        examples for cars that made an astonishing image change are the European Opel Kadett or classic muscle cars from
        the US. Those pragmatic but fuel consuming cars were widely disliked for years - today, there is a huge fan
        community for old and restored muscle cars and standard models from Europe and they are popular collectibles for
        every automobile fan.
    </p>
</div>
<%--<c:if test="${cookie.lastpage != null}">--%>
<script>
    window.onload = (ev) => {
        <%--        ${cookie.lastpage.value == "homepage" ?--%>
        <%--        "loadHomepage()" : cookie.lastpage.value == "office-list" ?--%>
        <%--        "loadOffice()" : "loadProduct(1, 15)"}--%>
        addToCart('');
    };
</script>
<%--</c:if>--%>
<div class="modal" tabindex="-1" id="viewCartModal">
    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Your Cart</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"
                        onclick="$('#viewCartModal').modal('hide')">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body" id="view-cart">
                <p>Modal body text goes here.</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>