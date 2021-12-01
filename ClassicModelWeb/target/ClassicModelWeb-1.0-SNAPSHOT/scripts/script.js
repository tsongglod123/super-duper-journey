function viewCart() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        document.getElementById("view-cart").innerHTML = xhttp.responseText;
        $('#viewCartModal').modal('show');
    }
    xhttp.open("GET", "ViewCart.jsp");
    xhttp.send();
}

function loadHomepage() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        document.getElementById("body-content").innerHTML = this.responseText;
    }
    xhttp.open("GET", "homepage");
    xhttp.send();
}

function loadOffice(officeCode) {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        if (xhttp.status === 200) {
            document.getElementById("body-content").innerHTML = this.responseText;
        } else if (xhttp.status === 401) {
            showLoginForm();
        }
    }
    xhttp.open("GET", "office-list?officeCode=" + officeCode);
    xhttp.send();
}

function loadProduct(page, pageSize = document.getElementById("itemsPage").value) {
    //alert('page: '+ page + ", size: "+ pageSize)
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        document.getElementById("body-content").innerHTML = this.responseText;
    }
    xhttp.open("GET", "product-list?page=" + page + "&pageSize=" + pageSize);
    xhttp.send();
}

function addToCart(productCode) {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        let cartInfo = document.getElementById("noOfItemInCart");
        let noOfItem = xhttp.responseText;
        // alert("Response = "+ noOfItem);
        if (noOfItem > 0) {
            cartInfo.style.display = "inline";
        } else {
            cartInfo.style.display = "none";
        }
        cartInfo.innerHTML = noOfItem;
    }
    xhttp.open("GET", "add-to-cart?productCode=" + productCode);
    xhttp.send();
}

function showLoginForm() {
    let status = document.getElementById("login-menu").innerHTML;
    if (status.includes("Logout")) {
        logout();
    } else {
        $("#modalLoginForm").modal("show");
    }
}

function login(username, password) {
    if (username === '' || password === '' || username === undefined) {
        document.getElementById("login-message").innerHTML = "Invalid username or password.";
    }
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        if (xhttp.status === 200) {
            $("#modalLoginForm").modal("hide");
            document.getElementById("login-menu").innerHTML = "<i class='bi bi-box-arrow-left'></i> Logout";
        } else if (xhttp.status >= 500) {
            document.getElementById("login-message").innerHTML = xhttp.statusText;
        } else {
            document.getElementById("login-message").innerHTML = "Wrong username or password.";
        }
    }
    // let params = "username=" + username + "&password=" + password;
    // xhttp.open("GET", "login?" + params);
    // xhttp.send();
    let urlEncodedData = "", urlEncodedDataPairs = [];
    urlEncodedDataPairs.push(encodeURIComponent("username") + '=' + encodeURIComponent(username));
    urlEncodedDataPairs.push(encodeURIComponent("password") + '=' + encodeURIComponent(password));
    urlEncodedData = urlEncodedDataPairs.join('&').replace(/%20/g, '+');
    xhttp.open("POST", "login");
    xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhttp.send(urlEncodedData);
}

function logout() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        location.reload();
    }
    xhttp.open("GET", "logout");
    xhttp.send();
}