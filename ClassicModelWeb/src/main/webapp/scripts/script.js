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
        document.getElementById("body-content").innerHTML = this.responseText;
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